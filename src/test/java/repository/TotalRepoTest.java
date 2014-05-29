/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package repository;

import com.ryno.retailwarehouseweb3.app.config.ConnectionConfig;
import com.ryno.retailwarehouseweb3.domain.Total;
import com.ryno.retailwarehouseweb3.repository.TotalRepo;
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
public class TotalRepoTest {
    private static ApplicationContext ctx;
    private static Long id;
    private static TotalRepo repo;
    public TotalRepoTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

     @Test
        public static void createTotal(){
        repo = ctx.getBean(TotalRepo.class);
       
        Total Total2 = new Total.Builder(660.50)
                .build();
        
        repo.save(Total2);
        id = Total2.getId();
        
        Assert.assertNotNull(id);
                
    }
    
    @Test(dependsOnMethods = "createTotal")
    public void readTotal(){
        repo = ctx.getBean(TotalRepo.class);
        Total Total2 = repo.findOne(id);
        Assert.assertEquals(Total2.getAmount(), 660.50);
    }
    
    @Test(dependsOnMethods = "createTotal")
    private void updateTotal(){
        repo = ctx.getBean(TotalRepo.class);
        
        Total Total2 = repo.findOne(id);
        Total TotalUpdate = new Total.Builder(Total2.getAmount())
                .setAmt(155.80)
                .build();
        
        repo.save(TotalUpdate);
    }
    
    @Test(dependsOnMethods = "readTotal")
    private void deleteTotal(){
        repo = ctx.getBean(TotalRepo.class);
        repo.delete(id);
        Total Total2 = repo.findOne(id);
        Assert.assertNull(Total2);
        
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
