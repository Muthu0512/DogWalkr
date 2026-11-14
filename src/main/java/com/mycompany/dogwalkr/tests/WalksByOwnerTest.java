/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dogwalkr.tests;

import com.mycompany.dogwalkr.service.WalkService;
import com.mycompany.dogwalkr.model.WalkHistory;
import java.util.List;
public class WalksByOwnerTest {
    public static void main(String [] args){
        int ownerId =11;
        List<WalkHistory> walks = WalkService.getWalksByOwner(ownerId);
        System.out.println("walks found :"+walks.size());
        for (WalkHistory h : walks){
            System.out.println(h.id + " - " + h.dogName + " - "+h.walkTime + " - " + h.durationMinutes + " - " + h.status + " - " +h.notes);
        }
    }
}
