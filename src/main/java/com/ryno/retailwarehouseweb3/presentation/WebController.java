/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ryno.retailwarehouseweb3.presentation;

import com.ryno.retailwarehouseweb3.domain.Appliance;
import com.ryno.retailwarehouseweb3.service.ApplianceBrandService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Ryno
 */
@Controller
public class WebController {
    @Autowired
    private ApplianceBrandService appBrandService;
    //@RequestMapping(value = "cput",method = RequestMethod.GET)
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String getIndex(){
        return "index";
    }
    
    @RequestMapping(value = "Samsung", method = RequestMethod.GET)
    
    public String getHome(){
        Appliance apps = appBrandService.getBrandStart("s");
        System.out.println("Samsung controller was hit" +apps.Types());
        return "Samsung";
    }
    @RequestMapping(value = "Appls", method = RequestMethod.GET)
    public String getApps(Model model){
        
        model.addAttribute("description1", "this is appliance description");
        return "Appls";
    }
}

