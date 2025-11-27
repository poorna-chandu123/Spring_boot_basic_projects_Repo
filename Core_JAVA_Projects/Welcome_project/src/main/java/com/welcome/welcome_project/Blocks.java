/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.welcome.welcome_project;

/**
 *
 * @author annapureddy.chandu
 */
public class Blocks {

    // static blocks
    static {
        System.err.println(" static block");
    }

    //non -static block
    {
        System.out.println("non static block");
    }

    // constuctor
    public Blocks() {
        System.out.println("constructor");  // constructer work avvali ante pakka object creation anedi cheyali
    }

    public static void main(String[] args) {
        System.out.println("main method"); // dinikanna mundu  static block print avuthundi

        new Blocks(); // just obeject create chesanu constructer anedi internal ga non static blocks ni use chesthundi ani chudataniki   
        System.out.println("========================");
        Blocks s = new Blocks();

    }

}
