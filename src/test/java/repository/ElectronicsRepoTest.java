/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package repository;

import com.ryno.retailwarehouseweb3.app.config.ConnectionConfig;
import com.ryno.retailwarehouseweb3.domain.Electronics;
import com.ryno.retailwarehouseweb3.repository.ElectronicsRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author ryno
 */
public class ElectronicsRepoTest {
     private static ApplicationContext ctx;
    private static Long id;
    private static ElectronicsRepository repo;
    public ElectronicsRepoTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @Test
        public static void createElectronics(){
        repo = ctx.getBean(ElectronicsRepository.class);
       
        Electronics elect = new Electronics.Builder("ItmTV12")
                .descrip("plasma 50")
                .brand("LG")
                .Build();
        
        repo.save(elect);
        id = elect.getId();
        
        Assert.assertNotNull(id);
                
    }
    
    @Test(dependsOnMethods = "createElectronics")
    public void readElectronics(){
        repo = ctx.getBean(ElectronicsRepository.class);
        Electronics elect = repo.findOne(id);
        Assert.assertEquals(elect.getBrand(), "LG");
    }
    
    @Test(dependsOnMethods = "createElectronics")
    private void updateElectronics(){
        repo = ctx.getBean(ElectronicsRepository.class);
        
        Electronics elect = repo.findOne(id);
        Electronics electUpdate = new Electronics.Builder(elect.getBarcode())
                .brand("panasonic")
                .descrip("HDTV")
                .Build();
        
        repo.save(electUpdate);
    }
    
    @Test(dependsOnMethods = "readElectronics")
    private void deleteElectronics(){
        repo = ctx.getBean(ElectronicsRepository.class);
        repo.delete(id);
        Electronics elect = repo.findOne(id);
        Assert.assertNull(elect);
        
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
         ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
