/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dogwalkr.tests;

import com.mycompany.dogwalkr.model.Faq;
import com.mycompany.dogwalkr.service.FaqService;
import java.util.List;


public class FaqSearchTest {
    public static void main(String [] args)throws Exception{
        String [] question = {
            "can dogs eat grapes?",
            "my dog is panting a lot in the sun",
            "a stray dog is running towards us"
        };
        
        for (String q: question){
            System.out.println("Ques "+q);
            List<Faq> found = FaqService.search(q,"WALKER",3);
            for (Faq f : found){
                System.out.println(" [ " +f.score + " ] "+ f.category+ " : "+ f.answer);
            }
            
        }
    }
}
