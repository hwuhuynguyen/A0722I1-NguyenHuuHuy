package _03_Array_and_Method_in_Java.Exercise;

import java.util.Scanner;

public class FindMaxElementIn2DArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter number of rows: ");
        int row = scanner.nextInt();
        System.out.printf("Enter number of columns: ");
        int column = scanner.nextInt();

        int[][] array = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.printf("Element [" + i + "][" + j + "] is: ");
                array[i][j] = scanner.nextInt();
            }
        }
        int min = array[0][0];

        System.out.println("Matrix: ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(array[i][j] + " ");
                if (min > array[i][j]) min = array[i][j];
            }
            System.out.println();
        }
        System.out.println("Min value of this matrix is: " + min);
    }
}
