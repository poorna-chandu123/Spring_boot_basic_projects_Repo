/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.FilesConcept_topic;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author annapureddy.chandu
 */
public class Print_Writer {
    public static void main(String[] args) throws IOException {
         File fi = new File("D:\\Resumes\\sample.txt");
         
            FileWriter  fw = new FileWriter(fi);
            
            PrintWriter pw = new PrintWriter(fw);
            
            pw.write("chandu@123gmail.com");
            pw.flush();
            pw.close();
    }
    
}
