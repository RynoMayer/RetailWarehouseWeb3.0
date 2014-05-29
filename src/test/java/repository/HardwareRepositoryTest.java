/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package repository;


import com.ryno.retailwarehouseweb3.app.config.ConnectionConfig;
import com.ryno.retailwarehouseweb3.domain.Hardware;
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
 * @author Ryno
 */
public class HardwareRepositoryTest {
    
    private static ApplicationContext ctx;
    private static Long id;
    private static HardwareRepository repo;
    
    public HardwareRepositoryTest() {
    }
    
        @Test
        public static void createHardware(){
        repo = ctx.getBean(HardwareRepository.class);
       
        Hardware hware = new Hardware.Builder("Itmhammer75")
                .descrip("claw hammer")
                .brand("stahl")
                .Build();
        
        repo.save(hware);
        id = hware.getId();
        
        Assert.assertNotNull(id);
                
    }
    
    @Test(dependsOnMethods = "createHardware")
    public void readHardware(){
        repo = ctx.getBean(HardwareRepository.class);
        Hardware hware = repo.findOne(id);
        Assert.assertEquals(hware.getBrand(), "stahl");
    }
    
    @Test(dependsOnMethods = "createHardware")
    private void updateHardware(){
        repo = ctx.getBean(HardwareRepository.class);
        
        Hardware hware = repo.findOne(id);
        Hardware hardUpdate = new Hardware.Builder(hware.getBarcode())
                .brand("PPC")
                .Build();
        
        repo.save(hardUpdate);
    }
    
    @Test(dependsOnMethods = "readHardware")
    private void deleteHardware(){
        repo = ctx.getBean(HardwareRepository.class);
        repo.delete(id);
        Hardware ware = repo.findOne(id);
        Assert.assertNull(ware);
        
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
