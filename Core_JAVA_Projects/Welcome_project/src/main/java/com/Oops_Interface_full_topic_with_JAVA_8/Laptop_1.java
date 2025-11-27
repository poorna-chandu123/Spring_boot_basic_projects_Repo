/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Oops_Interface_full_topic_with_JAVA_8;

/**
 *
 * @author annapureddy.chandu
 */
public interface Laptop_1 {
    
      public void cut();
    
    public void copy();
    
    
    public void past();
   
    
    
   public static  void security(){
        
        System.out.println("interface security changes Laptop ");  // edi by default ga annitiki vasthundi same dinni yem anna 
        // changes cheyali anukunte a class lo e name tho method create chesukunna @Override rasthe ERROR vasthundi 
        // changes cheyataniki einduloni code ni changes cheyataniki kudaradu
    }
    
    default  void audio(){
        System.out.println("interface audio changes "); // but diniki ala kadu @Override avuthundi no problum because edi static kadu kanuka
    }
    
    
}
