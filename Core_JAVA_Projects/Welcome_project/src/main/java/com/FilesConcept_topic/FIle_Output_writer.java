/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.FilesConcept_topic;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author annapureddy.chandu
 */
public class FIle_Output_writer {
    public static void main(String[] args)throws IOException {
        File fi = new File("D:\\Resumes\\sample.txt");
        if(fi.exists()){
            fi.delete();
        }else{
            fi.createNewFile();
        }
        String s="Hello"; // oka sting value ni write cheyali ante daniki loop ni Run cheyali Because edi okko charecter ni write chesthundi
        FileOutputStream fo = new FileOutputStream(fi);
        
        for(char c: s.toCharArray()){
            fo.write((int)c);
        }
    fo.write("\n".getBytes());
        fo.write(72);
        fo.write(69);
      
        fo.flush();
        fo.close();
    }
    
}
