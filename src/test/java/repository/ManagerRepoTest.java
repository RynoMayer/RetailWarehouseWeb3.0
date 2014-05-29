/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package repository;

import com.ryno.retailwarehouseweb3.app.config.ConnectionConfig;
import com.ryno.retailwarehouseweb3.repository.ManagerRepository;
import com.ryno.retailwarehouseweb3.domain.Manager;
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
public class ManagerRepoTest {
    private static ApplicationContext ctx;
    private static Long id;
    private static ManagerRepository repo;
    public ManagerRepoTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
        @Test
        public static void createManager(){
        repo = ctx.getBean(ManagerRepository.class);
       
        Manager man = new Manager.Builder("ryno", "007", 50000.00)
                .Build();
        
        repo.save(man);
        id = man.getId();
        
        Assert.assertNotNull(id);
                
    }
    
    @Test(dependsOnMethods = "createManager")
    public void readManager(){
        repo = ctx.getBean(ManagerRepository.class);
        Manager man = repo.findOne(id);
        Assert.assertEquals(man.getName(), "ryno");
    }
    
    @Test(dependsOnMethods = "createManager")
    private void updateManager(){
        repo = ctx.getBean(ManagerRepository.class);
        
        Manager man = repo.findOne(id);
        Manager manUpdate = new Manager.Builder(man.getName(),man.getEmpNum(), man.returnSalary())
                .setName("john")
                .Build();
        
        repo.save(manUpdate);
    }
    
    @Test(dependsOnMethods = "readManager")
    private void deleteManager(){
        repo = ctx.getBean(ManagerRepository.class);
        repo.delete(id);
        Manager man = repo.findOne(id);
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
