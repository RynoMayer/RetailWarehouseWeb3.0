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
public class Credit implements Serializable{
    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int cardNum;
    private String bank;
    private double amount;

    public Long getId() {
        return id;
    }

    public int getCardNum() {
        return cardNum;
    }

    public String getBank() {
        return bank;
    }

    public double getAmount() {
        return amount;
    }
    
    private Credit(){};
    private Credit(Builder build){
        this.amount=build.amount; 
        this.bank=build.bank;
        this.cardNum=build.cardNum;
        this.id=build.id;
    }
    private Credit(Credit item){
        this.amount=item.amount; 
        this.bank=item.bank;
        this.cardNum=item.cardNum;
        this.id=item.id;
    }
    
    public static class Builder{
        private int cardNum;
        private String bank;
        private double amount;
        private Long id;
        
        public Builder(double amt, int cNum){
            this.amount=amt;
            this.cardNum=cNum;
        }
        
        public Builder setAmt(double amt){
            this.amount=amt;
            return this;
        }

        public Builder setCardNum(int cardNum) {
            this.cardNum = cardNum;
            return this;
        }

        public Builder setBank(String bank) {
            this.bank = bank;
            return this;
        }
        
        public Builder Credit(Credit build){
        this.amount=build.amount;
         this.bank=build.bank;
        this.cardNum=build.cardNum;
        this.id=build.id;
        return this;
    }
        
        public Credit build(){
            return new Credit(this);
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final Credit other = (Credit) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Credit{" + "id=" + id + '}';
    }
    
}

