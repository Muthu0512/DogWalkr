package com.mycompany.dogwalkr;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class LoginTest {
    public static void main(String args[]){
        try{
            //Test 1 - wrong email
//            User u1 = UserService.login("abc@gmail.com","Admin@123");
//            System.out.println(u1==null?"test1 success unknown email": "Failed, because this is wrong email");
            
            //Test -2 wrong password
//            User u2 = UserService.login("muthupandi5199@gmail.com", "sdfks");
//            System.out.println(u2==null ? "success bcz wrong password": "failed because, it works even the password is wrong");

            //Test - 3 - for corret credential
            
            User u3 = UserService.login("muthupandi5199@gmail.com","Admin@123");
            if(u3==null){
                System.out.println("failed because user null" + u3);
                
            }else{
                System.out.println("success" + u3.username+"    "+ u3.status+"  " + u3.role ); 
            }
            
            for (Object[] row : UserService.getUsersByRole("OWNER", null)) {
    System.out.println(row[0] + " " + row[1] + " " + row[4]);
}
           
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
