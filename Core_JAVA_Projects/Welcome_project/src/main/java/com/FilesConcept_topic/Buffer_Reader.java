package com.FilesConcept_topic;

import java.io.BufferedReader; // Fix typo here
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author annapureddy.chandu
 */
public class Buffer_Reader {
    public static void main(String[] args) throws IOException {
        
        System.out.println("charecter by charecter code");
        File fi = new File("D:\\Resumes\\sample.txt");
        
        FileReader fils = new FileReader(fi);
        
        BufferedReader br = new BufferedReader(fils); // Fix typo here
        
  /*      int a;
        String data = "";
        while ((a = br.read()) != -1) {
            data += String.valueOf((char) a); // text data ni oka string lo store cheyataniki use chestamu
            System.out.print((char) a);
        }
        
        System.out.println("+++++++++++++++++++++");
        System.out.println(data);
        
        
        */
        
        System.out.println("line by line code");
        
        String data2 ="";
        String s = new String();
        
        while ((data2 = br.readLine()) !=null){
            
         s +=data2+"\n";
            
        }
        
        System.out.println(s);
        br.close();
        fils.close();
    }
}
