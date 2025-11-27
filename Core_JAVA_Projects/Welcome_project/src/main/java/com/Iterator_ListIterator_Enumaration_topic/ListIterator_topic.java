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
public class ListIterator_topic {
    public static void main(String[] args) {
        
        ArrayList<Integer> a = new ArrayList<>();
        a.add(8);
        a.add(5);
        a.add(23);
        
       ListIterator<Integer> li =a.listIterator();
       
    /* li.hasNext();---->  edi next element vunda leda ani check chesthundi BOOLEAN Return chesthundi 
     li.next();  ----> edi elemens ni Acces cheyataniki use avuthundi
     li.hasPrevious();  --->  edi Previous element vunda leda ani check chesthundi BOOLEAN Return chesthundi 
      li.previous();  --> edi elemens ni Acces cheyataniki use avuthundi
       */
    /* FORWARD & BACKED lo Loop Run cheyachhu
    * delete & Add & read cheyachhu
    * only List concepts ni matharame vadagalamu
*/
    while (li.hasNext()){
         System.out.println(li.next()); 
     }
    System.out.println("==================");
    while(li.hasPrevious()){
        System.out.println(li.previous());
    }
    
     li.remove();  // only first element ne remove chesthundi malli eisthe malli next eliment ni remove chesthundi LOOP run chesthe mothham delete cheyachhu
        System.out.println("==================");
        System.out.println(a);

        
           while (li.hasNext()){
             li.next();
             li.remove(); // for removing all elements
       }
        
        System.out.println(a);
         System.out.println("==============");
         li.add(4);
         li.add(8);
         System.out.println(a);
    
    }
}
