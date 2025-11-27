/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Inner_Class_topic;

/**
 *
 * @author annapureddy.chandu
 */
public class Basic_Information_InnerClass {

    static void chandu() {

        if (5 < 8) {

            final class ki {

                int l;

                { // Initializer block
                    l = 10;
                    System.out.println(l);
                }
            }

        } else {
            System.out.println("worng ...... method");
        }
    }

    public static void main(String[] args) {

        g k1 = new Basic_Information_InnerClass.g();

        System.out.println("main class");

        k1.pit();

        chandu();

    }

    public static class g {

        int a = 40;

        void pit() {
            System.out.println(a);
        }

    }

}
