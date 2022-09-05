package _11_DSA_Stack_and_Queue.Exercise.ReverseArray;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String input = scanner.nextLine();
        char[] array = new char[input.length()];

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        System.out.println(stack);

        String newString = "";
        while (!stack.isEmpty()) {
            newString = newString.concat(String.valueOf(stack.pop()));
        }

        System.out.println("String after reverse: " + newString);
    }
}
