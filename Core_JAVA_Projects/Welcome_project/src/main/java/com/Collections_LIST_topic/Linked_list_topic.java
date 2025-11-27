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
public class Linked_list_topic {
    public static void main(String[] args) {
        LinkedList<Integer> l = new LinkedList<>();
        l.add(2);
        l.add(3);
        l.add(0, 4);
        System.out.println(l);
        System.out.println(l.getLast());
        System.out.println(l.remove(2));
        System.out.println(l);
        System.out.println(l.remove(1));
        System.out.println(l);
        
        System.out.println(l.contains(5));  // linked link lo values anevi NODE ropam lo store Avuthaei... "previous,data,Next" 
                                                // oka chain link laga connect avuthaei
     Object[] arr1 = new Object[]{0, 0, 0, 0};
        LinkedList v3 = new LinkedList(Arrays.asList(arr1));

        System.out.println(v3);
        System.out.println(v3.size());
      //  System.out.println(v3.capacity());
      
      
         Integer []i = new Integer[]{1,2,3,4};
        
        LinkedList<Integer> a1 = new LinkedList(Arrays.asList(i));
        
        a1.add(6);
        System.out.println(a1.contains(2));  // value ni search cheyataniki
        
        System.out.println(a1);
        
        for (int j = 0; j < a1.size(); j++) {
            
            System.out.println(a1.get(j));
            
        }
       
        
        
    
    
    
    }                                          
    
    
    
    
    
   
    
}
