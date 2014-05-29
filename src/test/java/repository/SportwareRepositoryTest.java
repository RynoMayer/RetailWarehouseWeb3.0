/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package repository;

import com.ryno.retailwarehouseweb3.app.config.ConnectionConfig;
import com.ryno.retailwarehouseweb3.domain.Sportware;
import com.ryno.retailwarehouseweb3.repository.SportwareRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author ryno
 */
public class SportwareRepositoryTest {
    
    private static long id;
    private static ApplicationContext ctx;
    
    private static SportwareRepository repo;
    
    public SportwareRepositoryTest() {
    }
    
        @Test
        public static void createSportware(){
        repo = ctx.getBean(SportwareRepository.class);
        
        List <Sportware> sportswareList = new ArrayList<Sportware>();
        Sportware ware = new Sportware.Builder("ItmB004")
                .setDescrip("shoes")
                .Build();
        
        sportswareList.add(ware);
        
        
        Sportware sport = new Sportware.Builder("Ttmtek403")
                .setBrand("nike")
                .setDescrip("shirt")
                //.setSportswareList(sportswareList)
                .Build();
        
        repo.save(sport);
        id = sport.getId();
        
        Assert.assertNotNull(id);
                
    }
    
    @Test(dependsOnMethods = "createSportware")
    public void readSportware(){
        repo = ctx.getBean(SportwareRepository.class);
        Sportware ware = repo.findOne(id);
        Assert.assertEquals(ware.getBrand(), "nike");
    }
    
    @Test(dependsOnMethods = "createSportware")
    private void updateSportware(){
        repo = ctx.getBean(SportwareRepository.class);
        
        Sportware ware = repo.findOne(id);
        Sportware sportUpdate = new Sportware.Builder(ware.getBarcode())
                .Sportware(ware)
                .setBrand("Gucci")
                .Build();
        
        repo.save(sportUpdate);
    }
    
    @Test(dependsOnMethods = "readSportware")
    private void deleteSportware(){
        repo = ctx.getBean(SportwareRepository.class);
        repo.delete(id);
        Sportware ware = repo.findOne(id);
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
