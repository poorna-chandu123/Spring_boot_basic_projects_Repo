/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.welcome.welcome_project;

/**
 *
 * @author annapureddy.chandu
 */
public class For_each {
    public static void main(String[] args) {
        int arr[] ={1,2,3,4,5};
        for (int i:arr ){  // edi default ga iniliztion chesukoni defult ga increment avuthundi kanuka int i=0; ani evvaka poeina yem kadu
            System.out.println(""+i);
        }
        System.out.println("================");
        for(int i=0;i<arr.length; i+=2){ //eila increment anedi for-each loop lo cheyalemu only for loop lonee.
            System.out.println(""+i);
        }
         System.out.println("================");
        int s[][]={{1,2,3},{4,5,6},{7,8,9} };
           
        int sum=0;
        int nofEliments=0;
        for (int[]twoDimArray:s){
            for( int value:twoDimArray){
                System.out.print(""+value);
                sum+=value;
                nofEliments++;
                 
            }
            System.out.println("  ");
        }
         System.out.println(" ======");
       
         System.out.println("No.of eliments"+nofEliments);
         System.out.println("total sum"+sum);
          System.out.println(""+sum/nofEliments);
          
          //==========================================
           System.out.println(" ======");
             int jaggedArray [][]={{1,2,3},{4},{8,9} };
           
    
        for (int[]S:jaggedArray){
            for( int value:S){
                System.out.print(""+value);
               
                 
            }
            System.out.println("  ");
        }
          
          
    }
}
