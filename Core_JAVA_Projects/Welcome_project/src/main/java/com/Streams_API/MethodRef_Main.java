/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Streams_API;

import java.util.function.Consumer;
import java.util.function.Supplier;



/**
 *
 * @author annapureddy.chandu
 */
public class MethodRef_Main {
    public static void main(String[] args) {
        // Instance method reference
        MethodRef methodRefInstance = new MethodRef();
        Consumer<MethodRef> instanceMethodRef = MethodRef::m1;
        
        // Using method reference to call m1 (instance method)
        instanceMethodRef.accept(methodRefInstance);
        
        // Static method reference using Runnable
        Runnable staticMethodRef = MethodRef::m2;
        
        // Using method reference to call m2 (static method)
        staticMethodRef.run(); // Note: m2 returns a String, but Runnable doesn't return a value, so it won't print anything.

        // Correct use of Supplier to get the return value of m2 and print it
        Supplier<String> su = MethodRef::m2;
        System.out.println(su.get());  // Printing the return value of m2
    }
}
