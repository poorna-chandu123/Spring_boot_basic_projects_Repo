/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Collections_LIST_topic;

import java.util.LinkedHashMap;

/**
 *
 * @author annapureddy.chandu
 */
public class Linked_Hashmap {
    public static void main(String[] args) {
		LinkedHashMap h=new LinkedHashMap();
		h.put(101,"Ravi");
		h.put(102,"Rajesh");
		h.put(103,"Kiran");
		h.put(101,"naresh");
		h.put("Ramu",101);
		h.put("Kalyan",201); // echhina order lone vasthaei
		h.put("seth",301);
		System.out.println(h);
	}
    
}
