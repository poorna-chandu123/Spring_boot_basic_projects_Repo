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
public class Vector_topic {

    public static void main(String[] args) {
        Vector v1 = new Vector();

        v1.add(1);
        v1.add(3);
        v1.add(5);
        v1.add(null);
        System.out.println(v1);

        v1.set(2, 7);
        System.out.println(v1);

        Vector v2 = new Vector();

        v2.add(4);
        v2.add("kiran");
        System.out.println(v2);

        v1.addAll(v2);
        v1.add(1, "vasu");
        System.out.println(v1);
        v1.addElement(4);

        System.out.println(v1);

        v1.removeAll(v2);
        System.out.println(v1);

        v1.removeElementAt(0);
        System.out.println(v1);

        System.out.println(v1.addAll(v2));

        System.out.println(v1);

        System.out.println(v1.size());
        System.out.println(v1.capacity());
        System.out.println(v1.firstElement());

        System.out.println(v1.isEmpty());

        System.out.println(v1.indexOf(3));
        System.out.println(v1.indexOf(3, 3));

        Object[] arr = v1.toArray(); // vector ni array lo convert chesthundi
        System.out.println(Arrays.toString(arr));

        v1.clear();
        System.out.println(v1);

        System.out.println("=============================");

        Object[] arr1 = new Object[]{0, 0, 0, 0}; //array ni vector lo convert chesthundi
        Vector v3 = new Vector(Arrays.asList(arr1));

        System.out.println(v3);
        System.out.println(v3.size());
        System.out.println("capacity="+v3.capacity());

        System.out.println("============================");

        // Genarics concept java 1.5 verstion 
        // vector concept java 1.0 verstion
        // Collections fremwork 1.2 verstion 
        Vector<Integer> v4 = new Vector<Integer>();

        v4.add(11);
        v4.add(null); // NULL ni thisukuntadi
        //  v4.add("chandu");  // compile time Error vasthundi because <Integer> Ani genarics topic vadam kanuka

        v4.add(1,  (8));
        
        System.out.println(v4);
        
        // so <Integer> ani eisthe einka andulo only Int values ne vunchagalam
        
       // Wraper class evvatani ki reason, Ever collection is a combination of object. primitive data types(int,char...)
        // ki object anedi vundadu kanuka 
    }
}
