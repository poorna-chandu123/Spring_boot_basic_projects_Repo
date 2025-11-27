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
public class Array_DeQue_topic {
    public static void main(String[] args) {
           
        /* ArrayDeque lo insert & delete ane dani [ HEAD & TAIL ] renditi nuod cheyacchu 
        
        ADD ---> Offer , OfferLast , OfferFirst & Add, AddLat , AddFirst
        Retrive ---> Peek , PeekLast, PeekFirst 
        Remove --- > Poll, PollLast, pollFirst & Remove , RemoveLast , RemoveFirst
        
        Echhina  order lone store avuthundi
           
        
        
        */
        ArrayDeque<Integer> d = new ArrayDeque<>();
        
        d.add(4);
        d.addFirst(3);
        d.addLast(5);
        d.offer(6);
        d.offerFirst(8);
        d.add(66);
        System.out.println(d);
        
        System.out.println(d.peekFirst());
        
        d.removeFirst();
        d.removeLast();
        d.remove(66);
        System.out.println(d);
        
    }
    
}
