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
public class Enumarator_topic {
    public static void main(String[] args) {
        
        Vector<Integer> v = new Vector<>();
        v.add(4);
        v.add(5);
      //  Enumeration anedi only LEGACY class ki matharame..  
       Enumeration<Integer> e =v.elements(); //---> v.elements(): anedi  Enumeration return chesthundi
       
     //  e.hasMoreElements(); --> edi next element vunda leda ani check chesthundi BOOLEAN Return chesthundi 
     //  e.nextElement();  ---> edi elemens ni Acces cheyataniki use avuthundi
     
     while (e.hasMoreElements()){
         System.out.println(e.nextElement()); // only FORWARD direction lone Loop Run cheyagalamu
     }
    
      
    }
   
}
