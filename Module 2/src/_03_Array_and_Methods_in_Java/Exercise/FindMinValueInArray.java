package _03_Array_and_Methods_in_Java.Exercise;

import java.util.Scanner;

public class FindMinValueInArray {
    public static void main(String[] args) {
        int[] arr;
        int size;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a size of array: ");
        size = scanner.nextInt();
        arr = new int[size];
        int i = 0;
        while (i < arr.length) {
            System.out.print("Enter element " + (i + 1) + " of array: ");
            arr[i] = scanner.nextInt();
            i++;
        }
        int index = minValue(arr);
        System.out.println("The smallest element in the array is: " + arr[index]);
    }

    private static int minValue(int[] array) {
        int index = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[index]) {
                index = i;
            }
        }
        return index;
    }
}
