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
public class Cash implements Serializable{
    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double amount;
    private String color;

    public double getAmount(){
        return amount;
    }
    public String getColor(){
        return color;
    }
    
    public Long getId(){
        return id;
    }
    private Cash(){};
    private Cash(Builder build){
        this.amount=build.amount;
        this.color=build.color;
        this.id=build.id;
    }
    private Cash(Cash build){
        amount=build.amount;
        color=build.color;
        this.id=build.id;
    }
    public static class Builder{
        private double amount;
        private String color;
        private Long id;
        
        public Builder(double amt, String col){
            this.amount=amt;
            this.color=col;
        }
        
        public Builder setAmt(double amt){
            this.amount=amt;
            return this;
        }
        
        public Builder Cash(Cash build){
        this.amount=build.amount;
        this.color=build.color;
        this.id=build.id;
        return this;
    }
        
        public Cash build(){
            return new Cash(this);
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.id);
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
        final Cash other = (Cash) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cash{" + "id=" + id + '}';
    }
    
}
