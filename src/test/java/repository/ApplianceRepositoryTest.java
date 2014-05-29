/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package repository;

import com.ryno.retailwarehouseweb3.app.config.ConnectionConfig;
import com.ryno.retailwarehouseweb3.domain.Appliance;
import com.ryno.retailwarehouseweb3.repository.ApplianceRepository;
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
 * @author Ryno
 */
public class ApplianceRepositoryTest {
private static ApplicationContext ctx;
    private static Long id;
    private static ApplianceRepository repo;    
    public ApplianceRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @Test
        public static void createAppliance(){
        repo = ctx.getBean(ApplianceRepository.class);
       
        Appliance app = new Appliance.Builder("ItmMicro65")
                .descrip("microwave")
                .brand("kelvin")
                .Build();
        
        repo.save(app);
        id = app.getId();
        
        Assert.assertNotNull(id);
                 app = new Appliance.Builder("Itmfri95")
                .descrip("fridge")
                .brand("Samsung")
                .Build();
        
        repo.save(app);
    }
    
    @Test(dependsOnMethods = "createAppliance")
    public void readAppliance(){
        repo = ctx.getBean(ApplianceRepository.class);
        Appliance app = repo.findOne(id);
        Assert.assertEquals(app.getBrand(), "kelvin");
    }
    
    @Test(dependsOnMethods = "createAppliance")
    private void updateAppliance(){
        repo = ctx.getBean(ApplianceRepository.class);
        
        Appliance app = repo.findOne(id);
        Appliance appUpdate = new Appliance.Builder(app.getBarcode())
                .brand("miller")
                .descrip("oven")
                .Build();
        
        repo.save(appUpdate);
    }
    
    @Test(dependsOnMethods = "readAppliance")
    private void deleteAppliance(){
        repo = ctx.getBean(ApplianceRepository.class);
        repo.delete(id);
        Appliance app = repo.findOne(id);
        Assert.assertNull(app);
        
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
