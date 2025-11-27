/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Collections_LIST_topic;

import java.util.*;

/**
 *
 * @author annapureddy.chandu
 */
public class ArrayList_topic {
    
    public static void main(String[] args) {
        
        Integer []i = new Integer[]{1,2,3,4};
        
        ArrayList<Integer> a1 = new ArrayList(Arrays.asList(i));  // oka Array ni List lo ki pampinchali ante Arrays.asList(); METHOD ni vadali 
        
        a1.add(6);
        System.out.println(a1.contains(2));  // value ni search cheyataniki  
         Collections.sort(a1); // Sort the list before using binarySearch() edi kuda search cheyatanike but edi INDEX ni eisthundi
        
        System.out.println(a1);
        
        
      // for loop ni vadi print cheyatam 
      for(int j =0; j<a1.size();j++){
          
          System.out.println(a1.get(j));
      }
      
        System.out.println("======================");
      
        for (Integer integer : a1) {
            
            System.out.println(integer);
            
            Collections.synchronizedList(a1); // internal ga vector laga threads ni handle chesthundi
           
            
            
            
        }
        
    }
    
    
}
