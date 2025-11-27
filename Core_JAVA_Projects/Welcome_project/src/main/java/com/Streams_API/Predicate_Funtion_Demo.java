/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Streams_API;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 *
 * @author annapureddy.chandu
 */
public class Predicate_Funtion_Demo {
    
    int empid;
    String Empname;
    int empsal;

    public Predicate_Funtion_Demo() {
    }

    public Predicate_Funtion_Demo(int empid, String Empname, int empsal) {
        this.empid = empid;
        this.Empname = Empname;
        this.empsal = empsal;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public void setEmpname(String Empname) {
        this.Empname = Empname;
    }

    public void setEmpsal(int empsal) {
        this.empsal = empsal;
    }

    public int getEmpid() {
        return empid;
    }

    public String getEmpname() {
        return Empname;
    }

    public int getEmpsal() {
        return empsal;
    }

    @Override
    public String toString() {
       return '{'+ "empid=" + empid + ", Empname=" + Empname + ", empsal=" + empsal +'}';
   }

   
    
    
    public static void main(String[] args) {
        
       List<Predicate_Funtion_Demo> f = new ArrayList<>();
       
       f.add(new Predicate_Funtion_Demo(1,"sinu",5000));
       
        f.add(new Predicate_Funtion_Demo(2,"navin",2000));
        
         f.add(new Predicate_Funtion_Demo(3,"kiran",4000));
         
         Predicate<Integer> p = (x)-> x>3000;
         
        
         
        
        for (Predicate_Funtion_Demo emp : f) {
            if (p.test(emp.getEmpsal())) {
                System.out.println(emp);
            }
           
         
       
    }
           System.out.println("================================================");
        
           List<Integer> l = new ArrayList<>();
            
            l.add(2);
            l.add(3);
            l.add(2);
            l.add(5);
            l.add(4);
            
            Predicate<Integer> p1 = x -> x>3;
           for (Integer i : l){
              if(p1.test(i))
               System.out.println(i);
           }
           
              System.out.println("================================================");
           
  // Step 2: Define a Function to update the empname
        Function<Predicate_Funtion_Demo, Predicate_Funtion_Demo> g = (s) -> {
            s.setEmpname(s.getEmpname().concat("_newEMP"));
            return s;
        };

     
        // Step 3: Iterate over the list of Funtional_Interface objects and apply the function
        for (Predicate_Funtion_Demo v : f) {
            g.apply(v);  // Apply the function to modify the empname
            System.out.println(v.getEmpname());  // Print the updated object only EMP Name 
            
            // System.out.println(v); // Print the updated entire list 
        }
}
}
