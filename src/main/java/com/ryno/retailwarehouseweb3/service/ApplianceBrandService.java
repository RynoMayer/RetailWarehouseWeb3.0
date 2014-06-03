/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ryno.retailwarehouseweb3.service;

import com.ryno.retailwarehouseweb3.domain.Appliance;
import java.util.List;

/**
 *
 * @author Ryno
 */
public interface ApplianceBrandService extends Service<Appliance, Long>{
    public Appliance getBrandStart(String letter);
    
}
