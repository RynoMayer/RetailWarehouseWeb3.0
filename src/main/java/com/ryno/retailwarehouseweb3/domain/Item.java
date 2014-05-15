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
public  class Item implements Serializable{
    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String barcode;
    private String type;
            
    public Long getId(){
        return id;
    }
    
    public String getBarcode(){
        return barcode;
    }
    public String getType(){
        return type;
    }
    
    private Item(){};
    
    private Item(ItemBuilder build){
        this.barcode=build.barcode;
        this.type=build.type;
        this.id=build.id;
    }
    
    private Item (Item item){
        this.barcode=item.barcode;
        this.type=item.type;
        this.id=item.id;
    }
    
    public static class ItemBuilder{
        private String barcode;
        private String type;
        private Long id;
        
        public ItemBuilder(String bcode){
            this.barcode=bcode;
        }
        
        public ItemBuilder setType(String types){
            this.type=types;
            return this;
        }
        
        public ItemBuilder Item (Item item){
        this.barcode=item.barcode;
        this.type=item.type;
        this.id=item.id;
        return this;
    }
        
        public Item build(){
            return new Item(this);
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final Item other = (Item) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Item{" + "id=" + id + '}';
    }
    
    
    
}
