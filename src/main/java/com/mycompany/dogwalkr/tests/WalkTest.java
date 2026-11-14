/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dogwalkr.tests;

import com.mycompany.dogwalkr.service.WalkService;
import com.mycompany.dogwalkr.model.Walk;
import java.time.OffsetDateTime;
public class WalkTest {
    public static void main(String [] args){
        Walk w = new Walk();
        w.ownerId =11;
        w.dogId = 5;
        w.walkTime = OffsetDateTime.now().plusDays(1);
        w.durationMinutes = 30;
        w.notes = "Walk test check";
        
        System.out.println("Saved test walk check "+WalkService.bookWalk(w));
                
    }
}
