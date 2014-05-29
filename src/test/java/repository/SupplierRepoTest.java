/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package repository;

import com.ryno.retailwarehouseweb3.app.config.ConnectionConfig;
import com.ryno.retailwarehouseweb3.domain.Supplier;
import com.ryno.retailwarehouseweb3.repository.SupplierRepository;
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
public class SupplierRepoTest {
     private static ApplicationContext ctx;
    private static Long id;
    private static SupplierRepository repo;
    public SupplierRepoTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @Test
        public static void createSupplier(){
        repo = ctx.getBean(SupplierRepository.class);
       
        Supplier supp = new Supplier.Builder("HDTV")
                .setCompany("LG")
                .build();
        
        repo.save(supp);
        id = supp.getId();
        
        Assert.assertNotNull(id);
                
    }
    
    @Test(dependsOnMethods = "createSupplier")
    public void readSupplier(){
        repo = ctx.getBean(SupplierRepository.class);
        Supplier supp = repo.findOne(id);
        Assert.assertEquals(supp.getType(), "HDTV");
    }
    
    @Test(dependsOnMethods = "createSupplier")
    private void updateSupplier(){
        repo = ctx.getBean(SupplierRepository.class);
        
        Supplier supp = repo.findOne(id);
        Supplier suppUpdate = new Supplier.Builder(supp.getType())
                .setCompany("samsung")
                .build();
        
        repo.save(suppUpdate);
    }
    
    @Test(dependsOnMethods = "readSupplier")
    private void deleteSupplier(){
        repo = ctx.getBean(SupplierRepository.class);
        repo.delete(id);
        Supplier supp = repo.findOne(id);
        Assert.assertNull(supp);
        
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
