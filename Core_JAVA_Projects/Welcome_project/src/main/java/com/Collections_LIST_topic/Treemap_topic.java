/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Collections_LIST_topic;

import java.util.TreeMap;

/**
 *
 * @author annapureddy.chandu
 */
public class Treemap_topic {
    
    public static void main(String[] args) {
		
		TreeMap t=new TreeMap();
		t.put(101,"Raju");
		t.put(103, 500);
		 t.put("130", 700); //exception vasthundi
		
		t.put(01,"");
		System.out.println(t);
	}

    
}
