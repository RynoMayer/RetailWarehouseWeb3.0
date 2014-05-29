/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package repository;

import com.ryno.retailwarehouseweb3.app.config.ConnectionConfig;
import com.ryno.retailwarehouseweb3.domain.Cashier;
import com.ryno.retailwarehouseweb3.repository.CashierRepository;
import com.ryno.retailwarehouseweb3.repository.HardwareRepository;
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
public class CashierRepoTest {
    private static ApplicationContext ctx;
    private static Long id;
    private static CashierRepository repo;
    public CashierRepoTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @Test
        public static void createCashier(){
        repo = ctx.getBean(CashierRepository.class);
       
        Cashier cash = new Cashier.Builder("jake", "2120", 2000.00)
                .Build();
        
        repo.save(cash);
        id = cash.getId();
        
        Assert.assertNotNull(id);
                
    }
    
    @Test(dependsOnMethods = "createCashier")
    public void readCashier(){
        repo = ctx.getBean(CashierRepository.class);
        Cashier cash = repo.findOne(id);
        Assert.assertEquals(cash.getEmpNum(), "2120");
    }
    
    @Test(dependsOnMethods = "createCashier")
    private void updateCashier(){
        repo = ctx.getBean(CashierRepository.class);
        
        Cashier cash = repo.findOne(id);
        Cashier cashUpdate = new Cashier.Builder(cash.getName(), cash.getEmpNum(), cash.returnSalary())
                .setName("bob")
                .Build();
        
        repo.save(cashUpdate);
    }
    
    @Test(dependsOnMethods = "readCashier")
    private void deleteCashier(){
        repo = ctx.getBean(CashierRepository.class);
        repo.delete(id);
        Cashier cash = repo.findOne(id);
        Assert.assertNull(cash);
        
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
