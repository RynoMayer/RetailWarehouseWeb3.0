/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package repository;

import com.ryno.retailwarehouseweb3.app.config.ConnectionConfig;
import com.ryno.retailwarehouseweb3.repository.ItemRepository;
import com.ryno.retailwarehouseweb3.domain.Item;
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
public class ItemRepoTest {
     private static ApplicationContext ctx;
    private static Long id;
    private static ItemRepository repo;
    public ItemRepoTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @Test
        public static void createItem(){
        repo = ctx.getBean(ItemRepository.class);
       
        Item ItemA = new Item.ItemBuilder("ItmOven75")
                .setType("appliance")
                .build();
        
        repo.save(ItemA);
        id = ItemA.getId();
        
        Assert.assertNotNull(id);
                
    }
    
    @Test(dependsOnMethods = "createItem")
    public void readItem(){
        repo = ctx.getBean(ItemRepository.class);
        Item ItemA = repo.findOne(id);
        Assert.assertEquals(ItemA.getType(), "appliance");
    }
    
    @Test(dependsOnMethods = "createItem")
    private void updateItem(){
        repo = ctx.getBean(ItemRepository.class);
        
        Item ItemA = repo.findOne(id);
        Item ItemUpdate = new Item.ItemBuilder(ItemA.getBarcode())
                .setType("stationary")
                .build();
        
        repo.save(ItemUpdate);
    }
    
    @Test(dependsOnMethods = "readItem")
    private void deleteItem(){
        repo = ctx.getBean(ItemRepository.class);
        repo.delete(id);
        Item ItemA = repo.findOne(id);
        Assert.assertNull(ItemA);
        
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
