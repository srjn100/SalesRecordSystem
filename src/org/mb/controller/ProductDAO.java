/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mb.controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import org.mb.model.Product;
import org.mb.util.DBConnection;

/**
 *
 * @author QWERTY
 */
public class ProductDAO {

    public void addProduct(Product ob) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "insert into products(name,description,sales_price,category_id,updated_by)"
                    + "values(?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, ob.getName());
            pst.setString(2, ob.getDescription());
            pst.setDouble(3, ob.getSales_price());
            pst.setInt(4, ob.getCategory_id());
            pst.setInt(5, org.mb.util.Session.uID);
            
            int count = pst.executeUpdate();

            if (count > 0) {
                System.out.println("Product Record Added");
            } else {
                System.out.println("Product Record not Added");
            }

            con.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            ex.printStackTrace();
        }
    }
    
    public void updateProduct(Product ob) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "update products set name=?, description=?, sales_price=?, category_id=?,"
                    + " updated_by=?, updated_date=? where product_id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, ob.getName());
            pst.setString(2, ob.getDescription());
            pst.setDouble(3, ob.getSales_price());
            pst.setInt(4, ob.getCategory_id());
            pst.setInt(5, org.mb.util.Session.uID);
            pst.setTimestamp(6, null);
            pst.setInt(7, ob.getProduct_id());
            pst.execute();
            con.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public ArrayList<Product> fetchData() {
        ArrayList<Product> productList = new ArrayList<>();
        try {
            Connection con = DBConnection.getConnection();
            String sql = "select p.*,c.name as cname,u.username as uname, IFNULL(SUM(s.available_qty),0) AS qty from Products as p"
                    + " inner join categories as c on p.category_id=c.category_id"
                    + " inner join users as u on p.updated_by=u.user_id"
                    + " LEFT JOIN purchased_items AS pi ON pi.product_id = p.product_id"
                    + " LEFT JOIN stocks AS s ON s.purchased_item_id = pi.purchased_item_id"
                    + " GROUP BY p.product_id";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Product ob = new Product();
                ob.setProduct_id(rs.getInt("Product_id"));
                ob.setName(rs.getString("name"));
                ob.setDescription(rs.getString("description"));
                ob.setSales_price(rs.getDouble("sales_price"));
                ob.setCategory_id(rs.getInt("category_id"));
                ob.setUpdated_by(rs.getInt("updated_by"));
                ob.setUpdated_date(rs.getTimestamp("updated_date"));
                ob.setCategory(rs.getString("cname"));
                ob.setUpdater(rs.getString("uname"));
                ob.setQuantity(rs.getInt("qty"));
                productList.add(ob);
            }
            con.close();
        } catch (Exception ex) {
            System.out.println(ex);
            ex.printStackTrace();
        }
        return productList;
    }
    
    public ArrayList<Product> searchProducts(String search_key) {
        ArrayList<Product> productList = new ArrayList<>();
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT p.product_id AS id,p.name as name,p.sales_price,IFNULL(SUM(s.available_qty),0) AS qty"
                    + " FROM products as p "
                    + " LEFT JOIN purchased_items AS pi ON pi.product_id = p.product_id"
                    + " LEFT JOIN stocks AS s ON s.purchased_item_id = pi.purchased_item_id"
                    + " WHERE name LIKE ?"
                    + " GROUP BY id"
                    + " ORDER BY id ASC"
                    + " LIMIT 0,50";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, "%" + search_key + "%");
            //System.out.println(pst);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Product ob = new Product();

                ob.setProduct_id(rs.getInt("id"));
                ob.setName(rs.getString("name"));
                ob.setSales_price(rs.getDouble("sales_price"));
                ob.setQuantity(rs.getInt("qty"));
                productList.add(ob);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return productList;
    }
    
    public HashMap<String,Integer> fetchSupplier(){
        HashMap<String,Integer> map=new HashMap<String,Integer>();
        try{
            Connection con=DBConnection.getConnection();
            String sql="select * from products";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs= pst.executeQuery();
            while(rs.next()){
                map.put(rs.getString("name"), rs.getInt("product_id"));
            }
            
            con.close();
        }catch(Exception ex){
            System.out.println(ex);
        }
        return map;
    }
    
    public boolean checkProduct(String name){
        try{
            Connection con=DBConnection.getConnection();
            String sql="select * from products where name = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, name);
            ResultSet rs= pst.executeQuery();
            if(rs.next()){
                return true;
            }
        }
        catch(Exception ex){
            System.out.println(ex);
            return true;
        }
        return false;
    }
}
