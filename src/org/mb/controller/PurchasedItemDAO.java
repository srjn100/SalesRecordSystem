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
import org.mb.model.PurchasedItem;
import org.mb.util.DBConnection;

/**
 *
 * @author QWERTY
 */
public class PurchasedItemDAO {
    public void addPurchasedItem(ArrayList<PurchasedItem> piList) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "insert into purchased_items(product_id,purchase_id,quantity,purchase_price,mfg_date,exp_date) "
                    + "values(?,?,?,?,?,?)";
            String sql1 = "insert into stocks(purchased_item_id,available_qty) values(?,?) ";
            for (int i = 0; i < piList.size(); i++) {
                PreparedStatement pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                pst.setInt(1, piList.get(i).getProduct_id());
                pst.setInt(2, piList.get(i).getPurchase_id());
                pst.setInt(3, piList.get(i).getQuantity());
                pst.setDouble(4, piList.get(i).getPurchase_price());
                pst.setDate(5, piList.get(i).getMfg_date());
                pst.setDate(6, piList.get(i).getExp_date());
                pst.execute();
                ResultSet rs = pst.getGeneratedKeys();
                if (rs.next()) {
                    PreparedStatement pst1 = con.prepareStatement(sql1);
                    pst1.setInt(1, rs.getInt(1));
                    pst1.setInt(2, piList.get(i).getQuantity());
                    pst1.execute();
                }
            }
            con.close();
        } catch (Exception ex) {
            System.out.println(ex);
            ex.printStackTrace();
        }
    }
}
