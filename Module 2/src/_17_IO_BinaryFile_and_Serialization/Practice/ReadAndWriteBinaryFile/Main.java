package _17_IO_BinaryFile_and_Serialization.Practice.ReadAndWriteBinaryFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Vũ Kiều Anh", "Hà Nội"));
        students.add(new Student(2, "Nguyễn Minh Quân", "Hà Nội"));
        students.add(new Student(3, "Đặng Huy Hoà", "Đà Nẵng"));
        students.add(new Student(4, "Nguyễn Khánh Tùng", "Hà Nội"));
        students.add(new Student(5, "Nguyễn Khắc Nhật", "Hà Nội"));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file path: ");
        String filePath = scanner.nextLine();
        writeToFile(filePath, students);

        List<Student> studentDataFromFile = readDataFromFile(filePath);
        for (Student student : studentDataFromFile){
            System.out.println(student);
        }
    }

    private static List<Student> readDataFromFile(String filePath) {
        List<Student> students = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(filePath);
            ObjectInputStream ois = new ObjectInputStream(fis);
            students = (List<Student>) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return students;
    }

    private static void writeToFile(String filePath, List<Student> students) {
        try {
            FileOutputStream fis = new FileOutputStream(filePath);
            ObjectOutputStream oos = new ObjectOutputStream(fis);
            oos.writeObject(students);
            oos.close();
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
