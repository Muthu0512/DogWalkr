/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dogwalkr.model;

/**
 *
 * @author Admin
 */
public class Fare {
    public int walkerPay;
    public int platformFee;
    
    private Fare(int walkerPay, int platformFee){
    this.walkerPay = walkerPay;
    this.platformFee = platformFee;
    }
    
    public int total(){
        return walkerPay + platformFee;
    }
    
    public static Fare forDuration(int minutes){
        if(minutes<=15){
            return new Fare(50,20);
          }
        else if (minutes<=30){
            return new Fare(110,25);
        }
        else if(minutes <=45){
            return new Fare(165,35);
        }
        else {
            return new Fare(220,45);
        }
    }

    
}
