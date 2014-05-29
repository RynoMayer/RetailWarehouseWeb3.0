/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package repository;

import com.ryno.retailwarehouseweb3.app.config.ConnectionConfig;
import com.ryno.retailwarehouseweb3.domain.Stocker;
import com.ryno.retailwarehouseweb3.repository.StockerRepository;
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
public class StockerRepoTest {
    private static ApplicationContext ctx;
    private static Long id;
    private static StockerRepository repo;
    public StockerRepoTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @Test
        public static void createStocker(){
        repo = ctx.getBean(StockerRepository.class);
       
        Stocker Stocker = new Stocker.Builder("dan", "789", 1500.00)
                .Build();
        
        repo.save(Stocker);
        id = Stocker.getId();
        
        Assert.assertNotNull(id);
                
    }
    
    @Test(dependsOnMethods = "createStocker")
    public void readStocker(){
        repo = ctx.getBean(StockerRepository.class);
        Stocker Stocker = repo.findOne(id);
        Assert.assertEquals(Stocker.getEmpNum(), "789");
    }
    
    @Test(dependsOnMethods = "createStocker")
    private void updateStocker(){
        repo = ctx.getBean(StockerRepository.class);
        
        Stocker Stocker = repo.findOne(id);
        Stocker StockerUpdate = new Stocker.Builder(Stocker.getName(), Stocker.getEmpNum(), Stocker.returnSalary())
                .setSalary(2001.00)
                .Build();
        
        repo.save(StockerUpdate);
    }
    
    @Test(dependsOnMethods = "readStocker")
    private void deleteStocker(){
        repo = ctx.getBean(StockerRepository.class);
        repo.delete(id);
        Stocker Stocker = repo.findOne(id);
        Assert.assertNull(Stocker);
        
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
