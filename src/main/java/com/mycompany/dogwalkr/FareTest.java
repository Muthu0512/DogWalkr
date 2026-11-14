/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dogwalkr;

/**
 *
 * @author Admin
 */
public class FareTest {
    public static void main(String args[]){
        for (int m=5;m<=60; m+=5){
            Fare f = Fare.forDuration(m);
            System.out.println(m + " min  ==> walker "+f.walkerPay + "  ***you get -  "+ f.platformFee+ "*** Owner pays - "+ f.total());
        }
    }
}
