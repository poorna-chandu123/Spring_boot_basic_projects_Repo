/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Collections_LIST_topic;

import java.util.*;
import java.util.Queue;

/**
 *
 * @author annapureddy.chandu
 */
public class Linked_list_for_Queue_topic {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        
        q.add(2);
        q.offer(4);
      
        q.peek();
        System.out.println(q); // Same LIST loni Linked list laganee..vuntadi danithe patu QUEUE loni methods kuda use chesukovachhu
        q.poll();
        System.out.println(q);
    }
    
}
