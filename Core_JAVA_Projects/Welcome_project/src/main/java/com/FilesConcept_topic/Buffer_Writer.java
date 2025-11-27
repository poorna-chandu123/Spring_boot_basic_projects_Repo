package com.FilesConcept_topic;

import java.io.*;

/**
 *
 * author annapureddy.chandu
 */
public class Buffer_Writer {

    public static void main(String[] args) throws IOException {
        File fi = new File("D:\\Files\\resume\\sample.txt");
        /*      if (fi.exists()) {
            fi.delete();             // update code kosam comment chesanu
        } else {
            fi.createNewFile();
        }
         */

        FileReader fr = new FileReader(fi);
        BufferedReader br = new BufferedReader(fr);

        String line = new String();
        String sd = "";

        while ((sd = br.readLine()) != null) {
            line += sd + "\n";
        }

        String c = " kiran";

        FileWriter fw = new FileWriter(fi);

    //   String name = "poorna"; // first text // update code kosam comment chesanu
    //    String v = "chandu"; // second text// update code kosam comment chesanu

        BufferedWriter b = new BufferedWriter(fw);

      //  b.write("Name"); // direct ga rayachhu  // update code kosam comment chesanu
      //    b.write(name + v); // update code kosam comment chesanu

        b.write(line + c);

        System.out.println(line);

        b.close();

    }
}

/*
same all ready rasina code lo new text ni update la rayali anukunte old text Read chesi danni new text ki kalapali
*/