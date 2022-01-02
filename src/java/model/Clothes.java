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
public class Clothes {
    private int id;
    private String name;
    private float price;
    private int inventory;
    private String description;
    private int size;
    private String brand;
    private String material;
    private String color;
    private String category;
    private float discount;

    public Clothes(int id, String name, float price, int inventory, String description, int size, String brand, String material, String color, String category, float discount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.inventory = inventory;
        this.description = description;
        this.size = size;
        this.brand = brand;
        this.material = material;
        this.color = color;
        this.category = category;
        this.discount = discount;
    }
    
    public Clothes(int id, String name, float price, int inventory, String category, float discount) {
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    
}
