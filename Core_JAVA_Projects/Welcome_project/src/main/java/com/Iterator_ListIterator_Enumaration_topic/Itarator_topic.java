/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Iterator_ListIterator_Enumaration_topic;

import java.util.*;

/**
 *
 * @author annapureddy.chandu
 */
public class Itarator_topic {
    public static void main(String[] args) {
        
        ArrayList<Integer> a = new ArrayList<>();
        a.add(2);
        a.add(7);
        a.add(9);
        
       Iterator<Integer> i = a.iterator();
       // i.hasNext();  --> edi next element vunda leda ani check chesthundi BOOLEAN Return chesthundi 
       // i.next();   ---> edi elemens ni Acces cheyataniki use avuthundi
       
       while (i.hasNext()){
           System.out.println(i.next()); // only FORWARD direction lone Loop Run cheyagalamu 
       }
       
       
       // special method for Removing the Iterator object
       
       i.remove();  // only first element ne remove chesthundi malli eisthe malli next eliment ni remove chesthundi LOOP run chesthe mothham delete cheyachhu
        System.out.println("==================");
        System.out.println(a);

        
         while (i.hasNext()){
            i.next();
            i.remove(); // Remove the current element pointed by the iterator
        }
        
        System.out.println(a);
        
        /*
        NOTE :- edi MAP conect ki work avvadu, because MAP collection frame work topic kani collection topic kadu 
        
        BUT Internal Method ni vadi Iterator ni vadchhu
        */
        
        HashMap<String,Integer> h = new HashMap<> ();
        h.put("chandu", 4);
         h.put("kiran", 98);
         
     h.keySet().iterator();
        h.values().iterator();
        h.entrySet().iterator();
        
       
       
    }

    
}
