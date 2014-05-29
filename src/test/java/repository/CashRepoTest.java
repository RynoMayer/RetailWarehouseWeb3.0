/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package repository;

import com.ryno.retailwarehouseweb3.app.config.ConnectionConfig;
import com.ryno.retailwarehouseweb3.domain.Cash;
import com.ryno.retailwarehouseweb3.repository.CashRepo;
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
public class CashRepoTest {
    private static ApplicationContext ctx;
    private static Long id;
    private static CashRepo repo;
    public CashRepoTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

     @Test
        public static void createCash(){
        repo = ctx.getBean(CashRepo.class);
       
        Cash Cash1 = new Cash.Builder(500.0, "blue")
                .build();
        
        repo.save(Cash1);
        id = Cash1.getId();
        
        Assert.assertNotNull(id);
                
    }
    
    @Test(dependsOnMethods = "createCash")
    public void readCash(){
        repo = ctx.getBean(CashRepo.class);
        Cash Cash1 = repo.findOne(id);
        Assert.assertEquals(Cash1.getAmount(), 500.0);
    }
    
    @Test(dependsOnMethods = "createCash")
    private void updateCash(){
        repo = ctx.getBean(CashRepo.class);
        
        Cash Cash1 = repo.findOne(id);
        Cash CashUpdate = new Cash.Builder(Cash1.getAmount(),Cash1.getColor())
                .setAmt(100.0)
                .build();
        
        repo.save(CashUpdate);
    }
    
    @Test(dependsOnMethods = "readCash")
    private void deleteCash(){
        repo = ctx.getBean(CashRepo.class);
        repo.delete(id);
        Cash Cash1 = repo.findOne(id);
        Assert.assertNull(Cash1);
        
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
