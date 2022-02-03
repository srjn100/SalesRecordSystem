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
import org.mb.model.Supplier;
import org.mb.util.DBConnection;

/**
 *
 * @author QWERTY
 */
public class SupplierDAO {
    public ArrayList<Supplier> fetchData() {
        ArrayList<Supplier> supplierList = new ArrayList<>();
        try {
            Connection con = DBConnection.getConnection();
            String sql = "select * from suppliers";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Supplier ob = new Supplier();
                ob.setSupplier_id(rs.getInt("supplier_id"));
                ob.setName(rs.getString("name"));
                ob.setAddress(rs.getString("address"));
                ob.setPhone(rs.getLong("phone"));
                ob.setEmail(rs.getString("email"));
                supplierList.add(ob);
            }
            con.close();
        } catch (Exception ex) {
            System.out.println(ex);
            ex.printStackTrace();
        }
        return supplierList;
    }
    
    public void addSupplier(Supplier ob) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "insert into suppliers(name,address,phone,email) values(?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, ob.getName());
            pst.setString(2, ob.getAddress());
            pst.setLong(3, ob.getPhone());
            pst.setString(4, ob.getEmail());
            int count = pst.executeUpdate();

            if (count > 0) {
                System.out.println("Supplier Record Added");
            } else {
                System.out.println("Supplier Record not Added");
            }

            con.close();
        } catch (Exception ex) {
            System.out.println(ex);
            ex.printStackTrace();
        }
    }
    
    public void updateSupplier(Supplier ob){
        try{
            Connection con=DBConnection.getConnection();
            String sql="update suppliers set name=?, address=?, phone=?, email=? where supplier_id=?";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1, ob.getName());
            pst.setString(2, ob.getAddress());
            pst.setLong(3, ob.getPhone());
            pst.setString(4, ob.getEmail());
            pst.setInt(5, ob.getSupplier_id());
            int count = pst.executeUpdate();

            if (count > 0) {
                System.out.println("Supplier Record Updated");
            } else {
                System.out.println("Supplier Record not Updated");
            }
            con.close();
        }
        catch(Exception ex){
            System.out.println(ex);
            ex.printStackTrace();
        }
    }
    
    public HashMap<String,Integer> fetchSupplier(){
        HashMap<String,Integer> map=new HashMap<String,Integer>();
        try{
            Connection con=DBConnection.getConnection();
            String sql="select * from suppliers";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs= pst.executeQuery();
            while(rs.next()){
                map.put(rs.getString("name"), rs.getInt("supplier_id"));
            }
            
            con.close();
        }catch(Exception ex){
            System.out.println(ex);
        }
        return map;
    }
    
    public boolean checkPhone(String phone){
        try{
        Connection con = DBConnection.getConnection();
            String sql = "select * from suppliers where phone = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setLong(1,Long.parseLong(phone) );
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                return true;
            }
        }catch(Exception ex){
            System.out.println(ex);
            ex.printStackTrace();
            return true;
        }
        return false;
    }
    
    public boolean checkEmail(String email){
        try{
        Connection con = DBConnection.getConnection();
            String sql = "select * from suppliers where email = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                return true;
            }
        }catch(Exception ex){
            System.out.println(ex);
            ex.printStackTrace();
            return true;
        }
        return false;
    }
}
