package _03_Array_and_Methods_in_Java.Exercise;

import java.util.Scanner;

public class DeleteElement {
    public static void main(String[] args) {
        int[] arr = {4, 12, 7, 8, 1, 6, 9};
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter a value: ");
        int input = scanner.nextInt();
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (input == arr[i]) index = i;
        }
        if (index == -1) {
            System.out.println("Not found this value in this array!");
        } else {
            for (int i = index; i < arr.length-1; i++) {
                arr[i] = arr[i+1];
            }
            System.out.printf("New array: ");
            for (int i = 0; i < arr.length-1; i++) {
                System.out.printf(arr[i] + " ");
            }
        }
    }
}
