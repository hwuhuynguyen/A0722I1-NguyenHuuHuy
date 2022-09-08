package _17_IO_BinaryFile_and_Serialization.Exercise.ProductManagement;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Product_DAO {
    private static Product_DAO _Instance;

    public static Product_DAO Instance() {
        if (_Instance == null) {
            _Instance = new Product_DAO();
        }
        return _Instance;
    }

    protected void addNewProductToFile(String filePath, Product product) {
        List<Product> list;
        try {
            FileInputStream fis = new FileInputStream(filePath);
            ObjectInputStream ois = new ObjectInputStream(fis);
            list = (List<Product>) ois.readObject();

            ois.close();
            fis.close();

            list.add(product);

            FileOutputStream fos = new FileOutputStream(filePath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(list);
            oos.close();
            fos.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    protected Product searchProductByName(String filePath, String name) {
        List<Product> list;
        Product p = null;
        try {
            FileInputStream fis = new FileInputStream(filePath);
            ObjectInputStream ois = new ObjectInputStream(fis);
            list = (List<Product>) ois.readObject();

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getName().contains(name)) {
                    p = new Product(list.get(i));
                }
            }

            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return p;
    }

    protected void updateProductToFile(String filePath, int idProduct) {
        List<Product> list;
        try {
            FileInputStream fis = new FileInputStream(filePath);
            ObjectInputStream ois = new ObjectInputStream(fis);
            list = (List<Product>) ois.readObject();

            ois.close();
            fis.close();

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getId() == idProduct) {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Enter a new product name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter a new product manufacturer: ");
                    String manufacturer = scanner.nextLine();
                    System.out.println("Enter a new product price: ");
                    double price = Double.parseDouble(scanner.nextLine());

                    list.get(i).setName(name);
                    list.get(i).setManufacturer(manufacturer);
                    list.get(i).setPrice(price);
                }
            }

            FileOutputStream fos = new FileOutputStream(filePath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(list);
            oos.close();
            fos.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    protected void deleteProduct(String filePath, int idProduct) {
        List<Product> list;
        try {
            FileInputStream fis = new FileInputStream(filePath);
            ObjectInputStream ois = new ObjectInputStream(fis);
            list = (List<Product>) ois.readObject();

            ois.close();
            fis.close();

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getId() == idProduct) {
                    list.remove(i);
                }
            }

            FileOutputStream fos = new FileOutputStream(filePath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(list);
            oos.close();
            fos.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

