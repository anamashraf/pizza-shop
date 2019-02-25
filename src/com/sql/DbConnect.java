/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sql;

//Imports
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Anam Ashraf
 */
public class DbConnect {
    private Connection conn;
    private Statement st;
    private ResultSet rs;
    
    public DbConnect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzashop", "root", "");
            st = conn.createStatement();
        }
        catch(Exception exp) {
            JOptionPane.showMessageDialog(null, exp);
            System.exit(0);
        }
    }
    public ResultSet runQuery(String query) {
        try {
            PreparedStatement pst = conn.prepareStatement(query);
            return pst.executeQuery();
        }
        catch(Exception exp) {
            JOptionPane.showMessageDialog(null, exp);
            System.exit(0);
            return null;
        }
    }
    public ResultSet runQuery(String query, String[] params) {
        try {
            PreparedStatement pst = conn.prepareStatement(query);
            for (int i=0; i< params.length; i++ ) {
                pst.setString(i+1, params[i]);
            }
            return pst.executeQuery();
        }
        catch(Exception exp) {
            JOptionPane.showMessageDialog(null, exp);
            System.exit(0);
            return null;
        }
    }
    public boolean create(String query) {
        try {
           Statement stm = conn.createStatement();
           stm.execute(query);
           return true;
        }
        catch(Exception exp) {
            JOptionPane.showMessageDialog(null, exp);
            return false;
        }
    }
    public boolean update(String query) {
        try {
           Statement stm = conn.createStatement();
           stm.execute(query);
           return true;
        }
        catch(Exception exp) {
            JOptionPane.showMessageDialog(null, exp);
            return false;
        }
    }
//    private makeQuery()
}
