/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.FilesConcept_topic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author annapureddy.chandu
 */
public class  File_inputstrem {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\Resumes\\sample.txt");       
        file.createNewFile();
        
        FileInputStream fi = new FileInputStream(file);
        
        int a;
        String  data ="";
        while ((a=fi.read()) !=-1){
            
            data += String.valueOf((char)a);// text data ni oka string lo store cheyataniki use chestamu
            System.out.print((char)a);
            
        }
        
        System.out.println("+++++++++++++++++++++");
        System.out.println(data);
    }
    
}
