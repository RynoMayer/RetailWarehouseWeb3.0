/*
 * To Change this license header, choose License Headers in Project Properties.
 * To Change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package repository;

import com.ryno.retailwarehouseweb3.app.config.ConnectionConfig;
import com.ryno.retailwarehouseweb3.domain.Change;
import com.ryno.retailwarehouseweb3.repository.ChangeRepo;
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
public class ChangeRepoTest {
    private static ApplicationContext ctx;
    private static Long id;
    private static ChangeRepo repo;
    public ChangeRepoTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
        public static void createChange(){
        repo = ctx.getBean(ChangeRepo.class);
       
        Change Change2 = new Change.Builder(23.05)
                .build();
        
        repo.save(Change2);
        id = Change2.getId();
        
        Assert.assertNotNull(id);
                
    }
    
    @Test(dependsOnMethods = "createChange")
    public void readChange(){
        repo = ctx.getBean(ChangeRepo.class);
        Change Change2 = repo.findOne(id);
        Assert.assertEquals(Change2.getAmount(), 23.05);
    }
    
    @Test(dependsOnMethods = "createChange")
    private void updateChange(){
        repo = ctx.getBean(ChangeRepo.class);
        
        Change Change2 = repo.findOne(id);
        Change cashUpdate = new Change.Builder(Change2.getAmount())
                .setAmt(55.80)
                .build();
        
        repo.save(cashUpdate);
    }
    
    @Test(dependsOnMethods = "readChange")
    private void deleteChange(){
        repo = ctx.getBean(ChangeRepo.class);
        repo.delete(id);
        Change Change2 = repo.findOne(id);
        Assert.assertNull(Change2);
        
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
