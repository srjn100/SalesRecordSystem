/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mb.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.mb.model.Payment;
import org.mb.util.DBConnection;

/**
 *
 * @author QWERTY
 */
public class PaymentDAO {

    public void addPayment(Payment ob) {
        try {
            Connection con = DBConnection.getConnection();
            if (ob.getPurchase_id() != 0) {
                String sql = "insert into payments(purchase_id,amount,updated_by) values(?,?,?)";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setInt(1, ob.getPurchase_id());
                pst.setDouble(2, ob.getAmount());
                pst.setInt(3, org.mb.util.Session.uID);
                pst.execute();
            }
            if(ob.getSales_id()!=0){
                String sql = "insert into payments(sales_id,amount,updated_by) values(?,?,?)";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setInt(1, ob.getSales_id());
                pst.setDouble(2, ob.getAmount());
                pst.setInt(3, org.mb.util.Session.uID);
                pst.execute();
            }
            con.close();
        } catch (Exception ex) {
            System.out.println(ex);
            ex.printStackTrace();
        }
    }
    
    public String paid(String sql){
        double amt=0;
        try{
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                amt+= rs.getDouble("amount");
            }
            return amt+"";
        }
        catch(Exception ex){
            System.out.println(ex);
            return amt+"";
        }
        
    }
}
