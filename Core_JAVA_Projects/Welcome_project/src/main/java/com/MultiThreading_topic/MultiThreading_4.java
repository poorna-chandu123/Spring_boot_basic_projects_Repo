/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MultiThreading_topic;

/**
 *
 * @author annapureddy.chandu
 */
public class MultiThreading_4 {
    public static void main(String[] args) {
        
        MultiThreading_4 m4 = new MultiThreading_4();
        
        m4.t3.start();;
        m4.t4.start();
        
        System.out.println(m4.t4.getName());
        
    }
    
    Runnable r11 = ()->{
        
        System.out.println(" @functional interface vadi EMP code");
        
    };
    
    
     Runnable r21 = ()->{
        
        System.out.println(" @functional interface vadi maneger  code");
        
    };
     
      Thread t3 = new Thread(r11);
   
   Thread t4 = new Thread(r21,"name for thread");

    
}
