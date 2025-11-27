package com.welcome.welcome_project;

public class Array {

    public static void main(String[] args) {
        int[] a = new int[3];
        a[0] = 1;
        a[1] = 2;
        a[2] = 3;

        // Using for loop to print the array elements and calculate the sum
        int sum = 0;
        int loopCount = 0;

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
            sum += a[i];
          //  sum = sum+a[i]; eila kuda rayachhu
            loopCount++;
        }

        // Print statement outside the loop
        System.out.println("Array sum: " + sum);
        System.out.println("Loop ran " + loopCount + " times");

        // How may types to write & Insilize "Single dimenstional Array"
        int[] array1 = new int[5];  // Creates an array of size 5 with default values (0 for int).

        int[] array2 = {1, 2, 3, 4, 5};  // Initializes an array with specific values.

        int[] array3;
        array3 = new int[]{1, 2, 3, 4, 5};  // Declares and then initializes the array.

        int[] array4 = new int[]{1, 2, 3, 4, 5};  // Specifies values and lets Java determine the size.

        int[] array5 = {1, 2, 3, 4, 5};  // Shortened syntax when both declaring and initializing.

//=============================================================================================================
        //TWO dimenstional Array
        int[][] z = new int[3][4];  // Creates a 3x4 array with default values (0 for int).

        int[][] x = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};  // Initializes a 3x3 array with specific values.

        int[][] c;
        c = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};  // Declares and then initializes the array.

        int[][] v = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};  // Specifies values and lets Java determine the size.

        int[][] b = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};  // Shortened syntax when both declaring and initializing.

        
     // ===================================================================================================================   
        
        // Jagged Array
        int[][] jaggedArray1 = {{1, 2, 3}, {4, 5}, {6, 7, 8, 9}};  // Initializes a jagged array with specific values.

        int[][] jaggedArray2;
        jaggedArray2 = new int[][]{{1, 2, 3}, {4, 5}, {6, 7, 8, 9}};  // Declares and then initializes the jagged array.

        int[][] jaggedArray3 = new int[][]{{1, 2, 3}, {4, 5}, {6, 7, 8, 9}};  // Specifies values and lets Java determine the size.

        int[][] jaggedArray4 = {{1, 2, 3}, {4, 5}, {6, 7, 8, 9}};  // Shortened syntax when both declaring and initializing.

// Using different lengths in each row:
        int[][] jaggedArray5 = new int[3][];
        jaggedArray5[0] = new int[]{1, 2, 3};
        jaggedArray5[1] = new int[]{4, 5};
        jaggedArray5[2] = new int[]{6, 7, 8, 9};
        
       // int [][] jaggedArray6 = new int [][2]; // eila rayalemu rows anevi mundugane diclier cheyali
        

    }

    public static int asList(Object[] arr1) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}


