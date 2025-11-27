/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Oops_Interface_full_topic_with_JAVA_8;

/**
 *
 * @author annapureddy.chandu
 */
public class User {
    
    public static void main(String[] args) {
        
         Laptop_1 s =new DELL_1 (); // eila object create chesthe DELL lo security ni call cheyalemu because adi static kanuka adi object ni thisukodu Refrences ni base chesukoni data print avuthundi
        // DELL_1 s= new DELL_1(); // Eila rasukunte malli Dell Security ni print cheyachhu
         s.past();
        s.copy();
        s.cut();
        Laptop_1.security();  
        s.audio();  // DELL lo audio ni comment chesthe interface ki velthundi because non-static kanuka 1st chaild class lo di prefer chesthundi
        DELL_1.security(); // edi static method andulonu obeject creation Laptop_1 s =new DELL_1 (); eila chesam kanuka class name tho pilavali
       // s.security();
        
        
         System.out.println("===============================");
        System.out.println("===============================");
        
        
           Lenova_1 s1=new Lenova_1 ();
           
         s1.past();
        s1.copy();
        s1.cut();  //
        Laptop_1.security();  // static chesam kunaka INTERFACE name thone pilavali
        s1.security(); // object creation normal ga chesam kanuka pilavagali gamu eikkda
        s1.audio(); // audio comment chesam ani Interfase ki velthundi Ala ani Laptop_1 Error vathundi yendukante audio ni ststic ga rayaledu 
       
        
     //   Laptop_1 s3 =new Laptop_1();  // INTERFACE ki object create cheyalemu
        
        
    }
    
    
    
}
