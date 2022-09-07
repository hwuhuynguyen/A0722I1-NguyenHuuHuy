package _15_Exception_Debug.Exercise.IllegalTriangleException;

import java.util.Scanner;

public class IllegalTriangleExceptionTest {
    public static void main(String[] args) throws IllegalTriangleException {
        double side1, side2, side3;
        boolean check = false;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter value of side 1: ");
            side1 = Double.parseDouble(scanner.nextLine());
            System.out.println("Enter value of side 2: ");
            side2 = Double.parseDouble(scanner.nextLine());
            System.out.println("Enter value of side 3: ");
            side3 = Double.parseDouble(scanner.nextLine());
            try {
                Triangle triangle = new Triangle(side1, side2, side3);
                check = true;
            } catch (IllegalTriangleException e) {
                System.err.println("Error: " + e.getMessage());
            }
        } while (!check);
    }
}
