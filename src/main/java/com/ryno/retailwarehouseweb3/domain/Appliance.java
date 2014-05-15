/*
 * To change this template, choose Tools | Templates
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
public class Appliance implements Serializable{
    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String barcode;
    private String descrip;
    private String brand;
    
    public String Types(){
        return "appliance";
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
    
    public Long getId(){
        return id;
    }
    private Appliance(){};
    
    private Appliance(Builder build){
        this.barcode=build.barcode;
        this.brand=build.brand;
        this.descrip=build.descrip;
        this.id=build.id;
    }
    
    private Appliance (Appliance item){
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
        
        public Builder Appliance (Appliance app){
            this.barcode=app.barcode;
            this.brand=app.brand;
            this.descrip=app.descrip;
            this.id=app.id;
            return this;
        } 
        
        public Appliance Build(){
            return new Appliance(this);
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final Appliance other = (Appliance) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Appliance{" + "id=" + id + '}';
    }
    
}
