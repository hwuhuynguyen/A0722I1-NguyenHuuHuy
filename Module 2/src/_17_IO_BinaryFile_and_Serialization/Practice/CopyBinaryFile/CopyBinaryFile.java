package _17_IO_BinaryFile_and_Serialization.Practice.CopyBinaryFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class CopyBinaryFile {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter source file:");
        String sourcePath = in.nextLine();
        System.out.println("Enter destination file:");
        String targetPath = in.nextLine();

        /** File source path:
         *  E:\CodeGym\Repository\A0722I1-NguyenHuuHuy\Module 2\src\_17_IO_BinaryFile_and_Serialization\Practice\CopyBinaryFile\source.txt
         *
         *  File target path:
         *  E:\CodeGym\Repository\A0722I1-NguyenHuuHuy\Module 2\src\_17_IO_BinaryFile_and_Serialization\Practice\CopyBinaryFile\target.txt
         */

        File sourceFile = new File(sourcePath);
        File targetFile = new File(targetPath);

        try {
            //copyFileUsingJava7Files(sourceFile, targetFile);
            copyFileUsingStream(sourceFile, targetFile);
            System.out.println("Copy completed");
        } catch (IOException e) {
            System.err.println("Message: Cannot copy that file");
            System.err.println("Error: " + e.getMessage());
        }

    }

    private static void copyFileUsingStream(File sourceFile, File targetFile) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(sourceFile);
            os = new FileOutputStream(targetFile);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            is.close();
            os.close();
        }
    }

    private static void copyFileUsingJava7Files(File sourceFile, File targetFile) throws IOException {
        Files.copy(sourceFile.toPath(), targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
}
