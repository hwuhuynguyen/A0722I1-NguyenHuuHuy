package _01_Introduction_to_Java.Practice;

import java.util.Scanner;

public class DaysOfMonth {
    System.out.println("Nhap so thang: ");
    Scanner scanner = new Scanner(System.in);
    int month = scanner.nextInt();

    switch (month) {
        case 1:
        case 3:
        case 5:
        case 7:
        case 8:
        case 10:
        case 12:
        case 4:
        case 6:
        case 9:
        case 11:
            break;
        case 2:
            break;
        default:
            break;
    }
}
