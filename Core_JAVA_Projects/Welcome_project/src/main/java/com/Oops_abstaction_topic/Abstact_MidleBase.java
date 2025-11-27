/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Oops_abstaction_topic;

/**
 *
 * @author annapureddy.chandu
 */
public abstract class  Abstact_MidleBase implements Laptop {
    
        @Override 
    public void cut(){
            System.out.println("cut abstact code");
        }
    @Override
    public void copy(){
        System.out.println("copy abstact code");
    }
    @Override
    public void past(){
        System.out.println("past abstact code");
    }

   // @Override// rasina rakunnna error radu
    public abstract void security();  // class lo imlimentation cheyataniki  vadilesam
    
    public abstract void audio();
    
}
