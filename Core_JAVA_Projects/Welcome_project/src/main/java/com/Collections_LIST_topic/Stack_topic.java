/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Collections_LIST_topic;

import java.util.*;
/**
 *
 * @author annapureddy.chandu
 */
public class Stack_topic {
    
    public static void main(String[] args) {
        
        Stack<String> s = new Stack();
        
        s.add("chandu");
        s.add(1, "kiran");
        System.out.println(s);
        
        /*
        * LIFO - Last in First out -> stack
        *FIFO - First in Fist out  --> Queue
        
          Stack main methods 
          * push
          * pop
          *peek
          *search
          * empty  --> same as isEmpty method in VECTOR
*/

       Stack<Integer>b = new Stack();
       
       b.push(8);
       b.push(22);
       b.push(126);
       System.out.println(b.search(126));
        System.out.println(b);
        System.out.println(b.peek());
        b.pop();// pop chesthe last ga vunna eliment delete avuthundi
        System.out.println(b);
        System.out.println(s.empty()); // edi vector loni isEmpty rendu same 
        
        
        
    }
    
}
