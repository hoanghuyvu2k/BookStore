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
public class Cart {
    int id;
    int ItemId;
    int CustomerId;
    int Amount;
    float TotalPrice;
    String ItemType;
    String productName;

    public Cart(int id, int Amount, float TotalPrice, String ItemType, String productName, int CustomerId) {
        this.id = id;
        this.Amount = Amount;
        this.TotalPrice = TotalPrice;
        this.productName = productName;
        this.ItemType = ItemType;
        this.CustomerId = CustomerId;
    }

    public Cart(int id, int ItemId, int CustomerId, int Amount, float TotalPrice, String ItemType, String productName) {
        this.id = id;
        this.ItemId = ItemId;
        this.CustomerId = CustomerId;
        this.Amount = Amount;
        this.TotalPrice = TotalPrice;
        this.ItemType = ItemType;
        this.productName = productName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItemId() {
        return ItemId;
    }

    public void setItemId(int ItemId) {
        this.ItemId = ItemId;
    }

    public int getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(int CustomerId) {
        this.CustomerId = CustomerId;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int Amount) {
        this.Amount = Amount;
    }

    public float getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(float TotalPrice) {
        this.TotalPrice = TotalPrice;
    }

    public String getItemType() {
        return ItemType;
    }

    public void setItemType(String ItemType) {
        this.ItemType = ItemType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    
    
}
