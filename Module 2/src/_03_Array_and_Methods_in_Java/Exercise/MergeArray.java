package _03_Array_and_Methods_in_Java.Exercise;

import java.util.Scanner;

public class MergeArray {
    public static void main(String[] args) {
        int[] arrA;
        int[] arrB;
        int sizeA, sizeB;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a size of array 1: ");
        sizeA = scanner.nextInt();
        arrA = new int[sizeA];
        int i = 0;
        while (i < arrA.length) {
            System.out.print("Enter element " + (i + 1) + " of array 1: ");
            arrA[i] = scanner.nextInt();
            i++;
        }
        System.out.print("Enter a size of array 2: ");
        sizeB = scanner.nextInt();
        arrB = new int[sizeB];
        i = 0;
        while (i < arrB.length) {
            System.out.print("Enter element " + (i + 1) + " of array 2: ");
            arrB[i] = scanner.nextInt();
            i++;
        }
        System.out.print("Elements in array 1: ");
        for (int j = 0; j < arrA.length; j++) {
            System.out.print(arrA[j] + " ");
        }
        System.out.println();
        System.out.print("Elements in array 2: ");
        for (int j = 0; j < arrB.length; j++) {
            System.out.print(arrB[j] + " ");
        }
        System.out.println();

        int[] arr3 = new int[arrA.length + arrB.length];
        for (int j = 0; j < arr3.length; j++) {
            if (j < arrA.length) {
                arr3[j] = arrA[j];
            } else {
                arr3[j] = arrB[j-arrA.length];
            }
        }

        System.out.printf("New array: ");
        for (int j = 0; j < arr3.length; j++) {
            System.out.printf(arr3[j] + " ");
        }
    }
}
