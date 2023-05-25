/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rabirabichannel
 */
public class controller {
    
    String jdbcDriver = "com.mysql.jdbc.Driver";
    String dbUrl = "jdbc:mysql://localhost/managedose";
    String user = "root";
    String password = "";
    
    Connection connection;
    Statement state;
    ResultSet result;
    PreparedStatement prepared;
    
    boolean response;
    
    public controller(){
        
        try {
            Class.forName(jdbcDriver);
            System.out.println("Driver loaded");
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver not found");
            Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            connection = DriverManager.getConnection(dbUrl, user, password);
            System.out.println("SQL connected succesfully");
            
        } catch (SQLException ex) {
            System.out.println("Cant connect to SQL");
            Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean createAccount(String username, String password){
        
        String query = "insert into user (username, password) values (?,?)";
        
        try {
            prepared.executeUpdate(query);
            prepared.setString(1, username);
            prepared.setString(2, password);
            
            response = true;
            
        } catch (SQLException ex) {
            
            Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, ex);
            response = false;
        }
        
        return response;
    }
    
    public boolean setNick(String nick){
        
        String query = "insert into user (nickname) values (?) where username=?";
        
        try {
            prepared.executeUpdate(query);
            prepared.setString(1,nick);
            
            response = true;
        } catch (SQLException ex) {
            Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, ex);
            response = false;
        }
        return response;
    }
    
    public boolean setTarget(String targetName, Date date, String category, int uid){
        
        String query = "insert into target (nama, tanggal, kategori, uid) values (?, ?, ?, ?)";
        
        try {
            prepared.executeUpdate(query);
            prepared.setString(1,targetName);
            prepared.setDate(2,date);
            prepared.setString(3,category);
            prepared.setInt(4,uid);
            
            response = true;
        } catch (SQLException ex) {
            Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, ex);
            response = false;
        }
        return response;
        
    }
}
