/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Oops_Interface_full_topic_with_JAVA_8;

/**
 *
 * @author annapureddy.chandu
 */
public class Lenova_1 implements Laptop_1 {
        @Override
    public void cut() {
        System.out.println("Lenova_1 CUT");
    }

    @Override
    public void copy() {
         System.out.println("Lenova_1 copy");
    }

    @Override
    public void past() {
         System.out.println("Lenova_1 past");
    }

//     @Override
//    public void audio() {  // diniki error radu static cheyala kanuk  // edi rayakunda INTERFACE lo impliment chesinadi thisukunnam
//         System.out.println("DELL_1 audio");
//    }

    // E menthod ni comment chesina Error Rakapovataniki Reason All redy interface lo dini implimentation chesam kanuka.
    // E class interface loni code vaddu anukunte rasukovachhu ledu anukunte ledu
    
    


  //   @Override // @Override rasthe Error vasthundi because static kanuka
    public static  void security(){  // eikkada same namtho method create chesamu anappudu INTERFACE lodi thisukodu e class lonide 
                                     // thisukuntadi
                                     
        System.out.println("Lenova_1 security ");  
        
    }
    
    
}
