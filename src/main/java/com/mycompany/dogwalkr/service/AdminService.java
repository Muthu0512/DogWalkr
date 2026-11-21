/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dogwalkr.service;

import com.mycompany.dogwalkr.db.DB;
import com.mycompany.dogwalkr.model.AdminStats;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class AdminService {
        public static AdminStats getStats() throws SQLException{
            String sql= "SELECT "
                    + "(SELECT COUNT(*) FROM users WHERE status='Pending') AS pending_approvals, "
                    + "(SELECT COUNT(*) FROM users WHERE status='Approved' AND role='OWNER') AS total_owners, "
                    + "(SELECT COUNT(*) FROM users WHERE status='Approved' AND role='WALKER') AS total_walkers, "
                    + "(SELECT COUNT(*) FROM walks) AS total_walks, "
                    + "(SELECT COUNT(*) FROM walks WHERE status='Completed') AS completed_walks, "
                    + "(SELECT COALESCE(SUM(platform_fee),0) FROM walks WHERE status ='Completed') AS total_earnings ";
            
            try(Connection con =DB.getConnection();
                    PreparedStatement ps= con.prepareStatement(sql);
                    ResultSet rs=ps.executeQuery()){
                AdminStats stats = new AdminStats();
                if(rs.next()){
                    stats.pendingApprovals = rs.getInt("pending_approvals");
                    stats.totalOwners = rs.getInt("total_owners");
                    stats.totalWalkers = rs.getInt("total_walkers");
                    stats.totalWalks = rs.getInt("total_walks");
                    stats.completedWalks = rs.getInt("completed_walks");
                    stats.totalEarnings= rs.getInt("total_earnings");
                }
                return stats;
            }
            
            
        }
}
