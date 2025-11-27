/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Collections_LIST_topic;

import java.util.*;
import java.util.Map;

/**
 *
 * @author annapureddy.chandu
 */
public class HashTable_Maptoipc {
    
    public static void main(String[] args) {
        
        Map <Integer,String> h = new HashMap<>();
        
        // Adding
        h.put(45, "chandu");
         h.put(34, "kiran");
        
          h.put(23, "vasu");
         h.put(45, "poorna"); // KEY anedi unique vuntadi kanuka same key tho value isthe old data lo NEW data store avuthundi
         
         System.out.println(h);
         
  //  -------> Retrival keys from the Map(ONLY key ni retrive cheyatam)
         
         // mana key values Integer kanuka Integer ani oichham
       Set <Integer> keys = h.keySet();  // E keyset(); anedi oka set set ane object ni return chesthundi
          for (Integer key : keys) {       // dani For LOOP lo vadukoni keys ni thechhukovali
            
              System.out.println(key);
              
        }
          System.out.println("===========================================");
        // -------> Retrival of values (yetuvanti keys ni pass cheyakunda anni values retrive cheyatam)
             Collection <String> values= h.values(); // h.values(); anedi Collection <String> ni return chesthundi
            for (String key : values) {       
            
              System.out.println(key);
              
        }
           System.out.println("=====================");                               
         // ------> key ni pass only oka particular value ni get cheyatam
          
          System.out.println(h.get(23));
          
          // Map lo vunna anni values ni KEY ni base chesukoni Retrive chesukovatam
          for (Integer key : keys) {       
            
              System.out.println(key+"----->"+h.get(key));
        }
          
          //Deleting of element from the map
          h.remove(34);
          System.out.println(h);
          
          // verification of the element 
          System.out.println(h.containsKey(34));
          System.out.println(h.containsValue("vasu"));
          
          //  udation ante add ki ye method vadathamoo ade allredy vunna KEY ni pass chesi  
          h.put(45,("updated name poorna"));
          h.putIfAbsent(45, "edi update avvsdu"); // putIfAbsent anedi All Ready value vunte adi update cheyadu & insert cheyadu

        System.out.println(h);
    
    
    }
         
}    
 
