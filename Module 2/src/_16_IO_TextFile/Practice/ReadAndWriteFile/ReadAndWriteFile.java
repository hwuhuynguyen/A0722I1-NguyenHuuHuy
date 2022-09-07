package _16_IO_TextFile.Practice.ReadAndWriteFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadAndWriteFile {
    private List<Integer> readFile(String filePath) {
        List<Integer> list = new ArrayList<>();
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                throw new FileNotFoundException("Cannot find the file specified...");
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);

            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                list.add(Integer.valueOf(line));
            }

            reader.close();
            System.out.println("List of numbers is: " + list);

        } catch (FileNotFoundException e) {
            System.err.println("Error 1: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error 2: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());;
        }

        return list;
    }

    private static int findMax(List<Integer> numbers) {
        int max = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            if (max < numbers.get(i))
                max = numbers.get(i);
        }
        return max;
    }
    private void writeFile(String filePath, int maxValue) {
        try {
            File file = new File(filePath);

            FileWriter fileWriter = new FileWriter(file , true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write("\nMax value is: " + maxValue);
            bufferedWriter.close();

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file path: ");

        /** File path
         *  E:\CodeGym\Repository\A0722I1-NguyenHuuHuy\Module 2\src\_16_IO_TextFile\Practice\ReadAndWriteFile\numbers.txt
         */

        String filePath = scanner.nextLine();

        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        List<Integer> list = readAndWriteFile.readFile(filePath);
        int max = findMax(list);
        readAndWriteFile.writeFile(filePath, max);
    }
}
