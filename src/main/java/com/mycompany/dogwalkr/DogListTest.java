/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dogwalkr;

import java.util.List;

public class DogListTest {
    public static void main(String[] args){
        int ownerId = 11;
        List<Dog> dogs = DogService.getDogsByOwner(ownerId);
        System.out.println("Dogs found "+dogs.size());
        
        for (Dog d : dogs){
            System.out.println(d.id + " |" + d.name + " |"+d.breed+" |"+d.age+"|photo bytes"+(d.photo ==null?0:d.photo.length));
        }
        
    }
}
