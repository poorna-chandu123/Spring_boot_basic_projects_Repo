/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.FilesConcept_topic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author annapureddy.chandu
 */
public class Sccaner_class {
    public static void main(String[] args) throws IOException {
         File fil = new File("D:\\Resumes\\sample.txt"); 
        String data ="";
         Scanner sd = new Scanner(fil);
       while (sd.hasNextLine()){
           
            data += sd.nextLine();  // data ni oka string lo store cheyataniki
           //System.out.println(sd.nextLine());
       }
       
       
        System.out.println("+===========================");
        
        System.out.println(data+ "\n");
        sd.close();
    }
    
}
