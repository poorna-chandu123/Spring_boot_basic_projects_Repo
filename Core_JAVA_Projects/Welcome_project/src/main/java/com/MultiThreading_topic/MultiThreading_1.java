/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MultiThreading_topic;

/**
 *
 * @author annapureddy.chandu
 */
public class MultiThreading_1 {

    public static void main(String[] args) {
        MultiThreading_1 mu = new MultiThreading_1();
        mu.e.start();
        mu.m.start();

    }

    emp e = new emp();

    Maneger m = new Maneger();

    public class emp extends Thread {  // Thread ni extend chesam kanuka THREAD ki object create cheyanavasaram ledu

        @Override
        public void run() {

            System.out.println("emp class edi");

        }

    }

    public class Maneger extends Thread {

        @Override  // Thread loni run method ni override chesi manaki nacchinadi rasukunnam
        public void run() {
            System.out.println("edi maneger code");
        }
    }
}
