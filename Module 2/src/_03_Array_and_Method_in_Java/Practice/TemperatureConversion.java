package _03_Array_and_Method_in_Java.Practice;

import java.util.Scanner;

public class TemperatureConversion {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice = -1;
        do {
            System.out.println("Menu.");
            System.out.println("1. Fahrenheit to Celsius");
            System.out.println("2. Celsius to Fahrenheit");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.printf("Enter a Fahrenheit value: ");
                    double fahrenheit = input.nextDouble();
                    System.out.println("Celsius value is: " + fahrenheitToCelsius(fahrenheit));
                    break;
                case 2:
                    System.out.printf("Enter a Celsius value: ");
                    double celsius = input.nextDouble();
                    System.out.println("Fahrenheit value is: " + celsiusToFahrenheit(celsius));
                    break;
                case 0:
                    System.exit(0);
            }
        } while (choice != 0);

    }

    private static double celsiusToFahrenheit(double celsius) {
        double fahrenheit = (9.0 / 5) * celsius + 32;
        return fahrenheit;
    }

    private static double fahrenheitToCelsius(double fahrenheit) {
        double celsius = (5.0 / 9) * (fahrenheit - 32);
        return celsius;
    }
}
