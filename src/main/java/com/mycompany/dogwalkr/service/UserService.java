/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dogwalkr.service;
import com.mycompany.dogwalkr.exceptions.WrongPasswordException;
import com.mycompany.dogwalkr.db.DB;
import com.mycompany.dogwalkr.model.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

public class UserService {

    // login check whether ther is an user?
    public static User login(String email, String password) throws SQLException {
        String sql = "SELECT id,username,password_hash,role,status FROM users WHERE email=? ";
        try (Connection con = DB.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next() && BCrypt.checkpw(password, rs.getString("password_hash"))) {
                    User u = new User();
                    u.id = rs.getInt("Id");
                    u.username = rs.getString("username");
                    u.role = rs.getString("role");
                    u.status = rs.getString("status");
                    return u;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //regiser new user in DB
    public static String register(String username, String email, String mobile, String role, String password) {
        String sql = "INSERT INTO users (username, email,mobile,password_hash,role) VALUES (?,?,?,?,?)";

        String hash = BCrypt.hashpw(password, BCrypt.gensalt());

        try (Connection con = DB.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, email);
            ps.setString(3, mobile);
            ps.setString(4, hash);
            ps.setString(5, role);
            ps.executeUpdate();
            return "OK";

        } catch (SQLException e) {
            if ("23505".equals(e.getSQLState())) {
                return "Email already exists";
            }
            e.printStackTrace();
            return "Error to connect DB , please try again";
        }
    }

    // GET users row
    public static List<Object[]> getUsersByRole(String role, String status) throws Exception {
        List<Object[]> rows = new ArrayList<>();
        String sql = "SELECT id,username,email,mobile,status FROM users WHERE role=?";
        if (status != null) {
            sql += " AND status = ? ";
        }
        sql += " ORDER BY id";

        try (Connection con = DB.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, role);
            if (status != null) {
                ps.setString(2, status);
            }
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    rows.add(new Object[]{
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("mobile"),
                        rs.getString("status")
                    });
                }

            }
        }
        return rows;

    }

    //change a particular user's status such as, they are approved or rejected
    public static void updateStatus(int id, String newStatus) throws Exception {
        String sql = "UPDATE users SET status =? WHERE id=?";
        try (Connection con = DB.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, newStatus);
            ps.setInt(2, id);
            ps.executeUpdate();

        }
    }

    // Update/edit profile for users 
                //  i) getUser Details by using their id
    public static User getUserById(long userId) {
        String sql = "SELECT id,username,email,mobile,location,photo,role,status FROM users WHERE id =?";
        try (Connection con = DB.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    User u = new User();
                    u.id = rs.getLong("id");
                    u.username = rs.getString("username");
                    u.email = rs.getString("email");
                    u.mobile = rs.getString("mobile");
                    u.location = rs.getString("location");
                    u.photo = rs.getBytes("photo");
                    u.role = rs.getString("role");
                    u.status = rs.getString("status");
                    return u;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
                            // ii) update Profile's location and mobile
    
    
    public static boolean updateProfile(long userId, String mobile, String location){
        String sql ="UPDATE users SET mobile=?,location=? WHERE id=?";
        
        try(Connection con=DB.getConnection();
                PreparedStatement ps= con.prepareStatement(sql)){
            ps.setString(1,mobile.trim());
            if(location == null || location.trim().isEmpty()){
                ps.setNull(2,Types.VARCHAR);
            }
            else{
                ps.setString(2,location.trim());
            }
            ps.setLong(3, userId);
            
            
            return ps.executeUpdate()==1;
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
                    // iii) change password for user 
    
         public static boolean changePassword(long userId, String oldPassword, String newPassword) throws WrongPasswordException{
             String selectSql = "SELECT password_hash FROM users WHERE id=?";
             String updateSql = "UPDATE users set password_hash=? WHERE id =?";
                
             try (Connection con = DB.getConnection()){
                 String currentHash;
                 try(PreparedStatement ps= con.prepareStatement(selectSql)){
                     ps.setLong(1,userId);
                     try(ResultSet rs = ps.executeQuery()){
                         if(!rs.next()){
                             return false;
                         }
                         currentHash =rs.getString("password_hash");
                     }
                 }
                if(!BCrypt.checkpw(oldPassword,currentHash)){
                    throw new WrongPasswordException("Old password is Incorrect");
                }
                String newHash=BCrypt.hashpw(newPassword,BCrypt.gensalt());
                try(PreparedStatement ps = con.prepareStatement(updateSql)){
                    ps.setString(1,newHash);
                    ps.setLong(2, userId);
                    return ps.executeUpdate()==1;
                }
                
             }catch(Exception e){
                 e.printStackTrace();
             }
             return false;
         }
         
         // update photo of User
         
         public static boolean updatePhoto(long userId, byte[] photo){
             String sql = "UPDATE users SET photo=? WHERE id=?";
             try(Connection con = DB.getConnection();
                     PreparedStatement ps = con.prepareStatement(sql)){
                 ps.setBytes(1,photo);
                 ps.setLong(2,userId);
                 
                 return ps.executeUpdate()==1;
             }catch(Exception e){
                 e.printStackTrace(); 
             }
             return false;
         }
}
