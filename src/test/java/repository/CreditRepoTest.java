/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package repository;

import com.ryno.retailwarehouseweb3.app.config.ConnectionConfig;
import com.ryno.retailwarehouseweb3.domain.Credit;
import com.ryno.retailwarehouseweb3.repository.CreditRepository;
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
public class CreditRepoTest {
    private static ApplicationContext ctx;
    private static Long id;
    private static CreditRepository repo;
    public CreditRepoTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @Test
        public static void createCredit(){
        repo = ctx.getBean(CreditRepository.class);
       
        Credit card = new Credit.Builder(550.0, 987456)
                .setBank("FNB")
                .build();
        
        repo.save(card);
        id = card.getId();
        
        Assert.assertNotNull(id);
                
    }
    
    @Test(dependsOnMethods = "createCredit")
    public void readCredit(){
        repo = ctx.getBean(CreditRepository.class);
        Credit card = repo.findOne(id);
        Assert.assertEquals(card.getAmount(), 550.0);
    }
    
    @Test(dependsOnMethods = "createCredit")
    private void updateCredit(){
        repo = ctx.getBean(CreditRepository.class);
        
        Credit card = repo.findOne(id);
        Credit cardUpdate = new Credit.Builder(card.getAmount(),card.getCardNum())
                .setBank("absa")
                .build();
        
        repo.save(cardUpdate);
    }
    
    @Test(dependsOnMethods = "readCredit")
    private void deleteCredit(){
        repo = ctx.getBean(CreditRepository.class);
        repo.delete(id);
        Credit card = repo.findOne(id);
        Assert.assertNull(card);
        
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
