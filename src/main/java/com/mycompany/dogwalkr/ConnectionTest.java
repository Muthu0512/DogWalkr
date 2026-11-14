/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dogwalkr;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Admin
 */
public class ConnectionTest {
    public static void main(String args[]){
        try(Connection con=DB.getConnection();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM users")){
            
                rs.next();
                System.out.println("Connected to DB and table Users "+ rs.getInt(1));
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
