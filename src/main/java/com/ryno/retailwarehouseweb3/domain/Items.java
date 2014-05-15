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
public class Items implements Serializable{
    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String descrip;
    private String barcode;
    
    public String getDescrip(){
        return descrip;
    }
    public String getBarcode(){
        return barcode;
    }
    
    public Long getId(){
        return id;
    }
    
    private Items(){};
    
    private Items(Builder build){
        this.barcode=build.barcode;
        this.descrip=build.descrip;
        this.id=build.id;
    }
    
    private Items(Items build){
        this.barcode=build.barcode;
        this.descrip=build.descrip;
        this.id=build.id;
    }
    
    public static class Builder{
        private String descrip;
        private String barcode;
        private Long id;
        
        public Builder(String bcode){
            this.barcode=bcode;
        }
        
        public Builder descrip(String dsc){
            this.descrip=dsc;
            return this;
        }
        
        public Items build(){
            return new Items(this);
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final Items other = (Items) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Items{" + "id=" + id + '}';
    }
    
}
