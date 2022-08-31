package _02_Loop_in_Java.Practice;

import java.util.Scanner;

public class GreatCommonFactor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int commonFactor;
        System.out.print("Enter a: ");
        int a = scanner.nextInt();
        System.out.printf("Enter b: ");
        int b = scanner.nextInt();
        if (a == 0 || b == 0) {
            commonFactor = 0;
        } else {
            while (a != b) {
                if (a > b) {
                    a -= b;
                } else {
                    b -= a;
                }
            }
            commonFactor = a;
        }
        System.out.println("Greatest common factor of a and b is: " + commonFactor);
    }
}
