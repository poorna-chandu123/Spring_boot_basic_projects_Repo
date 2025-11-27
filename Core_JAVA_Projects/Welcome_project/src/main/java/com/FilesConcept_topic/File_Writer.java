/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.FilesConcept_topic;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author annapureddy.chandu
 */
public class File_Writer {
    
    public static void main(String[] args) throws IOException {
         File fi = new File("D:\\Resumes\\sample.txt");
        if(fi.exists()){
            fi.delete();
        }else{
            fi.createNewFile();
        }
        String s="Hello"; // oka sting value ni write cheyali ante daniki loop ni Run cheyali Because edi okko charecter ni write chesthundi
         FileWriter  fw = new FileWriter(fi);
        
       
            fw.write(s.toCharArray());  // direct ga string Array ni write cheyachhu
        
        fw.write("\n");
        fw.write(72);
        fw.write(69);
        fw.write('c');
         fw.write("\n");
        fw.write("82");
        fw.flush();
        fw.close();
    }
    
    }
    

