/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mb.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.mb.model.Purchase;
import org.mb.util.DBConnection;

/**
 *
 * @author QWERTY
 */
public class PurchaseDAO {
    public ArrayList<Purchase> fetchData() {
        ArrayList<Purchase> purchaseList = new ArrayList<>();
        try {
            Connection con = DBConnection.getConnection();
            String sql = "select p.*,s.name as sname,u.username as uname from purchases as p"
                    + " inner join suppliers as s on p.supplier_id=s.supplier_id"
                    + " inner join users as u on p.updated_by=u.user_id";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Purchase ob = new Purchase();
                ob.setPurchase_id(rs.getInt("p.purchase_id"));
                ob.setPayment_status(rs.getBoolean("payment_status"));
                ob.setPurchase_date(rs.getDate("purchase_date"));
                ob.setSupplier_id(rs.getInt("supplier_id"));
                ob.setUpdated_by(rs.getInt("updated_by"));
                ob.setUpdated_date(rs.getTimestamp("updated_date"));
                ob.setSupplier(rs.getString("sname"));
                ob.setUpdater(rs.getString("uname"));
                purchaseList.add(ob);
            }
            con.close();
        } catch (Exception ex) {
            System.out.println(ex);
            ex.printStackTrace();
        }
        return purchaseList;
    }
    
    public int addPurchase(Purchase ob){
        try{
            Connection con = DBConnection.getConnection();
            String sql= "insert into purchases(payment_status,supplier_id,updated_by) values(?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            pst.setBoolean(1, ob.isPayment_status());
            pst.setInt(2, ob.getSupplier_id());
            pst.setInt(3, org.mb.util.Session.uID);
            pst.execute();
            ResultSet rs =pst.getGeneratedKeys();
            if(rs.next())
                return rs.getInt(1);
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return -1;
    }
}
