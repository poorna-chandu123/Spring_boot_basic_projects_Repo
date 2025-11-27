/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Oops_Interface_full_topic_with_JAVA_8;

/**
 *
 * @author annapureddy.chandu
 */
public class DELL_1 implements Laptop_1 {

    @Override
    public void cut() {
        System.out.println("DELL_1 CUT");
    }

    @Override
    public void copy() {
         System.out.println("DELL_1 copy");
    }

    @Override
    public void past() {
         System.out.println("DELL_1 past");
    }

     @Override
    public void audio() {  // diniki error radu static cheyala kanuk
         System.out.println("DELL_1 audio");
    }  
    
   // @Override
    public static  void security(){  // dinni INTERFACE lo impliment chesetappudu STATIC NI vadamu
        
        System.out.println("DELL_1 security ");  
        
    }
    
    
    
}
