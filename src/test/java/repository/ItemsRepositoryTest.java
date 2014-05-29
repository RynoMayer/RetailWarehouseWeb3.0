/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package repository;

import com.ryno.retailwarehouseweb3.app.config.ConnectionConfig;
import com.ryno.retailwarehouseweb3.domain.Items;
import com.ryno.retailwarehouseweb3.repository.ItemsRepository;
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
public class ItemsRepositoryTest {
     private static ApplicationContext ctx;
    private static Long id;
    private static ItemsRepository repo;
    public ItemsRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @Test
        public static void createItems(){
        repo = ctx.getBean(ItemsRepository.class);
       
        Items ItemsB = new Items.Builder("ItmShoe75")
                .descrip("Trainer")
                .build();
        
        repo.save(ItemsB);
        id = ItemsB.getId();
        
        Assert.assertNotNull(id);
                
    }
    
    @Test(dependsOnMethods = "createItems")
    public void readItems(){
        repo = ctx.getBean(ItemsRepository.class);
        Items ItemsB = repo.findOne(id);
        Assert.assertEquals(ItemsB.getDescrip(), "Trainer");
    }
    
    @Test(dependsOnMethods = "createItems")
    private void updateItems(){
        repo = ctx.getBean(ItemsRepository.class);
        
        Items ItemsB = repo.findOne(id);
        Items ItemsUpdate = new Items.Builder(ItemsB.getBarcode())
                .descrip("Tekkie")
                .build();
        
        repo.save(ItemsUpdate);
    }
    
    @Test(dependsOnMethods = "readItems")
    private void deleteItems(){
        repo = ctx.getBean(ItemsRepository.class);
        repo.delete(id);
        Items ItemsB = repo.findOne(id);
        Assert.assertNull(ItemsB);
        
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
