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
public class Notes implements Serializable{
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
    
    private Notes(){};
    
    private Notes(Builder build){
        this.abbv=build.abbv;
        this.v_values=build.v_values;
        this.id=build.id;
    }
    
    private Notes(Notes item){
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
        
        public Builder Notes(Notes item){
        this.abbv=item.abbv;
        this.v_values=item.v_values;
        this.id=item.id;
        return this;
    }
        
        public Notes build(){
            return new Notes(this);
        }
       /* public Builder addNotes(Notes b){
            noteList.add( b);
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
        final Notes other = (Notes) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Notes{" + "id=" + id + '}';
    }
    
}

