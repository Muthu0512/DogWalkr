/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dogwalkr;

/**
 *
 * @author Admin
 */
public class DogTest {
    public static void main(String args[]){
        Dog d = new Dog();
        d.ownerId = 11;
        d.name = "Tiger";
        d.breed = "Lab";
        d.age =3 ;
        d.notes = "friendly";
        
        System.out.println("Saved " + DogService.addDog(d));
                
        
    }
}
