package _16_IO_TextFile.Exercise.ReadFile_csv;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class ReadFileCSV {
    private void readFile(String filePath) {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                throw new FileNotFoundException("Cannot find the file specified...");
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);

            String line;

            while ((line = reader.readLine()) != null) {
                List<String> list;
                list = List.of(line.split(","));
                System.out.println(list);
            }

        } catch (FileNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        ReadFileCSV readFileCSV = new ReadFileCSV();

        /** File path:
         *  E:\CodeGym\Repository\A0722I1-NguyenHuuHuy\Module 2\src\_16_IO_TextFile\Exercise\ReadFile_csv\countries.csv
         */

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file path: ");
        String filePath = scanner.nextLine();
        readFileCSV.readFile(filePath);
    }
}
