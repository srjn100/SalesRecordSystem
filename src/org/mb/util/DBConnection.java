/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mb.util;

import java.sql.*;

/**
 *
 * @author QWERTY
 */
public class DBConnection {
    //get Database Connection
    public static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/sales_record_system";
        String uname = "root";
        String pwd = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, uname, pwd);
            return con;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
