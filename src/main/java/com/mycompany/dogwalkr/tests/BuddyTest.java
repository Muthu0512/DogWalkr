/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dogwalkr.tests;

import com.mycompany.dogwalkr.ai.BuddyService;

public class BuddyTest {

    public static void main(String args[]) throws Exception {
        String[] questions = {
            "Can dogs eat grapes?",
            "My dog is panting a lot in the sun",
            "how do I fly a rocket?"
        };

        for (String q : questions) {
            long start = System.currentTimeMillis();
            String reply = BuddyService.answer(q, "WALKER");
            long seconds = (System.currentTimeMillis() - start) / 1000;

            System.out.println("Q: " + q);
            System.out.println("Buddy : " + reply);
            System.out.println("( " + seconds + " )\n");
        }
    }
}
