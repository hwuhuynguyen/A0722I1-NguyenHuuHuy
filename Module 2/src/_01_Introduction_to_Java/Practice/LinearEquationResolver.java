package _01_Introduction_to_Java.Practice;
import java.util.Scanner;

public class LinearEquationResolver {
    public static void main(String[] args) {
        System.out.println("Linear Equation Resolver");
        System.out.println("Given a equation as 'a * x + b = c', please enter constants:");
        Scanner scanner = new Scanner(System.in);
        System.out.print("a: ");
        double a = scanner.nextDouble();

        System.out.print("b: ");
        double b = scanner.nextDouble();

        System.out.print("c: ");
        double c = scanner.nextDouble();

        if (a != 0) {
            double result = (c - b)/a;
            System.out.println("Solution of this equation is: x = " + result);
        } else {
            if (b == c) {
                System.out.println("Equation with infinite solutions");
            } else {
                System.out.println("Equation with no solutions");
            }
        }
    }
}
