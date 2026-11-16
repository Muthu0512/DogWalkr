/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dogwalkr.tests;
import com.mycompany.dogwalkr.service.UserService;
import com.mycompany.dogwalkr.exceptions.WrongPasswordException;
/**
 *
 * @author Admin
 */
public class ChangePasswordTest {
    public static void main (String args[]){
           long id = 13; 
        try{
            System.out.println(UserService.changePassword(id,"walker@123","123456")); 
        }catch(WrongPasswordException e){
            System.out.println("ERROR "+e.getMessage());
        }
                
        
//        System.out.println(us.changePassword(id,"Walker1@123","123456"));
       
                
        
    }
}
