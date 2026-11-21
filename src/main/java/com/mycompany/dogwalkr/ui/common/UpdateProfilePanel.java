/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.dogwalkr.ui.common;

import com.mycompany.dogwalkr.db.Session;
import com.mycompany.dogwalkr.model.User;
import com.mycompany.dogwalkr.service.UserService;
import com.mycompany.dogwalkr.exceptions.WrongPasswordException;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Image;

import java.io.File;
import java.nio.file.Files;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;




public class UpdateProfilePanel extends javax.swing.JPanel {

    /**
     * Creates new form UpdateProfilePanel
     */
    
    private byte[] newPhoto = null;
    public UpdateProfilePanel() {
        initComponents();
        loadProfile();
    }

   private void loadProfile(){
       if(Session.currentUser == null){
           JOptionPane.showMessageDialog(this,"Please login first"); 
           return ;
       }
       
       User u = new UserService().getUserById(Session.currentUser.id);
       
       if(u==null){
           JOptionPane.showMessageDialog(this,"Sorry, Unable to load your profile");
           return;
       }
       
       txtUsername.setText(u.username);
       txtEmail.setText(u.email);
       txtMobile.setText(u.mobile);
       txtLocation.setText(u.location);
       
       pwdOld.setText("");
       pwdNew.setText("");
       pwdConfirm.setText("");
       
       showPhoto(u.photo);
       newPhoto = null;
       
   }
   
