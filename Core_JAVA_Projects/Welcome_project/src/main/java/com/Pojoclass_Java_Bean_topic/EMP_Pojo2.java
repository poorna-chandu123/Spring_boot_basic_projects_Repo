/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Pojoclass_Java_Bean_topic;



/**
 *
 * @author annapureddy.chandu
 */
public class EMP_Pojo2 {
    
     public static void main(String[] args) {
         
        Emp_Pojo d= new Emp_Pojo();
        
        d.setId(1);
        d.setName("kiran");
        
         System.out.println(d.getId());
         System.out.println(d.getName());
         
         
         System.out.println("=====================================");
         
        // OKa ARRAY ni vadi chesam  ade code ni user yekkuva print cheyali anukoni
        Emp_Pojo[] users = new Emp_Pojo[3];
        
        // Creating instances of NewClass and setting values for each user
        users[0] = new Emp_Pojo();
        users[0].setId(121);
        users[0].setName("chandu");
        
        users[1] = new Emp_Pojo();
        users[1].setId(122);      
        users[1].setName("john");
        
        users[2] = new Emp_Pojo();
        users[2].setId(123);
        users[2].setName("alice");
        
        // Printing the values for each user
        for (int i = 0; i < users.length; i++) {
            System.out.println("User " + (i + 1) + " = ID: " + users[i].getId() + ", Name: " + users[i].getName());
        }
    }
    
}
