/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dogwalkr.service;


import com.mycompany.dogwalkr.db.DB;
import com.mycompany.dogwalkr.model.WalkHistory;
import com.mycompany.dogwalkr.model.Fare;
import com.mycompany.dogwalkr.model.Walk;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import java.time.OffsetDateTime;

public class WalkService {
    
    public static boolean bookWalk(Walk w){
        Fare fare = Fare.forDuration(w.durationMinutes);
        w.walkerPay =fare.walkerPay;
        w.platformFee = fare.platformFee;
        String sql ="INSERT INTO walks (owner_id, dog_id, walk_time, duration_minutes,notes, walker_pay, platform_fee) values (?,?,?,?,?,?,?)" ;
        try(Connection con = DB.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)){
                ps.setInt(1,w.ownerId);
                ps.setInt(2,w.dogId);
                ps.setObject(3,w.walkTime);
                ps.setInt(4,w.durationMinutes);
                ps.setString(5,w.notes);
                ps.setInt(6,w.walkerPay);
                ps.setInt(7,w.platformFee);
                return ps.executeUpdate()==1;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    
    
    //walk history by owner
    
    public static List<WalkHistory> getWalksByOwner(int ownerId){
        List<WalkHistory> list = new ArrayList<>();
        
        String sql ="SELECT w.id, d.name AS dog_name, w.walk_time,w.duration_minutes,w.status,w.notes  "
                + "FROM walks w JOIN dogs d ON d.id=w.dog_id  "
                + "WHERE w.owner_id = ? ORDER BY w.walk_time DESC";
        
        
        try(Connection con = DB.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, ownerId);
            
            try(ResultSet rs =ps.executeQuery()){
                while (rs.next()){
                    WalkHistory h= new WalkHistory();
                    h.id = rs.getInt("id");
                    h.dogName =rs.getString("dog_name");
                    h.walkTime = rs.getObject("walk_time",OffsetDateTime.class);
                    h.durationMinutes = rs.getInt("duration_minutes");
                    h.status = rs.getString("status");
                    h.notes = rs.getString("notes");
                    list.add(h);
                }
            }
        }catch(Exception e){
           e.printStackTrace(); 
        }
        return list; 
    }
    
    // cancel walk by owner
    
    public static boolean cancelWalk(int walkId, int ownerId){
        String sql = "UPDATE walks SET status ='Cancelled' WHERE id=? AND owner_id = ? AND status ='Requested'";
        
        try(Connection con = DB.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1,walkId);
            ps.setInt(2,ownerId);
            return ps.executeUpdate()>0;
        }catch(Exception e){
            e.printStackTrace();
             return false ;
        }
       
    }
    
    //get walks for a walker
    
    public static List<WalkHistory> getAvailableWalks(){
        List <WalkHistory> list = new ArrayList<>();
        
        String sql = "SELECT w.id, d.name AS dog_name,w.walk_time,w.duration_minutes,w.walker_pay,w.notes "
              +  "FROM walks w JOIN dogs d ON d.id=w.dog_id "
              +  "WHERE w.status = 'Requested' AND w.walker_id is NULL " 
              +  "AND w.walk_time > now() + interval '30 minutes' " 
              +  "ORDER BY w.walk_time ASC ";
        
        try(Connection con = DB.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs=ps.executeQuery()){
            
            while(rs.next()){
                WalkHistory h = new WalkHistory();
                h.id = rs.getInt("id");
                h.dogName = rs.getString("dog_name");
                h.walkTime = rs.getObject("walk_time",OffsetDateTime.class);
                h.durationMinutes = rs.getInt("duration_minutes");
                h.walkerPay = rs.getInt("walker_pay");
                h.notes = rs.getString("notes");
                h.status = "Requested";
                list.add(h);
                
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return list;
        
    }
    
   
}
