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
import org.mb.model.Sales;
import org.mb.util.DBConnection;

/**
 *
 * @author QWERTY
 */
public class SalesDAO {

    public ArrayList<Sales> fetchData() {
        ArrayList<Sales> salesList = new ArrayList<>();
        try {
            Connection con = DBConnection.getConnection();
            String sql = "select s.*,c.name as cname,u.username as uname from sales as s"
                    + " inner join customers as c on s.customer_id=c.customer_id"
                    + " inner join users as u on s.updated_by=u.user_id";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Sales ob = new Sales();
                ob.setSales_id(rs.getInt("sales_id"));
                ob.setPayment_status(rs.getBoolean("payment_status"));
                ob.setSales_date(rs.getDate("sales_date"));
                ob.setDiscount(rs.getDouble("discount"));
                ob.setCustomer_id(rs.getInt("customer_id"));
                ob.setUpdated_by(rs.getInt("updated_by"));
                ob.setUpdated_date(rs.getTimestamp("updated_date"));
                ob.setCustomer(rs.getString("cname"));
                ob.setUpdater(rs.getString("uname"));
                salesList.add(ob);
            }
            con.close();
        } catch (Exception ex) {
            System.out.println(ex);
            ex.printStackTrace();
        }
        return salesList;
    }

    public int addSales(Sales ob) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "insert into sales(payment_status,customer_id,updated_by,sales_date,discount) values(?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setBoolean(1, ob.isPayment_status());
            pst.setInt(2, ob.getCustomer_id());
            pst.setInt(3, org.mb.util.Session.uID);
            pst.setDate(4, ob.getSales_date());
            pst.setDouble(5, ob.getDiscount());
            pst.execute();
            ResultSet rs = pst.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return -1;
    }
}
