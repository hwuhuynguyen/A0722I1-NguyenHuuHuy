package _13_Search_Algorithm.Exercise;

import java.util.LinkedList;
import java.util.Scanner;

public class LargestAscendingString {
    private static void findLargestAscendingString(String input) {
        LinkedList<Character> max = new LinkedList<>();

        for (int i = 0; i < input.length(); i++) {
            LinkedList<Character> list = new LinkedList<>();
            list.add(input.charAt(i));
            for (int j = i+1; j < input.length(); j++) {
                if ((int)input.charAt(j) >= (int)list.getLast()) {
                    list.add(input.charAt(j));
                }
            }
            if (list.size() > max.size()) {
                max.clear();
                max.addAll(list);
            }
        }
        for (Character c : max) {
            System.out.print(c);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String input = scanner.nextLine();
        findLargestAscendingString(input);
    }
}
