/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dogwalkr.ai;

import com.mycompany.dogwalkr.model.Faq;
import java.util.List;

public class PromptBuilder {
        
    public static String build(List<Faq> facts){
        StringBuilder sb=new StringBuilder();
        sb.append("You are a Buddy, a friendly helper inside the Dogwalkr app");
        sb.append("Answer in one or two short sentences using ONLY the facts below");
        sb.append("Do not add anything that is not in the facts.\n\n");
        sb.append("Facts: \n");
        
        for (Faq f:facts){
            sb.append("- ").append(f.answer).append("\n");
        }
        
      return sb.toString();
    }
}
