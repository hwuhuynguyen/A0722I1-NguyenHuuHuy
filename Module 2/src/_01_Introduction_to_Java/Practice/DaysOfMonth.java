package _01_Introduction_to_Java.Practice;

import java.util.Scanner;

public class DaysOfMonth {
    public static void main(String[] args) {
        System.out.print("Enter a month: ");
        Scanner scanner = new Scanner(System.in);
        String daysOfMonth = "";
        int month = scanner.nextInt();
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                daysOfMonth = "31";
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                daysOfMonth = "30";
                break;
            case 2:
                daysOfMonth = "28 or 29";
                break;
            default:
                break;
        }

        if (!daysOfMonth.equals(""))
            System.out.printf("This month, " + month + ", has " + daysOfMonth + " days");
        else
            System.out.printf("Invalid input, please type again!");
    }

}
