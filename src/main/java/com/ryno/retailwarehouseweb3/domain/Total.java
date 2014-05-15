/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ryno.retailwarehouseweb3.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 *
 * @author ryno
 */
@Entity
public class Total implements Serializable{
    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double amount;
    //GET+SET   
    public double getAmount(){
        return amount;
    }
    public Long getId(){
        return id;
    }
    private Total(){};
    private Total(Builder build){
        this.amount=build.amount; 
        this.id=build.id;
    }
    private Total(Total item){
        this.amount=item.amount; 
        this.id=item.id;
    }
    
    public static class Builder{
        private double amount;
        private Long id;
        
        public Builder(double amt){
            this.amount=amt;
        }
        
        public Builder setAmt(double amt){
            this.amount=amt;
            return this;
        }

        
        public Builder Total(Total build){
        this.amount=build.amount;
        this.id=build.id;
        return this;
    }
        
        public Total build(){
            return new Total(this);
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Total other = (Total) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Total{" + "id=" + id + '}';
    }
    
}
