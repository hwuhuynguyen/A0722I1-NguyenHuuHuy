package _01_Introduction_to_Java.Exercise;

import java.util.Scanner;

public class ReadNumbersIntoLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int input = scanner.nextInt();
        int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        String[] letters = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String result = "";
        if (input < 10) {
            for (int i = 0; i < 10; i++) {
                if (i == input) {
                    result = letters[i];
                    break;
                }
            }
            System.out.println(result);
        } else {
            if (input < 20) {
                int units = input % 10;
                switch (input) {
                    case 11:
                        result = "eleven";
                        break;
                    case 12:
                        result = "twelve";
                        break;
                    case 13:
                        result = "thirteen";
                        break;
                    case 15:
                        result = "fifteen";
                        break;
                    default:
                        result = letters[units] + "teen";
                        break;
                }
                if (units == 0) result = "ten";
            } else {
                if (input < 100) {
                    int tens = input / 10;
                    int units = input % 10;
                    switch (tens) {
                        case 2:
                            result = "twenty ";
                            break;
                        case 3:
                            result = "thirty ";
                            break;
                        case 5:
                            result = "fifty ";
                            break;
                        default:
                            result = letters[tens] + "ty ";
                    }
                    if (units != 0) {
                        result += letters[units];
                    }
                } else {
                    if (input < 1000) {
                        int hundreds = input / 100;
                        int tens = (input - (hundreds * 100)) / 10;
                        int units = input % 10;

                        result = letters[hundreds] + " hundred ";

                        if (tens == 0) {
                            if (units != 0)
                                result += letters[units];
                        } else {
                            if (tens == 1) {
                                switch (units) {
                                    case 1:
                                        result += "and eleven";
                                        break;
                                    case 2:
                                        result += "and twelve";
                                        break;
                                    case 3:
                                        result += "and thirteen";
                                        break;
                                    case 5:
                                        result += "and fifteen";
                                        break;
                                    case 0:
                                        result += "and ten ";
                                        break;
                                    default:
                                        result += "and " + letters[units] + "teen";
                                        break;
                                }
                            } else {
                                switch (tens) {
                                    case 2:
                                        result += "and twenty ";
                                        break;
                                    case 3:
                                        result += "and thirty ";
                                        break;
                                    case 5:
                                        result += "and fifty ";
                                        break;
                                    default:
                                        result += "and " + letters[tens] + "ty ";
                                }
                                if (units != 0) {
                                    result += letters[units];
                                }
                            }
                        }

                    }
                }
            }
        }
        if (result == "")
            System.out.println("Too hard to read this number into letters. Please try another number!");
        else
            System.out.println("Text: " + result);
    }
}

