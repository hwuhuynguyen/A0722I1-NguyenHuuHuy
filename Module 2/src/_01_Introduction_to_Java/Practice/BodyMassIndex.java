package _01_Introduction_to_Java.Practice;

import java.sql.SQLOutput;
import java.util.Scanner;

public class BodyMassIndex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your height (m): ");
        float height = scanner.nextFloat();
        System.out.print("Enter your weight (kg): ");
        float weight = scanner.nextFloat();

        float bmi = (float) (weight / (Math.pow(height, 2)));

        if (bmi < 18)
            System.out.println("Underweight");
        else if (bmi < 25.0)
            System.out.println("Normal");
        else if (bmi < 30.0)
            System.out.println("Overweight");
        else
            System.out.println("Obese");
    }
}
