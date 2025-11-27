/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Collections_LIST_topic;

import java.util.HashSet;

/**
 *
 * @author annapureddy.chandu
 */
public class Hashset_topic {
    
    public static void main(String[] args) {
		
		HashSet h=new HashSet();
		h.add(100);
		h.add("class");
		h.add(10.25);
		h.add("class");
		h.add(250.50f);
		h.add("class"); // edi duplicates ni allow cheyadu ala ani ERROR kani EXCEPTION anevi ravu just avi override avuthavi
		                 // echhina data anedi echhina order lone radu
		System.out.println(h);
		
	}
    
}
