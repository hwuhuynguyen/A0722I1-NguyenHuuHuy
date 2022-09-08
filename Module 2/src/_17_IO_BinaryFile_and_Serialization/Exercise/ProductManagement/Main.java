package _17_IO_BinaryFile_and_Serialization.Exercise.ProductManagement;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();
        list.add(new Product(1, "Laptop", "Dell", 20000));
        list.add(new Product(2, "Macbook", "Apple", 40000));
        list.add(new Product(3, "Smartphone", "Samsung", 5000));
        list.add(new Product(4, "Car", "VinFast", 900000));
        list.add(new Product(5, "Motorbike", "Honda", 50000));

        /** File path:
         *  E:\CodeGym\Repository\A0722I1-NguyenHuuHuy\Module 2\src\_17_IO_BinaryFile_and_Serialization\Exercise\ProductManagement\products.txt
         */

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file path: ");
        String filePath = scanner.nextLine();
        writeToFile(filePath, list);

        Product p = new Product(6, "Apartment", "VinHome", 500000);
        Product_DAO product_dao = new Product_DAO();
        product_dao.addNewProductToFile(filePath, p);

        int idUpdatedProduct = 2;
        product_dao.updateProductToFile(filePath, idUpdatedProduct);

        int idDeletedProduct = 3;
        product_dao.deleteProduct(filePath, idDeletedProduct);

        List<Product> productsDataFromFile = readDataFromFile(filePath);
        for (Product product : productsDataFromFile) {
            System.out.println(product);
        }
        System.out.println("Result of search:");
        System.out.println(product_dao.searchProductByName(filePath, "Car"));

        System.out.println("Result of update:");
        for (int i = 0; i < productsDataFromFile.size(); i++) {
            if (idUpdatedProduct == productsDataFromFile.get(i).getId()) {
                System.out.println(productsDataFromFile.get(i));
            }
        }
    }

    private static List<Product> readDataFromFile(String filePath) {
        List<Product> products = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(filePath);
            ObjectInputStream ois = new ObjectInputStream(fis);
            products = (List<Product>) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return products;
    }

    private static void writeToFile(String filePath, List<Product> list) {
        try {
            FileOutputStream dos = new FileOutputStream((filePath));
            ObjectOutputStream oos = new ObjectOutputStream(dos);

            oos.writeObject(list);

            oos.close();
            dos.close();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
