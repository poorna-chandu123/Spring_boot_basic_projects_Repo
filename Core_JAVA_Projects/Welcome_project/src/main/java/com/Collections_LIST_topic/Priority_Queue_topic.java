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
public class Priority_Queue_topic {
    public static void main(String[] args) {
      
        /*
            FIFO princple follow avuthundi [ HEAD & TAIL ] 
        
        priority ante only HEAD matharame priority basic lo store avuthundi migilinavi default ga set avuthai
        
        Adding ---> Offer, add  -- adding yeppudu TAIL nuode jaruguthundi
          Retrival---> peek   -- retrival lo yeppudu HEAD lo vunnade vasthundi
          removal ---> poll , remove  -- delete anedi only HEAD postion lo vunnade delete avuthundi But kavali ante particular value eisthe delete avuthundi
        */
        
        
        PriorityQueue<Integer> p = new PriorityQueue<>();
        p.add(78);
        p.offer(23);
        p.add(12);
        p.offer(34);
        p.add(4);
        
        System.out.println(p);
        
        System.out.println(p.peek());
        p.peek();
        
        p.remove(23);
        System.out.println(p);
        
        p.remove(34);
        System.out.println(p);
        p.remove(78);
         System.out.println(p);
    
}
}