package _03_Array_and_Method_in_Java.Exercise;

import java.util.Scanner;

public class OccurrenceOfCharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String s = scanner.nextLine();

        System.out.println("Enter a character you want to find the occurrence: ");
        char c = scanner.next().charAt(0);

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (c == (s.charAt(i))) count++;
        }
        if (count != 0) {
            System.out.println("Occurrence of this character is: " + count);
        } else {
            System.out.println("Not found this character in the string.");
        }
    }
}
