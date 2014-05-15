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
public class Stationary implements Serializable{
    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String barcode;
    private String descrip;
    private String brand;
    
    private Stationary(){};
    
    public String Types(){
        return "Stationary";
    }
    
    public Long getId(){
        return id;
    }
    public String getBarcode(){
        return barcode;
    }
    public String getDescrip(){
        return descrip;
    }
    public String getBrand(){
        return brand;
    }
    
    private Stationary(Builder build){
        this.barcode=build.barcode;
        this.brand=build.brand;
        this.descrip=build.descrip;
        this.id=build.id;
    }
    
    private Stationary (Stationary item){
        this.barcode=item.barcode;
        this.brand=item.brand;
        this.descrip=item.descrip;
        this.id=item.id;
    }
    
    public static class Builder{
        private String barcode;
        private String descrip;
        private String brand;    
        private Long id;
        
        public Builder(String bcode){
            this.barcode=bcode;
        }
        
        public Builder descrip(String descr){
            descrip=descr;
            return this;
        }
        
        public Builder brand(String br){
            brand=br;
            return this;
        }
        
        public Builder Stationary (Stationary item){
        this.barcode=item.barcode;
        this.brand=item.brand;
        this.descrip=item.descrip;
        this.id=item.id;
        return this;
    }
        public Stationary Build(){
            return new Stationary(this);
        }
    }

    @Override
    public String toString() {
        return "Stationary{" + "id=" + id + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final Stationary other = (Stationary) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
