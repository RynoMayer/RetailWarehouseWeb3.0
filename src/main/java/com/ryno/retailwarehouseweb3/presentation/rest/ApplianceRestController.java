/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ryno.retailwarehouseweb3.presentation.rest;
import com.ryno.retailwarehouseweb3.domain.Appliance;
import com.ryno.retailwarehouseweb3.service.ApplianceBrandService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 *
 * @author Ryno
 */
    @Controller  // Annotation to make this class be detectable by the config as a controller
@RequestMapping(value = "api/app") // This the url e.g http://localhost:8084/askweb/api/club
public class ApplianceRestController {
    @Autowired
    private ApplianceBrandService appService;
    

    @RequestMapping(value = "create",method = RequestMethod.POST) // This the uri e.g http://localhost:8084/askweb/api/club/create
    @ResponseBody //Converts output or response to JSON String
    public String create(@RequestBody Appliance app) { // @RequestBody for converting incoming JSON call to Object
        appService.persists(app);
        
        System.out.println(" Create the Called ");
        return "Appliance Created";
    }

    @RequestMapping(value = "update",method = RequestMethod.PUT) //This the uri e.g http://localhost:8084/askweb/api/club/update
    @ResponseBody
    public String update(@RequestBody Appliance app) {
        appService.merge(app);
        System.out.println(" Update Called ");
        return "App Update";
    }

    @RequestMapping(value = "id/{id}",method = RequestMethod.GET) //http://localhost:8084/askweb/api/club/1234
    @ResponseBody
    public Appliance getAppliance(@PathVariable Long id) { //@PathVariable used to bind the id value
        
        System.out.println(" ID called ");
        return appService.find(id);
    }

    @RequestMapping(value = "appliances",method = RequestMethod.GET) // Always Put HTTP Method
    @ResponseBody
    public List<Appliance> getAppliances() {
        System.out.println("The Appliances");
        return appService.findAll();
    }

    @RequestMapping(value = "starts/{letter}",method = RequestMethod.GET) //http://localhost:8084/askweb/api/club/football
    @ResponseBody
    public Appliance getBrandStart(@PathVariable String letter) {
        Appliance app = appService.getBrandStart(letter); // Call the Service;
        if(app!=null){
            return app;
        }
        return null;
    }

}
