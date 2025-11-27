/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Streams_API;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 *
 * @author poorna chandu
 */
public class Strem_Example {
    
    public static void main(String[] args) {
        
        List<StreamExp> l = new ArrayList<>();
        l.add(new StreamExp("ravi","123 addree",100));
         l.add(new StreamExp("kiran","456 addree",200));
         
         Predicate<StreamExp> p = (t)-> t.getSalary()>150;
         
     /*     Predicate<StreamExp> p1 = new  Predicate<StreamExp> (){
              
              @Override
            public  boolean test(StreamExp t){   // same Predicate ni anonimous class ni vadi rasthe eila vuntadi
                 return t.getSalary()>110;
              }
              
          };  */
          
          
           
         
         
 /*        Function<StreamExp,StreamExp> F = (f) ->{
             f.setSalary(f.getSalary()+50);
            return f;
             
         }; */
         
       Function<String,String> F2 = (f) ->{
             return f.toUpperCase();
             
         };
         
         
         
         
         
                 
                  // Iterate over the list and apply Predicate and Function
  /*      for (StreamExp exp : l) {
            // Check if the Predicate condition is met
            if (p.test(exp)) {
                // Apply the Function only if the condition is met
                F.apply(exp);
            }
        }
        
*/
        
        
        for(StreamExp exp1 : l){
            if (p.test(exp1)){
                
                // exp1.setName(F2.apply(exp1.getName())); // eikkada setName ni vadi UPPERCASE name ni list lo save chesthunnam
                F2.apply(exp1.getName()); // just eila rasthe UPPERCASE name list lo save avadu manma set chesthene save avuthadi
                System.out.println(exp1);  //  edi only condition true avina data ne print chesthundi
            }
        }
        
        System.out.println("================================================"); 
        
        // Print the updated list to verify changes
        for (StreamExp exp1 : l) {
            System.out.println(exp1); // edi update avina condition ni chusi total list ni update chesi print chesthundi
            
           
        }
        
                 
    }
}
