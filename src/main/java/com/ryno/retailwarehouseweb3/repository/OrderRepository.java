/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ryno.retailwarehouseweb3.repository;

import com.ryno.retailwarehouseweb3.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author ryno
 */
@Repository
public interface OrderRepository extends JpaRepository<Orders, Long>{
    
}
