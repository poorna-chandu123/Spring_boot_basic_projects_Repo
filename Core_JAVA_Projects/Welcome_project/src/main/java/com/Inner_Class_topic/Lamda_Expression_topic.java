
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Inner_Class_topic;

/**
 *
 * @author annapureddy.chandu
 */
public class Lamda_Expression_topic {
    
    // edi tredistional method
    class one implements car{

        @Override
        public void drive() {
            System.out.println("BMW car code.......");
        }
        
     // anonymous class
        
        car sv = new car(){
            @Override
            public void drive() {
                
                System.out.println("anonymous car codeee.......");
               //sv.drive();
                
            } 
        };
        
       car sp =  ()-> {
           
                System.out.println("anonymous Function   car codeee.......");
                         
        };
        
        
    }
    
    public static void main(String[] args) {
        
        one o = new Lamda_Expression_topic().new one();
        o.drive();
        o.sv.drive();
        o.sp.drive();
   
        
        System.out.println("===========edi basical ga recomended====================");
   Lamda_Expression_topic.one test = new Lamda_Expression_topic().new one();
   
   test.drive();
   test.sp.drive();
   test.sv.drive();
        
        
    }
    
    
    interface car{
        
        public void drive();
    }
    
}