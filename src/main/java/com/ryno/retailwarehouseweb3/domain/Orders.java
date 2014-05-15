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
public class Orders implements Serializable{
    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String descrip;
    private String barcode;
    private String Company;
    private String type;
    
    public String getDescrip(){
        return descrip;
    }
    public String getBarcode(){
        return barcode;
    }
    
    public String getCompany(){
        return Company;
    }
    public String getType(){
        return type;
    }
    
    public Long getId(){
        return id;
    }
     
    private Orders(){};
    
    private Orders(Builder build){
        this.Company=build.Company;
        this.barcode=build.barcode;
        this.descrip=build.descrip;
        this.type=build.type;
        this.id=build.id;
    }
    
    private Orders(Orders build){
        
        this.barcode=build.barcode;
        this.descrip=build.descrip;
        this.Company=build.Company;
        this.type=build.type;
        this.id=build.id;
    }
    
    public static class Builder{
        private String descrip;
        private String barcode;
        private String Company;
        private String type;
        private Long id;
        
        public Builder(String bcode,String descrip,String Company,String type){
            this.barcode=bcode;
            this.descrip = descrip;
            this.Company = Company;
            this.type = type;
        }

        public Builder setDescrip(String descrip) {
            this.descrip = descrip;
            return this;
        }

        public Builder setBarcode(String barcode) {
            this.barcode = barcode;
            return this;
        }

        public Builder setCompany(String Company) {
            this.Company = Company;
            return this;
        }

        public Builder setType(String type) {
            this.type = type;
            return this;
        }
        
        
        
        
        public Builder Orders(Orders build){
        this.barcode=build.barcode;
        this.descrip=build.descrip;
        this.Company=build.Company;
        this.type=build.type;
        this.id=build.id;
        return this;
    }
        
        public Orders build(){
            return new Orders(this);
        }
        
        /*public Builder addOrder(order b){
            orderList.add( b);
            return this;
        }*/
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Orders other = (Orders) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Orders{" + "id=" + id + '}';
    }
    
}

