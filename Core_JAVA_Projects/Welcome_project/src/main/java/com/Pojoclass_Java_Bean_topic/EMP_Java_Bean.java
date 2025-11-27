/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Pojoclass_Java_Bean_topic;

import java.io.Serializable;

/**
 *
 * @author annapureddy.chandu
 */
public class EMP_Java_Bean implements Serializable{  // Eikkada implements Serializable ani rasam kanuka edi JAVA Bean Class
    private int id;
    
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
