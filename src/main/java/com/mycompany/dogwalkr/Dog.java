package com.mycompany.dogwalkr;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */

 
public class Dog {
    public int id;
    public int ownerId;
    public String name ;
    public String breed;
    public int age;
    public String notes;
    public byte[] photo;
    
    
    @Override
 public String toString(){
     return name;
 }
   
    
}
