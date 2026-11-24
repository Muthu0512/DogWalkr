/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dogwalkr.service;

import com.mycompany.dogwalkr.db.DB;
import com.mycompany.dogwalkr.model.Faq;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FaqService {
    private static final Set<String> STOP_WORDS = new HashSet<>(Arrays.asList("a","an","the","is","are",
            "can","do","does","my","i","you","to","of","in","on","it","what","how","should","dog","dogs",
            "me","for","and","or","with","have","has","be","if","when","eat"));
    
    private static Set<String> tokenize(String text){
        Set<String> words =new HashSet<>();
        String[] parts =text.toLowerCase().replaceAll("[^a-z0-9]"," ").split("\\s+");
        for (String w :parts){
            if(w.isEmpty()||STOP_WORDS.contains(w)){
                continue;
            }
            if(w.length()>3 &&w.endsWith("s")){
                 w= w.substring(0,w.length()-1);
            }
            words.add(w);
        }
        return words;
    }
    
    
    
    
    public static List<Faq> search(String question,String role,int limit) throws SQLException{
        Set<String> questionWords =tokenize(question);
        List<Faq> matches =new ArrayList<>();
        
        String sql ="SELECT id,category,audience,keywords,answer FROM faq "
                + "WHERE audience='ALL' OR audience=?";
        
        
        try(Connection con =DB.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1,role);
            try(ResultSet rs =ps.executeQuery()){
                while(rs.next()){
                Faq f = new Faq();
                f.id =rs.getInt("id");
                f.category = rs.getString("category");
                f.audience = rs.getString("audience");
                f.keywords = rs.getString("keywords");
                f.answer = rs.getString("answer");
                
                Set<String>  keywordWords= tokenize(f.keywords);
                int score = 0;
                for(String w:questionWords){
                    if(keywordWords.contains(w)){
                        score++;
                    }
                }
                f.score = score;
                if(score>0){
                    matches.add(f);
                }
               }
            }
        }
        matches.sort((a,b)-> b.score-a.score);
        if(matches.size()>limit){
            return new ArrayList<>(matches.subList(0,limit));
        }
        
        if(!matches.isEmpty()){
            int top =matches.get(0).score;
            matches.removeIf(f->f.score<top);
        }
        return matches;
    } 
    
}


