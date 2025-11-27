/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Streams_API;


import java.util.function.BiPredicate;
import java.util.function.Predicate;

/**
 *
 * @author poorna chandu
 */
public class StreamExp {

    private String name;
    private String add;
    private int salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public StreamExp(String name, String add, int salary) {
        this.name = name;
        this.add = add;
        this.salary = salary;
    }

    public StreamExp() {
    }

    @Override
    public String toString() {
        return "StreamExp{" + "name=" + name + ", add=" + add + ", salary=" + salary + '}';
    }
    
}