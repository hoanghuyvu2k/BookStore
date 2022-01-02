/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author DELL
 */
public class Electronics {
    private int id;
    private String name;
    private float price;
    private int inventory;
    private String description;
    private String brand;
    private String category;
    private float discount;

    public Electronics(int id, String name, float price, int inventory, String description, String brand, String category, float discount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.inventory = inventory;
        this.description = description;
        this.brand = brand;
        this.category = category;
        this.discount = discount;
    }
    
    public Electronics(int id, String name, float price, int inventory, String category, float discount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.inventory = inventory;
        this.discount = discount;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    
}
