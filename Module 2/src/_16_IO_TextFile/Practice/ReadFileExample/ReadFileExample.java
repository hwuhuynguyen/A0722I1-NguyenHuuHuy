package _16_IO_TextFile.Practice.ReadFileExample;

import java.io.*;
import java.util.Scanner;

class ReadFileExample {
    void readFileText(String filePath) {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                throw new FileNotFoundException("Cannot find the file specified...");
            }
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            int sum = 0;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                sum += Integer.parseInt(line);
            }
            reader.close();
            System.out.println("Sum: " + sum);
        } catch (FileNotFoundException e) {
            System.err.println("Error 1: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error 2: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        System.out.println("Enter the file path: ");

        /** File path:
            E:\CodeGym\Repository\A0722I1-NguyenHuuHuy\Module 2\src\_16_IO_TextFile\Practice\ReadFileExample\numbers.txt
         */

        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();

        ReadFileExample readFileEx = new ReadFileExample();
        readFileEx.readFileText(path);
    }
}
