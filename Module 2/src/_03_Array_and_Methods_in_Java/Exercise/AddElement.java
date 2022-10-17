package _03_Array_and_Methods_in_Java.Exercise;

import java.util.Scanner;

public class AddElement {
    public static void main(String[] args) {
        int[] array = {4, 12, 7, 8, 1, 6, 9, 10};
        Scanner input = new Scanner(System.in);
        System.out.printf("Enter a value: ");
        int value = input.nextInt();
        System.out.printf("Enter a position you want to add this value to: ");
        int index = input.nextInt();

        if (index <= 1 || (index+1) >= (array.length)) {
            System.out.println("Can not insert this value in this array!");
        } else {
            int[] newArray = new int[array.length+1];
            for (int i = 0; i < newArray.length; i++) {
                if (i > index) {
                    newArray[i] = array[i-1];
                }
                if (i == index) newArray[i] = value;
                if (i < index) newArray[i] = array[i];
            }

            System.out.printf("New array: ");
            for (int i = 0; i < newArray.length; i++) {
                System.out.printf(newArray[i] + " ");
            }
        }
    }
}
