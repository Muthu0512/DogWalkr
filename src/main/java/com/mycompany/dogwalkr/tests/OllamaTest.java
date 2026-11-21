/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dogwalkr.tests;

import com.mycompany.dogwalkr.ai.OllamaClient;
import com.mycompany.dogwalkr.exceptions.OllamaNotRunningException;

/**
 *
 * @author Admin
 */
public class OllamaTest {
    public static void main(String args[]){
        try{
            String answer =OllamaClient.ask("You are buddy, a friendly helper for dog walkers. Answer in one "
                    + "or two short senteces" , "say Hello");
           System.out.println("buddy says ==> "+ answer);
        }catch(OllamaNotRunningException e){
            System.out.println("Problem in Ollama Test :"+e.getMessage());
        }
    }
}
