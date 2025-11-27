/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Streams_API;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

/**
 *
 * @author annapureddy.chandu
 */
public class Predicate_Funtion_Demo_2 {
    
    int stuNo;
    String StuName;
    int stufees;

    public int getStuNo() {
        return stuNo;
    }

    public String getStuName() {
        return StuName;
    }

    public int getStufees() {
        return stufees;
    }

    public void setStuNo(int stuNo) {
        this.stuNo = stuNo;
    }

    public void setStuName(String StuName) {
        this.StuName = StuName;
    }

    public void setStufees(int stufees) {
        this.stufees = stufees;
    }

    public Predicate_Funtion_Demo_2() {
    }

    public Predicate_Funtion_Demo_2(int stuNo, String StuName, int stufees) {
        this.stuNo = stuNo;
        this.StuName = StuName;
        this.stufees = stufees;
    }

    @Override
    public String toString() {
        return "{" + "StudentNO=" + stuNo + ", StudentName=" + StuName + ", studentFees=" + stufees + '}';
    }
    
    
    
    public static void main(String[] args) {
         List<Predicate_Funtion_Demo_2> L = new ArrayList<>();
    
   L.add(new Predicate_Funtion_Demo_2(1, "kiran", 5000));  
   
    L.add(new Predicate_Funtion_Demo_2(2, "raju", 3000)); 
     L.add(new Predicate_Funtion_Demo_2(3, "vinod", 6745));
     
     L.add(new Predicate_Funtion_Demo_2(4, "vinod", 8845));
     L.add(new Predicate_Funtion_Demo_2(5, "vinod", 1000));
     
     Predicate<Predicate_Funtion_Demo_2> p = x -> x.getStufees()<6000;
     
     Predicate<Predicate_Funtion_Demo_2> p1 = v -> v.getStufees()%2==0;
     
      for (Predicate_Funtion_Demo_2 l : L) {
            // Use .and() to combine predicates and apply it to the object `l`
            if (p.and(p1).test(l)) {
                System.out.println(l);  // Print if both conditions are true
            }
        }
      
        System.out.println("==================================================");
        
        
        
        List<Integer> i = new ArrayList<>();
        i.add(2); i.add(3); i.add(4); i.add(5); i.add(6);
        
        // BiPredicate that checks if two numbers are equal
        BiPredicate<Integer, Integer> k = (x, y) -> x.equals(y);

        // Example usage of BiPredicate
        for (Integer num : i) {
            if (k.test(num, 4)) {  // Check if the number equals 4
                System.out.println(num + " is equal to 4");
            }
        }
    }
   
    
}
