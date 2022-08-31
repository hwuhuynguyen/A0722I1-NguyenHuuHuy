package _02_Loop_in_Java.Exercise;

import java.util.Scanner;

public class DrawMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while(choice != 0) {
            System.out.println("Menu");
            System.out.println("1. Print the rectangle");
            System.out.println("2. Print the square triangle");
            System.out.println("3. Print isosceles triangle");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 20; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;
                case 2:
                    for (int i = 0; i < 10; i++) {
                        for (int j = 0; j < 10; j++) {
                            if (i >= j)
                                System.out.print("*");
                            else
                                System.out.print(" ");
                        }
                        System.out.println();
                    }
                    System.out.println();
                    for (int i = 0; i < 10; i++) {
                        for (int j = 0; j < 10; j++) {
                            if (i+j < 10)
                                System.out.print("*");
                            else
                                System.out.print(" ");
                        }
                        System.out.println();
                    }
                    System.out.println();

                    for (int i = 0; i < 10; i++) {
                        for (int j = 0; j < 10; j++) {
                            if (i+j < 9)
                                System.out.print(" ");
                            else
                                System.out.print("*");
                        }
                        System.out.println();
                    }
                    System.out.println();

                    for (int i = 0; i <= 9; i++) {
                        for (int j = 0; j <= 9; j++) {
                            if (i <= j)
                                System.out.print("*");
                            else
                                System.out.print(" ");
                        }
                        System.out.println();
                    }
                    System.out.println();
                    break;
                case 3:
                    int q = 0;
                    int n = 7;
                    while (n > 0)
                    {
                        for (int i = 1; i < n; i++)
                            System.out.printf(" ");
                        for (int k = 0; k <= q; k ++)
                            System.out.printf("*");
                        n-- ;
                        q += 2 ;
                        System.out.println();
                    }

                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
                    break;
            }
        }
    }
}
