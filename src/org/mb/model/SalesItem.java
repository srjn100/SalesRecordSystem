/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mb.model;

/**
 *
 * @author QWERTY
 */
public class SalesItem {
    private int sales_item_id;
    private int product_id;
    private int sales_id;
    private int stock_id;
    private int quantity;
    private double sales_price;
    private String product;

    public int getSales_item_id() {
        return sales_item_id;
    }

    public void setSales_item_id(int sales_item_id) {
        this.sales_item_id = sales_item_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getSales_id() {
        return sales_id;
    }

    public void setSales_id(int sales_id) {
        this.sales_id = sales_id;
    }

    public int getStock_id() {
        return stock_id;
    }

    public void setStock_id(int stock_id) {
        this.stock_id = stock_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSales_price() {
        return sales_price;
    }

    public void setSales_price(double sales_price) {
        this.sales_price = sales_price;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
    
    
}
