/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ryno.retailwarehouseweb3.service.impl;

import com.ryno.retailwarehouseweb3.domain.Appliance;
import com.ryno.retailwarehouseweb3.repository.ApplianceRepository;
import com.ryno.retailwarehouseweb3.service.ApplianceBrandService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ryno
 */
@Service
public class ApplianceBrandServiceImpl implements ApplianceBrandService {
    
    @Autowired
    private ApplianceRepository appRepo; 
    
    @Override
    public List <Appliance> getBrandStart(String letter){
        List<Appliance> apps = new ArrayList<>();
        List<Appliance> allApps = appRepo.findAll();
        
        /*for (Person person : allPersons) {
            if (person.getAge() > age) {
                persons.add(person);
            }
        }
        return persons;*/
        
        for(Appliance app : allApps){
            if(app.getBrand().startsWith(letter.toUpperCase()) || app.getBrand().startsWith(letter.toLowerCase())  ){
                apps.add(app);
            }
        }
        return apps;
    }
}
