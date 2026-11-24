/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dogwalkr.ai;

import com.mycompany.dogwalkr.exceptions.OllamaNotRunningException;
import com.mycompany.dogwalkr.model.Faq;
import com.mycompany.dogwalkr.service.FaqService;


import java.sql.SQLException;
import java.util.List;

public class BuddyService {
    
    private static final boolean USE_AI = false;
    private static final String NO_ANSWER = "I'm not sure about that. Please ask a vet or the Dogwalkr admin";
    
    public static String answer(String question, String role)throws SQLException,OllamaNotRunningException{
     List<Faq> facts = FaqService.search(question,role,2);
     if(facts.isEmpty()){
         return NO_ANSWER;
     }
     if(!USE_AI){
         return facts.get(0).answer;
     }
     String systemPrompt =PromptBuilder.build(facts);
     return OllamaClient.ask(systemPrompt,question);
    }
}
