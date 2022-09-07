package _16_IO_TextFile.Exercise.CopyFileText;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.Scanner;

public class CopyFileText {
    private void copyFile(String sourcePath, String targetPath) {
        try {
            File source = new File(sourcePath);
            if (!source.exists()) {
                throw new FileNotFoundException("Cannot find the source file specified...");
            }
            FileReader fileReader = new FileReader(source);
            BufferedReader reader = new BufferedReader(fileReader);

            File target = new File(targetPath);
            if (target.exists()) {
                throw new FileAlreadyExistsException("Target file already exist...");
            }
            FileWriter fileWriter = new FileWriter(target);
            BufferedWriter writer = new BufferedWriter(fileWriter);


            String line = "";
            int count = 0;
            while ((line = reader.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {
                    count++;
                    writer.write(line.charAt(i));
                }
                writer.write("\n");
            }

            System.out.println("Number of characters in this source file is: " + count);
            reader.close();
            writer.close();
        } catch (FileNotFoundException e) {
            System.err.println("Error source file: " + e.getMessage());
        } catch (FileAlreadyExistsException e) {
            System.err.println("Error target file: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CopyFileText copyFileText = new CopyFileText();
        System.out.println("Enter the source file path: ");
        String source = scanner.nextLine();
        System.out.println("Enter the target file path: ");
        String target = scanner.nextLine();

        /** Source file path:
         * E:\CodeGym\Repository\A0722I1-NguyenHuuHuy\Module 2\src\_16_IO_TextFile\Exercise\CopyFileText\SourceFile.txt
         *
         * Target file path:
         * E:\CodeGym\Repository\A0722I1-NguyenHuuHuy\Module 2\src\_16_IO_TextFile\Exercise\CopyFileText\TargetFile.txt
         */
        copyFileText.copyFile(source, target);
    }
}
