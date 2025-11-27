/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MultiThreading_topic;

/**
 *
 *     anonymous class ni vadi threads ni use chesamu
 */
public class MultiThreading_3 {

    public static void main(String[] args) {
        
       
    Runnable r1 = new Runnable() { //  // ante we are implimenting the interfce by using the anonimous class 

        public void run() {
            
            System.out.println("emp code edi");

        }
    };

    Runnable r2 = new Runnable() {

        public void run() {
            System.out.println("maneger code edi");

        }
    };
    
   Thread t1 = new Thread(r1);
   
   Thread t2 = new Thread(r2,"name for thread");

        
        t1.start();
        t2.start();

        
        // NoTE :- previous laga Main(); method kinda rasi kuda cheyachhu
    }

}
