/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Inner_Class_topic;

/**
 *
 * @author annapureddy.chandu
 */
public class Anonymous_class_topic {
    
    
    public static void main(String[] args) {
        
        bike s = new Anonymous_class_topic().new bike();
        
        s.drive();
        
       
       // edi anonimous class 
        a f = new a(){ // interface ki object create chesi daniki direct ga mothod rayatam 
                       // ante we are implimenting the interfce by using the anonimous class
                
               public void drive(){
             System.out.println("car ...code with anonymous class ");
         } 
            };  // eikkadi daka anonymous class
        
        f.drive();
        
    }
    
    
    class bike implements a  { // eppati varaku interface lo vunna method ni vadukune vidanam class ni impliment chesi rayadam
        
        public void drive(){
             System.out.println("bike ...code ");
         }
        
        
       
        
    }
    // Edi oka Interface
    public interface a{
        public void drive();
        
        
    } 
}
