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
import org.mb.model.SalesItem;
import org.mb.util.DBConnection;

/**
 *
 * @author QWERTY
 */
public class SalesItemDAO {

    public void addSalesItem(ArrayList<SalesItem> siList) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "insert into sales_items(product_id,sales_id,stock_id,quantity,sales_price) "
                    + "values(?,?,?,?,?)";
            String sql1 = "update stocks set available_qty=? where stock_id=? ";
            String sql2 = "select s.stock_id as sid,s.available_qty as qty from stocks as s"
                    + " inner join purchased_items as pi on s.purchased_item_id=pi.purchased_item_id"
                    + " where pi.product_id=?"
                    + " order by pi.purchase_id DESC LIMIT 1";
             for (int i = 0; i < siList.size(); i++) {
                 //select stock
                PreparedStatement pst2 = con.prepareCall(sql2);
                pst2.setInt(1, siList.get(i).getProduct_id());
                ResultSet rs2 = pst2.executeQuery();
                if (rs2.next()) {
                    int stock_id = rs2.getInt("sid");
                    int available_qty = rs2.getInt("qty");
                    
                    //insert sales item
                    PreparedStatement pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                    pst.setInt(1, siList.get(i).getProduct_id());
                    pst.setInt(2, siList.get(i).getSales_id());
                    pst.setInt(3, stock_id);
                    pst.setInt(4, siList.get(i).getQuantity());
                    pst.setDouble(5, siList.get(i).getSales_price());

                    pst.execute();
                    ResultSet rs = pst.getGeneratedKeys();
                    if (rs.next()) {
                        //update selected stock
                        PreparedStatement pst1 = con.prepareStatement(sql1);
                        pst1.setInt(1, (available_qty-siList.get(i).getQuantity()));
                        pst1.setInt(2, stock_id);
                        pst1.execute();
                    }
                }
             }
        } catch (Exception ex) {
            System.out.println(ex);
            ex.printStackTrace();
        }
    }
}
