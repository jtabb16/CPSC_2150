package cpsc2150.labs.lab1;

import java.util.*;
/**
 * Created by sangrak on 1/22/2018.
 *
 * Sangram Kadam (sangrak)
 * Jack Tabb (jbtabb) [partner on this lab]
 * CPSC 2150
 * Kevin Plis
 * Section 3
 * 1/22/2018
 * Lab 1
 *
 * Purpose: Create a user-defined matrix and perform operations on it.
 */

public class MatrixApp {

    public static void main (String [] args) {
        //Minimum and maximum dimensions for the matrix:
        final int MIN_ROWS = 1;
        final int MAX_ROWS = 10;
        final int MIN_COLUMNS = 1;
        final int MAX_COLUMNS = 10;

        int check = 0; //The number the user inputs before being checked if it is in our bounds.
        int rows = 0; //User-defined number of rows in matrix
        int columns = 0; //User-defined number of columns in matrix
        int[][] matrixArray; //The matrix

        //Get number of rows for matrix:
        do {
            System.out.println("How many rows should your matrix have?");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine(); //Get user input

            if (!input.isEmpty()) {
                check = Integer.parseInt(input); //Change user input into an integer.
            }

            if(input.isEmpty() || (check < MIN_ROWS) || (check > MAX_ROWS)){
                System.out.println("Error: Please enter a number 1-10");
            }
            else {
                rows = Integer.parseInt(input);
            }
        }
        while((check < MIN_ROWS) || (check > MAX_ROWS));

        //Get number of columns for matrix:
        check = 0; //Reset check for our tests
        do {
            System.out.println("How many columns should your matrix have?");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            if (!input.isEmpty()) {
                check = Integer.parseInt(input);
            }

            if(input.isEmpty() || (check < MIN_COLUMNS) || (check > MAX_COLUMNS)){
                System.out.println("Error: Please enter a number 1-10");
            }
            else {
                columns = Integer.parseInt(input);
            }
        }
        while((check < MIN_COLUMNS) || (check > MAX_COLUMNS));

        //Now that we have the dimensions for the matrix, let's make it.
        matrixArray = new int[rows][columns];

        //Fill the matrix with user input:
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                System.out.println("What number should go in Row: " + i + " Col: " + j);
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();

                if (!input.isEmpty()) {
                    matrixArray[i][j] = Integer.parseInt(input);
                }
                else
                {
                    j--; //Keep asking until we get a number
                    System.out.println("Error: Please enter a number");
                }
            }
        }

        //Print the user-defined matrix:
        System.out.println("Your matrix is: ");
        System.out.println( printMatrix(matrixArray) );

        //Perform operations on the matrix and print it after each operation:
        System.out.println("The transposed matrix is: ");
        System.out.println( printMatrix(transpose(matrixArray)) );

        System.out.println("The product sum is: ");
        System.out.println(product(matrixArray));

        System.out.println("The average is: ");
        System.out.println(average(matrixArray));

        System.out.println("The sums of each Row are: ");
        System.out.println( printArray(sumRow(matrixArray)) );

        System.out.println("The sums of each Column are: ");
        System.out.println( printArray(sumColumn(matrixArray)) );
    }

    /*A function that takes in a matrix and returns the transpose of the matrix.*/
    private static int[][] transpose(int[][] matrix){
        //Make a matrix whose number cols = original matrix's number rows and whose number rows = original matrix's number cols.
        int[][] transMatrix = new int [matrix[0].length][matrix.length];

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                transMatrix[j][i] = matrix[i][j];
            }
        }

        return transMatrix;
    }

    /* A function that solves for the product of the sums of each row, i.e. sum all the numbers in
        row 1 and multiply it by the sum of the numbers in row 2 and so on. */
    private static int product(int[][] matrix){
        int product = 1;
        int sum = 0;

        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                sum = sum + matrix[i][j];
            }
            product = product * sum;
            sum = 0;
        }

        return product;
    }

    /*  A function that finds the average of all of the numbers in the matrix */
    private static double average(int[][] matrix){
        int sum = 0;
        double average = 0;
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                sum = sum + matrix[i][j];
            }
        }

        average = (double)sum / (matrix.length * matrix[0].length);

        return average;
    }

    /*  A function that returns an array arr, where arr[i] is equal to the sum of all the numbers in
        the ith column in the matrix. */
    private static int [] sumColumn(int[][] matrix){
        int sum = 0;

        int[] columnSum = new int[matrix[0].length];

        for(int j = 0; j < matrix[0].length; j++) {
            for (int i = 0; i < matrix.length; i++) {
                sum = sum + matrix[i][j];
            }
        columnSum[j]= sum;
        sum = 0;
        }

        return  columnSum;
    }

    /*  A function that returns an array arr, where arr[i] is equal to the sum of all the numbers in
        the ith row in the matrix. */
    private static int [] sumRow(int[][] matrix){
        int sum = 0;
        int[] rowSum = new int[matrix.length];

        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                sum = sum + matrix[i][j];
            }
        rowSum[i] = sum;
        sum = 0;
        }

        return rowSum;
    }

    /* Helper function to print any 2-D array (matrix) */
    private static String printMatrix(int matrix[][]){
        String matrixString = "";
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrixString += ("|" + matrix[i][j]);
            }
        matrixString += ("|\n");
        }

        return matrixString;
    }

    /* Helper function to print any 1-D array */
    private static String printArray(int array[]){
        String arrayString = "";
        for(int i = 0; i < array.length; i++) {
            arrayString += ("|" + array[i]);
        }
        arrayString += ("|");

        return arrayString;
    }
}