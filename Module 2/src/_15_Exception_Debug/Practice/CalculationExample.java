package _15_Exception_Debug.Practice;

import java.util.Scanner;

public class CalculationExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter value of x: ");
        int x = scanner.nextInt();
        System.out.println("Enter value of y: ");
        int y = scanner.nextInt();
        CalculationExample calc = new CalculationExample();
        calc.calculate(x, y);

    }

    private void calculate(int x, int y) {
        try {
            int a = x + y;
            int b = x - y;
            int c = x * y;
            int d = x / y;
            System.out.println("Sum of x and y is: " + a);
            System.out.println("Subtraction of x and y is: " + b);
            System.out.println("Multiplication of x and y is: " + c);
            System.out.println("Division of x and y is: " + d);
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

}
