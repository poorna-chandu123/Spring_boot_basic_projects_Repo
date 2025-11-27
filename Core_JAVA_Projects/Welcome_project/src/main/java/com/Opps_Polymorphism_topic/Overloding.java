/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Opps_Polymorphism_topic;

/**
 *
 * @author annapureddy.chandu
 */
public class Overloding {
    
    public static void m1(){
        
        System.out.println("non-parameters method");
        
    }
    
    public void m1(int a){
        System.out.println("singile parameter method");
        
    }
    
    private void m1(int a, int b){
        
        System.out.println("two parameters method");
        
    }
    
    public static void main(String[] args) {
        
        Overloding ov = new Overloding();
        
        ov.m1(0);
        ov.m1(1, 2);
        ov.m1();
    }
    
}
