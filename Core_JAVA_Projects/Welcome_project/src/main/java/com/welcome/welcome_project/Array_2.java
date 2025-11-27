/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.welcome.welcome_project;

/**
 *
 * @author annapureddy.chandu
 */
public class Array_2 {
    public static void main(String[] args) {
        int arr[][] = {{3,2},{2,1}};
        System.out.println(""+arr[0][0]);
        System.out.println(""+arr[0][1]);
                System.out.println(""+arr[1][0]);
                        System.out.println(""+arr[1][1]);
                        
                      
                        
     //=============================================
     int[][] arrry =new int[3][2];
     arrry [0]=new int[]{1,2};  // eila kuda values petachhu
     
     arrry[1][0]=3;
     arrry[1][1]=4;
     
     arrry[2][0]=5;
     arrry[2][1]=6;
     
     for (int i = 0; i < arrry.length; i++) {
    for (int j = 0; j < arrry[i].length; j++) {
        System.out.print(arrry[i][j] +" "); // matrix type lo ravatniki print ni vadali
    }
    System.out.println();
     
     
    }
     
     
       System.out.println();
         System.out.println();
     //============================
     
     int s[][] =new int[3][];
     
     s[0] = new int []{1,2};
     s[1] =new int [3];  // eila munduga yenni values vundali ani difine chesi next values asingment cheyachhu kinda chesinattu
     s[2] = new int [2];
     
     s[1][0] =11;
     s[1][1]=12;
     s[1][2]=13;
     
     s[2][0]= 14;
     s[2][1] =15;
     
     
      for (int m = 0; m < s.length; m++) {
    for (int n = 0; n < s[m].length; n++) {
        System.out.print(s[m][n] +" ");
    }
    System.out.println();
     
     
    } 
     
}
}

