package _03_Array_and_Method_in_Java.Practice;

import java.util.Scanner;

public class FindValueInArray {
    public static void main(String[] args) {
        String[] names = {"Anthony", "De Beek", "Cristiano", "De Gea"};
        Scanner scanner = new Scanner(System.in);
        int position = -1;
        System.out.printf("Enter a name you want to search: ");
        String name = scanner.nextLine();
        for (int i = 0; i < names.length; i++) {
            if (name.equals(names[i])) {
                position = i;
            }
        }
        if (position != -1) {
            System.out.println("Position of the student in the list is: " + (position+1));
        } else {
            System.out.println("Not found " + name + " in the list");
        }
    }
}
