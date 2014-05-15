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
public class Cashier implements Serializable{
    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private double salary;
    private String employeeNum;
    
    public String getName(){
        return name;
    }
    public double returnSalary(){
        salary+=500;
        return salary;
    }
    public String getEmpNum(){
        return employeeNum;
    }
    
     public Long getId(){return id;}
     
     private Cashier(){};
     
     private Cashier(Builder build){
        this.name=build.name;
        this.salary=build.salary;
        this.employeeNum=build.employeeNum;
        this.id=build.id;
    }
    private Cashier(Cashier build){
        this.name=build.name;
        this.salary=build.salary;
        this.employeeNum=build.employeeNum;
        this.id=build.id;
    }
    public static class Builder{
        private String name;
        private double salary;
        private String employeeNum;
        private Long id;
        
        public Builder(String name, String empN, double sal){
            this.name=name;
            this.employeeNum=empN;
            this.salary=sal;
        }
        
        public Builder setName(String n){
            this.name=n;
            return this;
        }
        
        public Builder Cashier(Cashier build){
        this.name=build.name;
        this.salary=build.salary;
        this.employeeNum=build.employeeNum;
        this.id=build.id;
        return this;
    }
        
        public Cashier Build(){
            return new Cashier(this);
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Cashier other = (Cashier) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cashier{" + "id=" + id + '}';
    }
    
}