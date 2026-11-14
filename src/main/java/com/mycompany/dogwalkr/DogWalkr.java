/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.dogwalkr;

/**
 *
 * @author Admin
 */
public class DogWalkr {

    public static void main(String[] args) {
        System.out.println("Hello World!");
      com.formdev.flatlaf.FlatDarkLaf.setup();
        System.err.println(org.mindrot.jbcrypt.BCrypt.hashpw("Admin@123",org.mindrot.jbcrypt.BCrypt.gensalt()));
              
              
      
    }
}
