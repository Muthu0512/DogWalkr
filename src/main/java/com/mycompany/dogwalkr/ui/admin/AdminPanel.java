/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.dogwalkr.ui.admin;


import com.mycompany.dogwalkr.ui.auth.Login;
import com.mycompany.dogwalkr.service.UserService;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;


public class AdminPanel extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AdminPanel.class.getName());

    /**
     * Creates new form AdminPanel
     */
    public AdminPanel() {
        initComponents();
        loadUsers();
    }

   
    private String currentRole = "OWNER";
    private String currentStatus = null;
    
    
    // code to load users from databases
    
    
    private void loadUsers(){
        try{
            DefaultTableModel tmodel=new DefaultTableModel(
                                        new Object[] {"Id", "Username","Email","Mobile","Status"},0){
                                            @Override
                                            public boolean isCellEditable(int row,int col){
                                                return false;
                                            }
                                        };
            List<Object[]> rows = UserService.getUsersByRole(currentRole, currentStatus);
            for (Object [] row : rows){
                tmodel.addRow(row);
            }
            tblUsers.setModel(tmodel);
        } catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,"Could not load users for now "+e.getMessage());
        }
    }
    
    //update the status of status such as Approved , Rejected
    
    private void changeStatus(String newStatus){
        int row =tblUsers.getSelectedRow();
        if(row==-1){
            JOptionPane.showMessageDialog(this, "Please select a user from the table first");
            return ;
        }
        try{
            int id = Integer.parseInt(tblUsers.getValueAt(row,0).toString());
            String username = tblUsers.getValueAt(row,1).toString();
            
            UserService.updateStatus(id,newStatus);
            JOptionPane.showMessageDialog(this, username +"is now "+ newStatus);
            loadUsers();
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,"Could not update status: "+e.getMessage());
        }
    }
    
    
    // Methods to change the Owner, Walker tabs 
    
    private void showRole(String role, String title){
        currentRole = role;
        currentStatus = null;
        btnTitle.setText(title);
        loadUsers();
    }
            
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblReports = new javax.swing.JLabel();
        lblOwners = new javax.swing.JLabel();
        lblWalkers = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnLogout = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsers = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        btnTitle = new javax.swing.JLabel();
        btnFilterAll = new javax.swing.JButton();
        btnFilterPending = new javax.swing.JButton();
        btnFilterRejected = new javax.swing.JButton();
        filterApproved = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnApprove = new javax.swing.JButton();
        btnReject = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 600));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(0, 51, 51));
        jPanel2.setAlignmentX(0.0F);
        jPanel2.setAlignmentY(0.0F);
        jPanel2.setMinimumSize(new java.awt.Dimension(250, 600));
        jPanel2.setPreferredSize(new java.awt.Dimension(250, 600));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 2, 18)); // NOI18N
        jLabel1.setText("Happy Dogs Happy walks");
        jLabel1.setToolTipText("");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.SW_RESIZE_CURSOR));

        lblReports.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        lblReports.setForeground(new java.awt.Color(255, 51, 0));
        lblReports.setText("Reports");
        lblReports.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblOwners.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        lblOwners.setForeground(new java.awt.Color(255, 51, 0));
        lblOwners.setText("Owners");
        lblOwners.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblOwners.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOwnersMouseClicked(evt);
            }
        });

        lblWalkers.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        lblWalkers.setForeground(new java.awt.Color(255, 51, 0));
        lblWalkers.setText("Walkers");
        lblWalkers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblWalkers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblWalkersMouseClicked(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(255, 51, 0));
        jSeparator1.setFont(new java.awt.Font("Segoe UI Semibold", 2, 36)); // NOI18N
        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 40));

        btnLogout.setBackground(new java.awt.Color(255, 50, 0));
        btnLogout.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(0, 51, 100));
        btnLogout.setText("Logout");
        btnLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogout.addActionListener(this::btnLogoutActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(lblOwners, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(lblWalkers, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(lblReports, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(lblOwners, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(lblWalkers, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(lblReports, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(187, 187, 187)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 250, 600);

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 102, 0));
        jPanel4.setPreferredSize(new java.awt.Dimension(650, 100));

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Muthu ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(505, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, -1));

        tblUsers.setBackground(new java.awt.Color(0, 51, 51));
        tblUsers.setFont(new java.awt.Font("Calibri", 3, 14)); // NOI18N
        tblUsers.setForeground(new java.awt.Color(0, 0, 0));
        tblUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id", "Name", "Email", "Mobile", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblUsers.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblUsers.setGridColor(new java.awt.Color(0, 51, 51));
        jScrollPane1.setViewportView(tblUsers);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 627, 250));

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));
        jPanel5.setToolTipText("");
        jPanel5.setPreferredSize(new java.awt.Dimension(650, 100));

        btnTitle.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        btnTitle.setText("Owners");

        btnFilterAll.setBackground(new java.awt.Color(51, 204, 255));
        btnFilterAll.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        btnFilterAll.setForeground(new java.awt.Color(0, 0, 0));
        btnFilterAll.setText("All");
        btnFilterAll.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFilterAll.addActionListener(this::btnFilterAllActionPerformed);

        btnFilterPending.setBackground(new java.awt.Color(255, 153, 0));
        btnFilterPending.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        btnFilterPending.setForeground(new java.awt.Color(0, 0, 0));
        btnFilterPending.setText("Pending");
        btnFilterPending.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFilterPending.addActionListener(this::btnFilterPendingActionPerformed);

        btnFilterRejected.setBackground(new java.awt.Color(255, 51, 51));
        btnFilterRejected.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        btnFilterRejected.setForeground(new java.awt.Color(0, 0, 0));
        btnFilterRejected.setText("Rejected");
        btnFilterRejected.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFilterRejected.addActionListener(this::btnFilterRejectedActionPerformed);

        filterApproved.setBackground(new java.awt.Color(102, 255, 102));
        filterApproved.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        filterApproved.setForeground(new java.awt.Color(0, 0, 0));
        filterApproved.setText("Approved");
        filterApproved.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        filterApproved.addActionListener(this::filterApprovedActionPerformed);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(btnTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105)
                .addComponent(btnFilterAll)
                .addGap(18, 18, 18)
                .addComponent(filterApproved)
                .addGap(24, 24, 24)
                .addComponent(btnFilterPending)
                .addGap(18, 18, 18)
                .addComponent(btnFilterRejected)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFilterAll)
                    .addComponent(btnFilterPending)
                    .addComponent(btnFilterRejected)
                    .addComponent(filterApproved))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 650, -1));

        btnRefresh.setBackground(new java.awt.Color(102, 102, 102));
        btnRefresh.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        btnRefresh.setForeground(new java.awt.Color(0, 0, 0));
        btnRefresh.setText("Refresh");
        btnRefresh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRefresh.addActionListener(this::btnRefreshActionPerformed);
        jPanel3.add(btnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 520, 110, 40));

        btnApprove.setBackground(new java.awt.Color(102, 255, 102));
        btnApprove.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        btnApprove.setForeground(new java.awt.Color(0, 0, 0));
        btnApprove.setText("Approve");
        btnApprove.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnApprove.addActionListener(this::btnApproveActionPerformed);
        jPanel3.add(btnApprove, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 520, 110, 40));

        btnReject.setBackground(new java.awt.Color(255, 0, 51));
        btnReject.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        btnReject.setForeground(new java.awt.Color(0, 0, 0));
        btnReject.setText("Reject");
        btnReject.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReject.addActionListener(this::btnRejectActionPerformed);
        jPanel3.add(btnReject, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 520, 110, 40));

        jPanel1.add(jPanel3);
        jPanel3.setBounds(250, 0, 650, 600);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        new Login().setVisible(true);   
        this.dispose();
           
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnFilterAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterAllActionPerformed
        currentStatus = null;
        loadUsers();
    }//GEN-LAST:event_btnFilterAllActionPerformed

    private void btnFilterPendingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterPendingActionPerformed
        currentStatus = "Pending";
        loadUsers();
    }//GEN-LAST:event_btnFilterPendingActionPerformed

    private void btnFilterRejectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterRejectedActionPerformed
         currentStatus = "Rejected";
         loadUsers();
    }//GEN-LAST:event_btnFilterRejectedActionPerformed

    private void btnApproveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApproveActionPerformed
         changeStatus("Approved"); 
    }//GEN-LAST:event_btnApproveActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
          loadUsers();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnRejectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRejectActionPerformed
        changeStatus("Rejected");
    }//GEN-LAST:event_btnRejectActionPerformed

    private void filterApprovedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterApprovedActionPerformed
       currentStatus = "Approved";
           loadUsers();
    }//GEN-LAST:event_filterApprovedActionPerformed

    private void lblOwnersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOwnersMouseClicked
        showRole("OWNER","Owners");
        
    }//GEN-LAST:event_lblOwnersMouseClicked

    private void lblWalkersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblWalkersMouseClicked
        showRole("WALKER","Walkers");
    }//GEN-LAST:event_lblWalkersMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new AdminPanel().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApprove;
    private javax.swing.JButton btnFilterAll;
    private javax.swing.JButton btnFilterPending;
    private javax.swing.JButton btnFilterRejected;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnReject;
    private javax.swing.JLabel btnTitle;
    private javax.swing.JButton filterApproved;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblOwners;
    private javax.swing.JLabel lblReports;
    private javax.swing.JLabel lblWalkers;
    private javax.swing.JTable tblUsers;
    // End of variables declaration//GEN-END:variables
}
