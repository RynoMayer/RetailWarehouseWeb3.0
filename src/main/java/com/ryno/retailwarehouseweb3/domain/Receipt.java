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
public class Receipt implements Serializable{
    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double total;
    private String descr;
    private double price;
    private int qty;
    
    public int getQty(){
        return qty;
    }
    public double getPrice(){
        return price;
    }
    public String getDescr(){
        return descr;
    }
    public double getTotal(){
        return total;
    }
    
    public Long getId(){
        return id;
    }
    
    public void display(){
        System.out.println("Item: "+getDescr()+"\n");
        System.out.println("Quantity: "+getQty()+"\n");
        System.out.println("Price: "+getPrice()+"\n");
        System.out.println("Total: "+getTotal()+"\n");
    }
    
    private Receipt (){};
    
    private Receipt(Builder build){
        this.total=build.total;
        this.descr=build.descr;
        this.price=build.price;
        this.id=build.id;
    }
    private Receipt(Receipt item){
        this.total=item.total;
        this.descr=item.descr;
        this.price=item.price;
        this.id=item.id;
    }
    
    public static class Builder{
        private double total;
        private String descr;
        private double price;
        private int qty;
        private Long id;
        
        public Builder(){
            
        }
        public Builder setPrice(double pr){
            this.price=pr;
            return this;
        }
        
        public Builder setDescr(String des){
            this.descr=des;
            return this;
        }
        public Builder setQty(int q){
            this.qty=q;
            return this;
        }
        public double calcTotal(){
            return this.price*this.qty;
        }
        
        public Builder setTotal(){
             double totals=calcTotal();
            this.total=totals;
            return this;
        
        }
        
        public Builder Receipt(Receipt item){
        this.total=item.total;
        this.descr=item.descr;
        this.price=item.price;
        this.id=item.id;
        return this;
    }
        
        public Receipt build(){
            return new Receipt(this);
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
        final Receipt other = (Receipt) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Receipt{" + "id=" + id + '}';
    }
    
}
