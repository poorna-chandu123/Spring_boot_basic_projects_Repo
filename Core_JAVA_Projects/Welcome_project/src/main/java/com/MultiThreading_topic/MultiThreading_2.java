/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MultiThreading_topic;

/**
 *
 * @author annapureddy.chandu
 */
public class MultiThreading_2 {

    public static void main(String[] args) {
        MultiThreading_2 m2 = new MultiThreading_2();


        m2.t1.start();
        m2.t2.start();
        

    }

    
        emp e = new emp();
    Thread t1 = new Thread(e); // Runnable ane interface thisukunnam andulo RUN() vundi kani Start(); ledu
                                    // andukani Thread ki object create cheyali 
    Maneger m = new Maneger();

    Thread t2 = new Thread(m);

    public class emp implements Runnable {

        @Override
        public void run() {

            System.out.println("emp class edi");

        }

    }

    public class Maneger implements Runnable {

        @Override  // Runnable loni run method ni override chesi manaki nacchinadi rasukunnam
        public void run() {
            System.out.println("edi maneger code");
        }
    }

}
