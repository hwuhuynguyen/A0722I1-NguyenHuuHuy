package _15_Exception_Debug.Practice;

import java.util.Random;
import java.util.Scanner;

public class ArrayExample {
    private Integer[] createRandom() {
        Random rd = new Random();
        Integer[] arr = new Integer[100];
        System.out.println("List of elements: " );
        for (int i = 0; i < 100; i++) {
            arr[i] = rd.nextInt(100);
            System.out.print(arr[i]+ " ");
        }
        return arr;
    }

    public static void main(String[] args) {
        ArrayExample arrExample = new ArrayExample();
        Integer[] arr = arrExample.createRandom();

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter an index of any element: ");
        int x = scanner.nextInt();
        try {
            System.out.println("The value of element with index " + x + " is: " + arr[x]);
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Error: Index out of bounds!");
        }
    }

}
