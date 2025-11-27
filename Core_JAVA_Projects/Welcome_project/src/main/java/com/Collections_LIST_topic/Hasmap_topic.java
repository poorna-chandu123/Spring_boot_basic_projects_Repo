/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Collections_LIST_topic;

import java.util.HashMap;

/**
 *
 * @author annapureddy.chandu
 */
public class Hasmap_topic {
    public static void main(String[] args) {
		
		HashMap h1=new HashMap();
		h1.put(101,"Ravi");
		h1.put(102,"Rajesh");
		h1.put(103,"Kiran");
		h1.put(101,"naresh");
		h1.put("Ramu",101);
		h1.put("Kalyan",201); //  echhina order lone values ravu
		h1.put("seth",301);
		System.out.println(h1);  
		
		//--------------------------------------------------------------------------------
		
		
		
		HashMap h=new HashMap();
		Integer i1=new Integer(10); //hash map anedi objects ni thisukodu adi eila wraper class ne thisukuntadi 
		
		Integer i2=new Integer(11);      //
		
		
		
		
		h.put(i1, "pavan");
		h.put(i2, "vijay");
		
		System.out.println(h);

	}
    
}
