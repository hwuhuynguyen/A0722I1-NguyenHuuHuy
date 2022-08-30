package _01_Introduction_to_Java.Exercise;

import java.util.Scanner;

public class CurrencyConversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter the amount (in USD): ");
        double usd = scanner.nextDouble();
        double vnd = usd * 23000;
        System.out.println("Value of that amount (in VND): " + vnd);
    }
}
