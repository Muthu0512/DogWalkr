/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.dogwalkr.ui.admin;

import com.mycompany.dogwalkr.model.AdminStats;
import com.mycompany.dogwalkr.service.AdminService;
import javax.swing.JOptionPane;
public class AdminOverviewPanel extends javax.swing.JPanel {

    /**
     * Creates new form AdminOverviewPanel
     */
    public AdminOverviewPanel() {
        initComponents();
        loadStats();
    }
    public void loadStats(){
        try{
            AdminStats s =AdminService.getStats();
            
            
            lblPendingValue.setText(String. valueOf(s.pendingApprovals));
            lblOwnersValue.setText(String.valueOf(s.totalOwners));
            lblWalkersValue.setText(String.valueOf(s.totalWalkers));
            lblTotalWalksValue.setText(String.valueOf(s.totalWalks));
            lblCompletedValue.setText(String.valueOf(s.completedWalks));
            lblTotalEarningsValue.setText(" ₹"+s.totalEarnings);
            
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Could not fetch values:" + e.getMessage());
            
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblPendingValue = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblOwnersValue = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lblTotalWalksValue = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lblWalkersValue = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lblCompletedValue = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lblTotalEarningsValue = new javax.swing.JLabel();

        setBackground(new java.awt.Color(16, 15, 15));
        setMinimumSize(new java.awt.Dimension(650, 600));
        setPreferredSize(new java.awt.Dimension(650, 600));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Overview");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 300, 40));

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(200, 200, 200));
        jLabel2.setText("Pending Approval");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 15, 160, 25));

        lblPendingValue.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        lblPendingValue.setForeground(new java.awt.Color(255, 153, 0));
        lblPendingValue.setText("0");
        jPanel1.add(lblPendingValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 50, 160, 45));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 190, 110));

        jPanel2.setBackground(new java.awt.Color(0, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(200, 200, 200));
        jLabel3.setText("Owners ");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 15, 160, 25));

        lblOwnersValue.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        lblOwnersValue.setForeground(new java.awt.Color(0, 153, 153));
        lblOwnersValue.setText("0");
        jPanel2.add(lblOwnersValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 50, 160, 45));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 190, 110));

        jPanel3.setBackground(new java.awt.Color(0, 51, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(200, 200, 200));
        jLabel5.setText("Total Walks");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 15, 160, 25));

        lblTotalWalksValue.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        lblTotalWalksValue.setForeground(new java.awt.Color(0, 153, 153));
        lblTotalWalksValue.setText("0");
        jPanel3.add(lblTotalWalksValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 50, 160, 45));

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 190, 110));

        jPanel4.setBackground(new java.awt.Color(0, 51, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(200, 200, 200));
        jLabel4.setText("Walkers");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 15, 160, 25));

        lblWalkersValue.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        lblWalkersValue.setForeground(new java.awt.Color(0, 153, 153));
        lblWalkersValue.setText("0");
        jPanel4.add(lblWalkersValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 50, 160, 45));

        add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, 190, 110));

        jPanel5.setBackground(new java.awt.Color(0, 51, 51));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(200, 200, 200));
        jLabel6.setText("Completed ");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 15, 160, 25));

        lblCompletedValue.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        lblCompletedValue.setForeground(new java.awt.Color(102, 255, 102));
        lblCompletedValue.setText("0");
        jPanel5.add(lblCompletedValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 50, 160, 45));

        add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 300, 190, 110));

        jPanel6.setBackground(new java.awt.Color(0, 51, 51));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(200, 200, 200));
        jLabel7.setText("Total Earnings");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 15, 160, 25));

        lblTotalEarningsValue.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        lblTotalEarningsValue.setForeground(new java.awt.Color(120, 255, 102));
        lblTotalEarningsValue.setText("0");
        jPanel6.add(lblTotalEarningsValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 50, 160, 45));

        add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 300, 190, 110));
    }// </editor-fold>                        


    // Variables declaration - do not modify                     
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lblCompletedValue;
    private javax.swing.JLabel lblOwnersValue;
    private javax.swing.JLabel lblPendingValue;
    private javax.swing.JLabel lblTotalEarningsValue;
    private javax.swing.JLabel lblTotalWalksValue;
    private javax.swing.JLabel lblWalkersValue;
    // End of variables declaration                   
}
