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

//@SuppressWarnings("ConsistentAccessType")
@Entity
public class Sportware implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String barcode;
    private String descrip;
    private String brand;
    //@OneToMany (cascade = CascadeType.ALL)
    //@JoinColumn (name="Sportware_id")
    //List<Sportware> sportswareList;

    public Long getId() {
        return id;
    }
    
    
    public String Types(){
        return "Sportware";
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
    
    
    private Sportware(){};
   
    
    private Sportware(Builder build){
        this.barcode=build.barcode;
        this.brand = build.brand;
        this.descrip = build.descrip;
        this.id = build.id;
    }
    
    private Sportware(Sportware item){
        this.barcode = item.barcode;
        this.brand = item.brand;
        this.descrip = item.descrip;
        this.id = item.id;
    }
     
    
       /* public List<Sportware> getSportswareList()
        {
            return sportswareList;
        }*/
    
    public static class Builder{
        private String barcode;
        private String descrip;
        private String brand;    
        private Long id;
        //List<Sportware> sportswareList;
        
        public Builder(String bcode){
            this.barcode=bcode;
        }
        
        public Builder setDescrip(String descr){
            descrip=descr;
            return this;
        }
        
        public Builder setBrand(String br){
            brand=br;
            return this;
        }
        
        /*public Builder setSportswareList (List<Sportware> sportswareList){
            this.sportswareList = sportswareList;
            return this;
        }*/
        
        public Builder Sportware(Sportware wares){
            this.barcode = wares.barcode;
            this.brand = wares.brand;
            this.descrip = wares.descrip;
            this.id=wares.id;
            return this;
        }
        
        public Sportware Build(){
            return new Sportware(this);
        }
        
        
    }

    @Override
    public String toString() {
        return "Sportware{"+ "id="+id+"}" ; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null)
        {return false;}
        if(getClass()!= obj.getClass()){
            return false;
        }
        final Sportware otherWare = (Sportware) obj;
        if(!Objects.equals(this.id,otherWare.id)){
            return false;
        }
        
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        int hash =7;
        hash=53*hash+Objects.hashCode(this.id);
        return hash; //To change body of generated methods, choose Tools | Templates.
    }

    /*public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }*/
    
    
}
