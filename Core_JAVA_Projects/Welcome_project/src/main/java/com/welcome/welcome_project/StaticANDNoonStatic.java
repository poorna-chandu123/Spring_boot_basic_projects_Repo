/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.welcome.welcome_project;

import java.util.Random;

/**
 *
 * @author annapureddy.chandu
 */
public class StaticANDNoonStatic {

    /*
    Static variable : static variable anedi class level variable avuthundi.
    static variable memory lo oka sari allocate avuthundi and a memory ni anni objects share chesthayi.
    static variable ni access cheyadaniki object create cheyadaniki avasaram ledu.
    static variable ni class name tho access chestham.
    Non static variable : non static variable anedi instance variable avuthundi.
    non static variable memory lo prati object ki okati allocate avuthundi.
    non static variable ni access cheyadaniki object create cheyali.

     */

    int number;  // instance variable 
    static int number2; // static variable

    public static void main(String[] args) {
        StaticANDNoonStatic t1 = new StaticANDNoonStatic();
        t1.number = new Random().nextInt();  // oka Random number print avvataniki rasamu

        StaticANDNoonStatic t2 = new StaticANDNoonStatic();
        t2.number = new Random().nextInt();

        StaticANDNoonStatic t3 = new StaticANDNoonStatic();
        t3.number = new Random().nextInt();

        System.out.println("" + t1.number);
        System.out.println("" + t2.number);
        System.out.println("" + t3.number);

        System.out.println("=====================");

        // ede code number static chesi chesthe same nuber anniti ki vasthundi becasuse mommery anedi share avuthundi
        StaticANDNoonStatic.number2 = new Random().nextInt();
        StaticANDNoonStatic.number2 = new Random().nextInt();
        StaticANDNoonStatic.number2 = new Random().nextInt();

        System.out.println("" + StaticANDNoonStatic.number2);
        System.out.println("" + StaticANDNoonStatic.number2);
        System.out.println("" + StaticANDNoonStatic.number2);

        System.out.println("== same static yee.. object create chesi chesthe but static ki object avasaram ledu");

        StaticANDNoonStatic t4 = new StaticANDNoonStatic();
        t4.number2 = new Random().nextInt();

        StaticANDNoonStatic t5 = new StaticANDNoonStatic();
        t5.number2 = new Random().nextInt();

        StaticANDNoonStatic t6 = new StaticANDNoonStatic();
        t6.number2 = new Random().nextInt();

        System.out.println("" + t4.number2);
        System.out.println("" + t5.number2);
        System.out.println("" + t6.number2);  // ststic vatiki same number print avuthundi because memory ni annitiki share chesthundi

    }

}
