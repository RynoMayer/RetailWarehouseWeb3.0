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
    public List<Appliance> findAll() {
        return appRepo.findAll(); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Appliance getBrandStart(String letter){
        List<Appliance> allApps = appRepo.findAll();
        Appliance applFound=null;
        
        
        for(Appliance app : allApps){
            if(app.getBrand().startsWith(letter.toUpperCase()) || app.getBrand().startsWith(letter.toLowerCase())  ){
               applFound= app;
            }
        }
        return applFound;
    }

    @Override
    public int getNumberOfAppliances() {
          List<Appliance> allApps = findAll();
        return allApps.size();
    }

    @Override
    public Appliance find(Long id) {
        return appRepo.findOne(id);
    }

    @Override
    public Appliance persists(Appliance entity) {
        return appRepo.save(entity);
    }

    @Override
    public Appliance merge(Appliance entity) {
        if (entity.getId() != null) {
            return appRepo.save(entity);
        }
        return null;
    }

    @Override
    public void remove(Appliance entity) {
        appRepo.delete(entity);
    }
}