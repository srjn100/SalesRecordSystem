/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mb.controller;

import java.sql.*;
import org.mb.model.User;
import org.mb.util.DBConnection;

/**
 *
 * @author QWERTY
 */
public class UserDAO {
    public int authenticate(User ob) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "select * from users where username = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, ob.getUsername());
            if (pst.executeQuery().next()) {
                String sql1 = "select * from users where username = ? and password = md5(?)";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                pst1.setString(1, ob.getUsername());
                pst1.setString(2, ob.getPassword());
                ResultSet rs = pst1.executeQuery();
                
                if (rs.next()) {
                    org.mb.util.Session.uID=rs.getInt("user_id");
                    org.mb.util.Session.uName=rs.getString("username");
                    con.close();
                    return 1;//login success
                } else {
                    con.close();
                    return 2;//incorrect password
                }
            } else {
                con.close();
                return 3;//incorrect username
            }
        } catch (Exception ex) {
            System.out.println(ex);
            ex.printStackTrace();
        }
        return 0;//error
    }
}
