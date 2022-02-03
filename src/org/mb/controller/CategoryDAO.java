/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mb.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import org.mb.model.Category;
import org.mb.util.DBConnection;

/**
 *
 * @author QWERTY
 */
public class CategoryDAO {

    public void addCategory(Category ob) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "insert into categories(name) values(?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, ob.getName());
            int count = pst.executeUpdate();

            if (count > 0) {
                System.out.println("Category Record Added");
            } else {
                System.out.println("Category Record not Added");
            }

            con.close();
        } catch (Exception ex) {
            System.out.println(ex);
            ex.printStackTrace();
        }
    }

    public void updateCategory(Category ob) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "update categories set name=? where category_id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, ob.getName());
            pst.setInt(2, ob.getCategory_id());
            int count = pst.executeUpdate();

            if (count > 0) {
                System.out.println("Category Record Updated");
            } else {
                System.out.println("Category Record not Updated");
            }
            con.close();
        } catch (Exception ex) {
            System.out.println(ex);
            ex.printStackTrace();
        }
    }

    public ArrayList<Category> fetchData() {
        ArrayList<Category> categoryList = new ArrayList<>();
        try {
            Connection con = DBConnection.getConnection();
            String sql = "select * from categories";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Category ob = new Category();
                ob.setCategory_id(rs.getInt("category_id"));
                ob.setName(rs.getString("name"));
                categoryList.add(ob);
            }
            con.close();
        } catch (Exception ex) {
            System.out.println(ex);
            ex.printStackTrace();
        }
        return categoryList;
    }

    public HashMap<String, Integer> fetchCategory() {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        try {
            Connection con = DBConnection.getConnection();
            String sql = "select * from categories";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                map.put(rs.getString("name"), rs.getInt("category_id"));
            }

            con.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return map;
    }
    
    public boolean checkCategory(String name){
        try{
            Connection con=DBConnection.getConnection();
            String sql="select * from categories where name = ?";
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
