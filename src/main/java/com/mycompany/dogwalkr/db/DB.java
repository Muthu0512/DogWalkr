/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dogwalkr.db;
import com.mycompany.dogwalkr.*;
import java.sql.*;

/**
 *
 * @author Admin
 */
public class DB {
    public static Connection getConnection() throws SQLException{
       String url = System.getenv("SUPABASE_DB_URL");
       return DriverManager.getConnection(url);
    }
    
}
