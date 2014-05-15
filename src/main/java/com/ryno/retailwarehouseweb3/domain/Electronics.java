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
public class Electronics implements Serializable{
    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String barcode;
    private String descrip;
    private String brand;
    
    public String Types(){
        return "electronic";
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
    
    private Electronics(){};
    
    private Electronics(Builder build){
        this.barcode=build.barcode;
        this.brand=build.brand;
        this.descrip=build.descrip;
        this.id=build.id;
    }
    
    private Electronics (Electronics item){
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
        
        public Builder Electronics (Electronics item){
        this.barcode=item.barcode;
        this.brand=item.brand;
        this.descrip=item.descrip;
        this.id=item.id;
        return this;
    }
        
        public Electronics Build(){
            return new Electronics(this);
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
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
        final Electronics other = (Electronics) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Electronics{" + "id=" + id + '}';
    }
    
}
