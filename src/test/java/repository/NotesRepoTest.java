/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package repository;

import com.ryno.retailwarehouseweb3.app.config.ConnectionConfig;
import com.ryno.retailwarehouseweb3.domain.Notes;
import com.ryno.retailwarehouseweb3.repository.NotesRepository;
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
public class NotesRepoTest {
    private static ApplicationContext ctx;
    private static Long id;
    private static NotesRepository repo;
    public NotesRepoTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @Test
        public static void createManager(){
        repo = ctx.getBean(NotesRepository.class);
       
        Notes note = new Notes.Builder("$", 200)
                .build();
        
        repo.save(note);
        id = note.getId();
        
        Assert.assertNotNull(id);
                
    }
    
    @Test(dependsOnMethods = "createManager")
    public void readManager(){
        repo = ctx.getBean(NotesRepository.class);
        Notes note = repo.findOne(id);
        Assert.assertEquals(note.getAbbv(), "$");
    }
    
    @Test(dependsOnMethods = "createManager")
    private void updateManager(){
        repo = ctx.getBean(NotesRepository.class);
        
        Notes note = repo.findOne(id);
        Notes noteUpdate = new Notes.Builder(note.getAbbv(),note.getValue())
                .setAbbr("%")
                .build();
        
        repo.save(noteUpdate);
    }
    
    @Test(dependsOnMethods = "readManager")
    private void deleteManager(){
        repo = ctx.getBean(NotesRepository.class);
        repo.delete(id);
        Notes note = repo.findOne(id);
        Assert.assertNull(note);
        
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
