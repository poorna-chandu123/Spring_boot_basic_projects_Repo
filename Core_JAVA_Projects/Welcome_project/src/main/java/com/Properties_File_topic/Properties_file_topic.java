/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Properties_File_topic;

import java.io.File;
import java.io.*;

import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

/**
 *
 * @author annapureddy.chandu
 */
public class Properties_file_topic {

    public static void main(String[] args) throws IOException {

        File file = new File("BDconfig.properties");
        if (!file.exists()) {
            file.createNewFile();
        }
        Properties p = new Properties();
        p.setProperty("URL", "10.203.81.206");
        p.setProperty("psw", "chandu123");

        FileWriter fw = new FileWriter(file);
        p.store(fw, "file storecheyataniki use avuthundi");

        FileReader fr = new FileReader(file);
        p.load(fr);

        // only keys retrive cheyataniki
        Set<String> key = p.stringPropertyNames();
        System.out.println(key);
        // 2nd Method
        Set<Object> key1 = p.keySet();  // p.keys(); --> edi Enumarator ni return chesthundi dini gunchi next topic lo vuntadi
        System.out.println(key1);

        // values return chesukovataniki
        Collection<Object> value = p.values();
        System.out.println(value);

        // key echhi value thechhukovatam
        System.out.println(p.getProperty("URL"));
        System.out.println(p.getProperty("userName", "defalut value print avuthundi key lekunte"));

        // LOOp run chesi key values ni thechhukovatam
        for (Object keys : p.keySet()) { // total keys ni itarate chesthunnam e line code lo
            System.out.println(keys + "--->" + p.getProperty((String) keys));
        }
        System.out.println("===================================");
        // 2nd Modal
        Set<Entry<Object, Object>> data = p.entrySet();  // Every entry is a pair of(KEY , VALUE) pair
        for (Entry<Object, Object> entry : data) {
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }

//  NOTE:- update , remanig MAP lo vunna anni methods diniki vadachhu.....
    }

}
