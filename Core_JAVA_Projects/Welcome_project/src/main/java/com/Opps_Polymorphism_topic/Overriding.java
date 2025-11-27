/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Opps_Polymorphism_topic;

/**
 *
 * @author annapureddy.chandu
 */
public class Overriding {
    
    public  void add(){
        System.out.println("parent class add");
    }
    public  void copy(){
         System.out.println("parent class copy");
    }
    
    public  static void pic(){
         System.out.println("parent class pic"); //  dinni chiled class lo over ride cheyalemu & dinni direct ga Main(); lo call cheyachhu because edi static method
    } 
    
    
    /*NOTE :- oka vela pic method child class lo vundi parent class lo lekunda object creation eila vunte Overriding s =new Overridding_2(); 
              s.pic(); anagane compile time error vasthundi ade revers lo vunte parent class lo data vasthundi 
             Overridding_2 s =new Overridding_2(); vudi chaild lo method lekunna parent data vasthundi because Extends chesam kanuka
    
*/
}


