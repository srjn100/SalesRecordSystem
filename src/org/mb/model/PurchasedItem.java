/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mb.model;

import java.sql.Date;

/**
 *
 * @author QWERTY
 */
public class PurchasedItem {
    private int purchased_item_id;
    private int product_id;
    private int purchase_id;
    private int quantity;
    private double purchase_price;
    private Date mfg_date;
    private Date exp_date;
    private String product;

    public int getPurchased_item_id() {
        return purchased_item_id;
    }

    public void setPurchased_item_id(int purchased_item_id) {
        this.purchased_item_id = purchased_item_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getPurchase_id() {
        return purchase_id;
    }

    public void setPurchase_id(int purchase_id) {
        this.purchase_id = purchase_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPurchase_price() {
        return purchase_price;
    }

    public void setPurchase_price(double purchase_price) {
        this.purchase_price = purchase_price;
    }

    public Date getMfg_date() {
        return mfg_date;
    }

    public void setMfg_date(Date mfg_date) {
        this.mfg_date = mfg_date;
    }

    public Date getExp_date() {
        return exp_date;
    }

    public void setExp_date(Date exp_date) {
        this.exp_date = exp_date;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
    
    
}