   private void showPhoto(byte[] data){
       if(data==null || data.length ==0){
           lblPhoto.setIcon(null);
           lblPhoto.setText("No Image");
           return;
       }
       
    ImageIcon icon = new ImageIcon(data);
    Image scaled =icon.getImage().getScaledInstance(150,150, Image.SCALE_SMOOTH);
    lblPhoto.setText("");
    lblPhoto.setIcon(new ImageIcon(scaled));
    
   }
   
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblPhoto = new javax.swing.JLabel();
        btnChoosePhoto = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtMobile = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtLocation = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        btnSaveProfile = new javax.swing.JButton();
        pwdOld = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        pwdNew = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();
        pwdConfirm = new javax.swing.JPasswordField();
        jLabel11 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(16, 15, 15));
        setMinimumSize(new java.awt.Dimension(900, 600));
        setPreferredSize(new java.awt.Dimension(900, 600));

        jLabel1.setFont(new java.awt.Font("High Tower Text", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 204));
        jLabel1.setText("Update Profile");

        jPanel1.setBackground(new java.awt.Color(20, 23, 23));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        lblPhoto.setBackground(new java.awt.Color(0, 102, 102));
        lblPhoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPhoto.setText("No Image");

        btnChoosePhoto.setBackground(new java.awt.Color(20, 86, 86));
        btnChoosePhoto.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btnChoosePhoto.setForeground(new java.awt.Color(0, 0, 0));
        btnChoosePhoto.setText("Choose Photo");
        btnChoosePhoto.addActionListener(this::btnChoosePhotoActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnChoosePhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(btnChoosePhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(20, 23, 23));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("Profile Details");

        txtUsername.setEditable(false);
        txtUsername.setBackground(new java.awt.Color(30, 33, 33));
        txtUsername.setForeground(new java.awt.Color(125, 132, 145));
        txtUsername.setText("muthu");
        txtUsername.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtUsername.setFocusable(false);

        jLabel4.setForeground(new java.awt.Color(0, 153, 204));
        jLabel4.setText("Username");

        jLabel5.setForeground(new java.awt.Color(0, 153, 204));
        jLabel5.setText("Email");

        txtEmail.setEditable(false);
        txtEmail.setBackground(new java.awt.Color(30, 33, 33));
        txtEmail.setForeground(new java.awt.Color(125, 132, 145));
        txtEmail.setText("muthu@gmail.com");
        txtEmail.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtEmail.setFocusable(false);

        txtMobile.setText("9876543210");
        txtMobile.addActionListener(this::txtMobileActionPerformed);

        jLabel6.setForeground(new java.awt.Color(0, 153, 204));
        jLabel6.setText("Mobile");

        jLabel7.setForeground(new java.awt.Color(0, 153, 204));
        jLabel7.setText("Location");

        txtLocation.setText("Ekkattuthangal");

        jLabel2.setBackground(new java.awt.Color(153, 255, 255));
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Username and Email can't be changed");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMobile, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(85, 85, 85)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(142, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMobile, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(20, 23, 23));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 102));
        jLabel8.setText("Change Password");

        btnSaveProfile.setBackground(new java.awt.Color(0, 156, 203));
        btnSaveProfile.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnSaveProfile.setForeground(new java.awt.Color(0, 0, 0));
        btnSaveProfile.setText("Save Profile");
        btnSaveProfile.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        btnSaveProfile.addActionListener(this::btnSaveProfileActionPerformed);

        pwdOld.setText("jPasswordField1");

        jLabel9.setForeground(new java.awt.Color(0, 153, 204));
        jLabel9.setText("Current Password");

        pwdNew.setText("jPasswordField1");

        jLabel10.setForeground(new java.awt.Color(0, 153, 204));
        jLabel10.setText("Confirm New Password");

        pwdConfirm.setText("jPasswordField1");

        jLabel11.setForeground(new java.awt.Color(0, 153, 204));
        jLabel11.setText("New Password");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSaveProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pwdOld, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(67, 67, 67)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pwdNew, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pwdConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(jLabel11)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pwdOld, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(pwdNew, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pwdConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btnSaveProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnChoosePhotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChoosePhotoActionPerformed
      JFileChooser chooser = new JFileChooser();
      chooser.setFileFilter(new FileNameExtensionFilter("Image (JPG,PNG)","jpg","jpeg","png"));
      
      int result = chooser.showOpenDialog(this);
      if(result !=JFileChooser.APPROVE_OPTION){
          return;
      }
      File file = chooser.getSelectedFile();
      
      if(file.length()>2*1024*1024){
          JOptionPane.showMessageDialog(this,"photo must be less than 2MB");
          return;
      }
      try{
          if(ImageIO.read(file)==null){
              JOptionPane.showMessageDialog(this,"This is not a valid file");
              return ;
          }
          newPhoto = Files.readAllBytes(file.toPath());
          showPhoto(newPhoto);
      }catch(java.io.IOException e){
        JOptionPane.showMessageDialog(this, "Unable to read the photo");
      }
    }//GEN-LAST:event_btnChoosePhotoActionPerformed

    private void txtMobileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMobileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMobileActionPerformed

    private void btnSaveProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveProfileActionPerformed
            if(Session.currentUser ==null){
                JOptionPane.showMessageDialog(this,"Please login first");
                return;
            }
            long userId = Session.currentUser.id;
            
            String mobile =txtMobile.getText().trim();
            String location = txtLocation.getText().trim();
            String oldPwd =new String(pwdOld.getPassword());
            String newPwd = new String(pwdNew.getPassword());
            String confirmPwd = new String(pwdConfirm.getPassword());
            
            if(mobile.isEmpty()){
                JOptionPane.showMessageDialog(this,"Mobile number cannot be empty");
                return;
            }
            
            if(location.isEmpty()){
                JOptionPane.showMessageDialog(this,"Location cannot be empty");
                return;
            }
            
            boolean changingPassword = !(oldPwd.isEmpty() && newPwd.isEmpty() && confirmPwd.isEmpty());
            
            if(changingPassword){
                if(oldPwd.isEmpty() || newPwd.isEmpty() || confirmPwd.isEmpty()){
                    JOptionPane.showMessageDialog(this,"To change password all passwords should be filled");
                    return;
                }
                if(!newPwd.equals(confirmPwd)){
                    JOptionPane.showMessageDialog(this,"New password and Confirm Password should be same");
                    return;
                }
                try{
                    if(!UserService.changePassword(userId,oldPwd,newPwd)){
                        JOptionPane.showMessageDialog(this,"Could not change the password ");
                        return;
                    }
                    
                }catch(WrongPasswordException e){
                    JOptionPane.showMessageDialog(this,"Current password is incorrect");
                    return;
                }
            }
            
            if(!UserService.updateProfile(userId,mobile,location)){
                JOptionPane.showMessageDialog(this, "Unable to update your profile , try again!");
                return;
            }
            
            if(newPhoto !=null){
                if(!UserService.updatePhoto(userId,newPhoto)){
                    JOptionPane.showMessageDialog(this, "unable to save the photo");
                    return;
                }
                newPhoto= null;
            }
            pwdOld.setText("");
            pwdNew.setText("");
            pwdConfirm.setText("");
            JOptionPane.showMessageDialog(this, "Profile updated Successfully");
    }//GEN-LAST:event_btnSaveProfileActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChoosePhoto;
    private javax.swing.JButton btnSaveProfile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblPhoto;
    private javax.swing.JPasswordField pwdConfirm;
    private javax.swing.JPasswordField pwdNew;
    private javax.swing.JPasswordField pwdOld;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtLocation;
    private javax.swing.JTextField txtMobile;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
