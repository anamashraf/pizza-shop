/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sql;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Anam Ashraf
 */
public class Order {
    private int id;
    private String customerName;
    private String customerPhone;
    private String pizza;
    private int quantity;
    
    public Order() {}
    public Order(int Id, String Pizza, int Quantity, String CustomerName, String CustomerPhone) {
        id = Id;
        pizza = Pizza;
        quantity = Quantity;
        customerName = CustomerName;
        customerPhone = CustomerPhone;
    }
    /* Setter */
    public void setId(int Id) {
        id = Id;
    }
    public void setQuantity(int Quantity ) {
        quantity = Quantity;
    }
    public void setPizza(String Pizza) {
        pizza = Pizza;
    }
    public void setCustometName(String CustomerName) {
        customerName = CustomerName;
    }
    public void setCustometPhone(String CustomerPhone) {
        customerPhone = CustomerPhone;
    }
    /* Getter */
    public int getId() {
        return id;
    }
    public int getQuantity() {
        return quantity;
    }
    public String getPizza() {
        return pizza;
    }
    public String getCustometName() {
        return customerName;
    }
    public String getCustometPhone() {
        return customerPhone;
    }
    
    public boolean create () {
        DbConnect dbCnn = new DbConnect();
        String query = "INSERT INTO orders (id, pizza, quantity, customerName, customerPhone) VALUES (NULL, '"+pizza+"', "+Integer.toString(quantity)+", '"+customerName+"', '"+customerPhone+"');";
        return dbCnn.create(query);
    }
    public boolean remove () {
        DbConnect dbCnn = new DbConnect();
        String query = "DELETE FROM orders WHERE id = "+Integer.toString(id)+" LIMIT 1;";
        return dbCnn.update(query);
    }
    
    static public ArrayList<Order> list () {
        ArrayList<Order> orders = new ArrayList<>();
        try {
            DbConnect dbConn = new DbConnect();
            String query = "SELECT id, pizza, quantity, customerName, customerPhone FROM orders";
            ResultSet rs = dbConn.runQuery(query);
            while (rs.next()) {
                orders.add(new Order(
                  rs.getInt("id"),
                  rs.getString("pizza"),
                  rs.getInt("quantity"),
                  rs.getString("customerName"),
                  rs.getString("customerPhone")
                ));
            }
        }
        catch(Exception exp) {
            JOptionPane.showMessageDialog(null, exp);
            return orders;
        }
        return orders;
    }
    
}
