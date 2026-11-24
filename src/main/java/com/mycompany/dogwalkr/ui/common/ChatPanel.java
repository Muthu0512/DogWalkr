/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.dogwalkr.ui.common;

import com.mycompany.dogwalkr.ai.BuddyService;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.SwingWorker;

public class ChatPanel extends javax.swing.JPanel {
        
    private String role = "OWNER";
    private final List<JButton> suggestionButtons = new ArrayList<>();
    
    public ChatPanel() {
        initComponents();
        suggestionButtons.add(btnSuggest1);
        suggestionButtons.add(btnSuggest2);
        suggestionButtons.add(btnSuggest3);
        
        btnSend.addActionListener(e-> ask(txtInput.getText()));
        txtInput.addActionListener(e-> ask(txtInput.getText()));
        btnSuggest1.addActionListener(e->ask(btnSuggest1.getText()));
        btnSuggest2.addActionListener(e-> ask(btnSuggest2.getText()));
        btnSuggest3.addActionListener(e-> ask(btnSuggest3.getText()));
        
        setRole("OWNER");
        appendLine("Buddy: Hi! Type a question or tap one below");
        
    }

        public ChatPanel(String role){
            this();
            setRole(role);
        }
         
        public final void setRole(String role){
            this.role = role;
            String[] questions = suggestionsFor(role);
            for(int i=0;i<suggestionButtons.size();i++){
                JButton b =suggestionButtons.get(i);
                if(i<questions.length){
                    b.setText(questions[i]);
                    b.setVisible(true);
                }else{
                    b.setVisible(false);
                }
            }
        }
   
        
     private static String[] suggestionsFor(String role){
         if("WALKER".equals(role)){
             return new String[]{
                 "A Stray dog is running towards us",
                 "How should I cross the road?",
                 "My dog is limping on the walk"
             };
         }
         if("ADMIN".equals(role)){
             return new String[]{
                 "How do I approve a walker?",
                 "My dog ate chocolate"
             };
         }
         return new String[]{
             "Can dogs eat grapes?",
             "My dog is Panting in the sun",
             "My dog is vomiting"
         };
     }   
     
     
     private void ask(String question){
         String q=question.trim();
         if(q.isEmpty()){
             return ;
         }
         appendLine("You : "+q);
         txtInput.setText("");
         setBusy(true);
         
         
         new SwingWorker<String, Void>(){
             @Override  
             protected String doInBackground() throws Exception{
                 return BuddyService.answer(q,role);
             }
             
             @Override
             protected void done(){
                 try{
                     appendLine("Buddy : "+ get());
                 }catch(Exception ex){
                     appendLine("Buddy: Sorry, something went wrong. Please try again later..");
                     ex.printStackTrace();
                 }finally{
                     setBusy(false);
                 }
             }
         }.execute();
     }
     
     
     private void setBusy(boolean busy){
         btnSend.setEnabled(!busy);
         txtInput.setEnabled(!busy);
         for(JButton b:suggestionButtons){
             b.setEnabled(!busy);
         }
     }
     
     private void appendLine(String text){
         txtChat.append(text+"\n\n");
         txtChat.setCaretPosition(txtChat.getDocument().getLength());
     }
        
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtChat = new javax.swing.JTextArea();
        btnSuggest1 = new javax.swing.JButton();
        btnSuggest2 = new javax.swing.JButton();
        btnSuggest3 = new javax.swing.JButton();
        txtInput = new javax.swing.JTextField();
        btnSend = new javax.swing.JButton();

        setBackground(new java.awt.Color(15, 14, 14));

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(0, 153, 153));
        lblTitle.setText("Buddy - Your  Dog Walkr helper");

        jScrollPane1.setBackground(new java.awt.Color(0, 51, 51));

        txtChat.setEditable(false);
        txtChat.setBackground(new java.awt.Color(51, 51, 51));
        txtChat.setColumns(20);
        txtChat.setLineWrap(true);
        txtChat.setRows(5);
        txtChat.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtChat);

        btnSuggest1.setText("Button1");

        btnSuggest2.setText("Button2");

        btnSuggest3.setText("Button3");

        txtInput.addActionListener(this::txtInputActionPerformed);

        btnSend.setBackground(new java.awt.Color(0, 102, 102));
        btnSend.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSend.setText("Send");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(btnSuggest1)
                        .addGap(18, 18, 18)
                        .addComponent(btnSuggest2)
                        .addGap(18, 18, 18)
                        .addComponent(btnSuggest3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 81, Short.MAX_VALUE)
                .addComponent(txtInput, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSend)
                .addGap(299, 299, 299))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lblTitle)
                .addGap(49, 49, 49)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSuggest1)
                    .addComponent(btnSuggest2)
                    .addComponent(btnSuggest3))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtInput, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSend))
                .addContainerGap(25, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtInputActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSend;
    private javax.swing.JButton btnSuggest1;
    private javax.swing.JButton btnSuggest2;
    private javax.swing.JButton btnSuggest3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextArea txtChat;
    private javax.swing.JTextField txtInput;
    // End of variables declaration//GEN-END:variables
}
