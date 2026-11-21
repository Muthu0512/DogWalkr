/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dogwalkr.ai;

import com.mycompany.dogwalkr.exceptions.OllamaNotRunningException;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.time.Duration;
import java.io.IOException;

public class OllamaClient {
    private static final String URL = "http://localhost:11434/api/chat";
    private static final String MODEL = "tinyllama";
    
    private static final HttpClient CLIENT = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(5)).build();
    
   
    
    public static String ask(String systemPrompt, String question) throws OllamaNotRunningException{
        JsonObject system = new JsonObject();
        system.addProperty("role", "system");
        system.addProperty("content", systemPrompt);
        
        JsonObject user = new JsonObject();
        user.addProperty("role","user");
        user.addProperty("content", question);
        
        JsonArray messages = new JsonArray();
        messages.add(system);
        messages.add(user);
        
        JsonObject options = new JsonObject();
        options.addProperty("temperature",0);
        options.addProperty("num_predict",80);
        
        
        JsonObject body = new JsonObject();
        body.addProperty("model", MODEL);
        body.add("messages", messages);
        body.addProperty("stream",false);
        body.add("options", options);
        
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .timeout(Duration.ofSeconds(120))
                .header("Content-Type","application/json")
                .POST(HttpRequest.BodyPublishers.ofString(body.toString()))
                .build();
        
        
        
        try{
            HttpResponse<String> response = CLIENT.send(request,HttpResponse.BodyHandlers.ofString());
            
            System.out.println("Raw data : "+ response.body());
            
            if(response.statusCode() !=200){
                throw new OllamaNotRunningException("Ollama returned status "+response.statusCode()+" : "+response.body(), null);
            }
            
            JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();
            
            return json.getAsJsonObject("message").get("content").getAsString().trim();
            
        }catch(IOException e){
          throw new OllamaNotRunningException ("Unable to reach Ollama, is it running or not ?",e);
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
            throw new OllamaNotRunningException("The request was interrupted ",e);
        }
        
        
    }
}
