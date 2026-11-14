/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dogwalkr.service;

//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.sql.Types;

import com.mycompany.dogwalkr.db.DB;
import com.mycompany.dogwalkr.model.Dog;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;  

public class DogService {
    
    // Add dog by  owner
    
    public static boolean addDog(Dog d){
        String sql = "INSERT INTO dogs (owner_id,name,breed,age,notes,photo) values(?,?,?,?,?,?)";
        try(Connection con = DB.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)){
            
            ps.setInt(1,d.ownerId);
            ps.setString(2, d.name);
            ps.setString(3,d.breed);
            ps.setInt(4, d.age);
            ps.setString(5,d.notes);
            
            if(d.photo !=null){
                ps.setBytes(6,d.photo);
            }else{
                ps.setNull(6, Types.BINARY);
            }
            
            
            return ps.executeUpdate()==1 ;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    
    // get dogs list by Owner
    
    public static List<Dog> getDogsByOwner(int ownerId){
        List<Dog> dogs = new ArrayList<>();
        String sql = "SELECT id, owner_id,name,breed,age,notes, photo FROM dogs where owner_id=? ORDER BY id  DESC ";
        
        try(Connection con =DB.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1,ownerId);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                Dog d = new Dog();
                d.id=rs.getInt("id");
                d.ownerId = rs.getInt("owner_id");
                d.name = rs.getString("name");
                d.breed = rs.getString("breed");
                d.age = rs.getInt("age");
                d.notes = rs.getString("notes");
                d.photo = rs.getBytes("photo");
                dogs.add(d);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return dogs;
    }
    
    
    // Delete a dog by owner
    public static boolean deleteDog(int dogId,int ownerId){
        String sql = "DELETE FROM dogs WHERE id =? AND owner_id = ?";
        
        try(Connection con = DB.getConnection();
                PreparedStatement ps = con.prepareStatement(sql))
        {
            ps.setInt(1,dogId);
            ps.setInt(2,ownerId);
            return ps.executeUpdate()>0;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
