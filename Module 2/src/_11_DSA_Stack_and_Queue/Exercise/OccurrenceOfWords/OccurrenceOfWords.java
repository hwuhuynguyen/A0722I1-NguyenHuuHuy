package _11_DSA_Stack_and_Queue.Exercise.OccurrenceOfWords;

import java.util.Locale;
import java.util.Scanner;
import java.util.TreeMap;

public class OccurrenceOfWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String input = scanner.nextLine();
        input = input.toLowerCase(Locale.ROOT);

        String[] array = input.split(" ");
        TreeMap<String, Integer> treeMap = new TreeMap<>();

        for (int i = 0; i < array.length; i++) {
            if (!treeMap.containsKey(array[i])) {
                treeMap.put(array[i], 1);
            } else {
                treeMap.put(array[i], treeMap.get(array[i]) + 1);
            }
        }
        System.out.println(treeMap);
    }
}
