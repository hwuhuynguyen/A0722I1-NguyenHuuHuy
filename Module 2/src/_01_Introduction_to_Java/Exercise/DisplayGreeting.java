package _01_Introduction_to_Java.Exercise;

import java.util.Scanner;

public class DisplayGreeting {
    public static void main(String[] args) {
        System.out.print("Enter your name: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        System.out.println("Hello " + name);
    }
}
