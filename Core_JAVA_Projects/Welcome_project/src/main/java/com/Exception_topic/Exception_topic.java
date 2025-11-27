/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Exception_topic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author annapureddy.chandu
 */
public class Exception_topic {

    public static void main(String[] args) throws Exception_topic2 {

        File fi = new File("D:\\Files\\resume.txt");

        //   @Auto close concept ki
        // Try with resources :-   
        try (FileReader fils = new FileReader(fi);
       BufferedReader br = new BufferedReader(fils);) {

            int a;
            String data = "";
            while ((a = br.read()) != -1) {
                data += String.valueOf((char) a); // text data ni oka string lo store cheyataniki use chestamu
                System.out.print((char) a);
                
                data += String.valueOf(a);

            }

        } catch (Exception e) {
            e.printStackTrace();

        }

        System.out.println("\n===================================================");
        try {
            int c = 2 / 0;
        } catch (ArithmeticException e) {

            // System.exit(0);  // Exception ki related ye msg lu ravu Red colour lo AND Next code run Avvadu
           // throw new Exception_topic2(" vere class dwara user difined(Arthemtic place lo mana class name tho EXception create Avuthundi) expection send cheyatam");
            throw e;  // Exception details print avvi a next yemi Ravu
        }
        System.out.println("next line");
    }

}
