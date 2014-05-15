/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ryno.retailwarehouseweb3.repository;

/**
 *
 * @author Ryno
 */
import com.ryno.retailwarehouseweb3.domain.Cash;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author ryno
 */
@Repository
public interface CashRepo extends JpaRepository<Cash, Long>{
    
}
