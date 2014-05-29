/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package repository;

import com.ryno.retailwarehouseweb3.app.config.ConnectionConfig;
import com.ryno.retailwarehouseweb3.domain.Receipt;
import com.ryno.retailwarehouseweb3.repository.ReceiptRepository;
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
public class ReceiptRepoTest {
    private static ApplicationContext ctx;
    private static Long id;
    private static ReceiptRepository repo;
    public ReceiptRepoTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @Test
        public static void createReceipt(){
        repo = ctx.getBean(ReceiptRepository.class);
       
        Receipt man = new Receipt.Builder().setDescr("choc").setPrice(5.00).setQty(5)
                .build();
        
        repo.save(man);
        id = man.getId();
        
        Assert.assertNotNull(id);
                
    }
    
    @Test(dependsOnMethods = "createReceipt")
    public void readReceipt(){
        repo = ctx.getBean(ReceiptRepository.class);
        Receipt man = repo.findOne(id);
        Assert.assertEquals(man.getPrice(), 5.00);
    }
    
    @Test(dependsOnMethods = "createReceipt")
    private void updateReceipt(){
        repo = ctx.getBean(ReceiptRepository.class);
        
        Receipt man = repo.findOne(id);
        Receipt manUpdate = new Receipt.Builder()
                .setDescr("john")
                .build();
        
        repo.save(manUpdate);
    }
    
    @Test(dependsOnMethods = "readReceipt")
    private void deleteReceipt(){
        repo = ctx.getBean(ReceiptRepository.class);
        repo.delete(id);
        Receipt man = repo.findOne(id);
        Assert.assertNull(man);
        
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
