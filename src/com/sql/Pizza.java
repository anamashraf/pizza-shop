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

public class Pizza {
    private int id = 0;
    private String name;
    private String toppings;
    private float price;
    private String size;
    
//    public enum Size { SMALL, MEDIOUM, LARGE, EXTRA_LARGE }
    public Pizza() {
        // New Pizza has id 0
        this.name = "Pizza Name";
        this.toppings = "Pizza toppings";
        this.price = 0;
        this.size  = "Small";
    }
    public Pizza(int Id) {
        this.id = Id;
    }
    public Pizza(int id, String name, String toppings, float price, String size) {
        // New Pizza has id 0
        if (id > 0) {
            this.id = id;
        }
        this.name = name;
        this.toppings = toppings;
        this.price = price;
        this.size  = size;
    }
    public boolean create () {
        DbConnect dbCnn = new DbConnect();
        String query = "INSERT INTO pizzas (id, name, toppings, price, size) VALUES (NULL, '"+name+"', '"+toppings+"', "+Float.toString(price)+", '"+size+"');";
        return dbCnn.create(query);
    }
    public boolean remove () {
        DbConnect dbCnn = new DbConnect();
        String query = "DELETE FROM pizzas WHERE id = "+Integer.toString(id)+" LIMIT 1;";
        return dbCnn.update(query);
    }
    public ArrayList<Pizza> list () {
        ArrayList<Pizza> pizzas = new ArrayList<>();
        try {
            DbConnect dbConn = new DbConnect();
            String query = "SELECT id, name, toppings, price, size FROM pizzas";
            ResultSet rs = dbConn.runQuery(query);
            while (rs.next()) {
                pizzas.add(new Pizza(
                  rs.getInt("id"),
                  rs.getString("name"),
                  rs.getString("toppings"),
                  rs.getFloat("price"),
                  rs.getString("size")
                ));
            }
        }
        catch(Exception exp) {
            JOptionPane.showMessageDialog(null, exp);
            return pizzas;
        }
        
        return pizzas;
//        return dbCnn.create(query);
    }
    // Getters
    public int getId () {
        return id;
    }
    public String getName () {
        return name;
    }
    public String getToppings () {
        return toppings;
    }
    public float getPrice () {
        return price;
    }
    public String getSize () {
        return size;
    }
    
    // Setters
    public void setName (String Name) {
        name = Name;
    }
    public void setToppings (String Toppings) {
        toppings = Toppings;
    }
    public void setPrice (float Price) {
        price = Price;
    }
    public void setSize (String Size) {
        size = Size;
    }
}
