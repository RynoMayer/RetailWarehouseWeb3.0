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
public class Coins implements Serializable{
    
    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int v_values;
    private String abbv;
    
    public int getValue(){
        return v_values;
    }
    public String getAbbv(){
        return abbv;
    }
    
    public Long getId(){
        return id;
    }
    
    private Coins(){};
    
    private Coins(Builder build){
        this.abbv=build.abbv;
        this.v_values=build.v_values;
        this.id=build.id;
    }
    private Coins(Coins item){
        this.abbv=item.abbv;
        this.v_values=item.v_values;
         this.id=item.id;
    }
    
    public static class Builder{
        private int v_values;
        private String abbv;
          private Long id;
          
        public Builder(String abbrev, int val){
            this.v_values=val;
            this.abbv=abbrev;
        }
        
        public Builder setAbbr(String abb){
            this.abbv=abb;
            return this;
        }
        
        public Builder Coins(Coins item){
        this.abbv=item.abbv;
        this.v_values=item.v_values;
         this.id=item.id;
         return this;
    }
        
        public Coins build(){
            return new Coins(this);
        }
        /*public Builder addCoins(Coins b){
            coinList.add(b);
            return this;
        }*/
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final Coins other = (Coins) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Coins{" + "id=" + id + '}';
    }
    
}
