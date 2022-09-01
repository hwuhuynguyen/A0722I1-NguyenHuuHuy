package _03_Array_and_Method_in_Java.Exercise;

import java.util.Scanner;

public class SumOfElementsOnTheMainDiagonal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter number of rows and columns (rows = columns): ");
        int value = scanner.nextInt();

        int[][] array = new int[value][value];
        for (int i = 0; i < value; i++) {
            for (int j = 0; j < value; j++) {
                System.out.printf("Element [" + i + "][" + j + "] is: ");
                array[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Matrix: ");
        for (int i = 0; i < value; i++) {
            for (int j = 0; j < value; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        int sum = 0;
        for (int i = 0; i < value; i++) {
            sum += array[i][i];
        }

        System.out.println("Sum of elements on the main diagonal is: " + sum);
    }
}
