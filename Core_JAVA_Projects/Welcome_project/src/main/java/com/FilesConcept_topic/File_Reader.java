/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.FilesConcept_topic;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author annapureddy.chandu
 */
public class File_Reader {
    public static void main(String[] args) throws IOException{
         File fi = new File("D:\\Resumes\\sample.txt"); 
        FileReader filereder = new FileReader(fi);
        
         int a;
        String  data ="";
        while ((a=filereder.read()) !=-1){
            
            data += String.valueOf((char)a);// text data ni oka string lo store cheyataniki use chestamu
            System.out.print((char)a);
            
        }
        
        System.out.println("+++++++++++++++++++++");
        System.out.println(data);
        
        filereder.close();
      
    }
    }
    

