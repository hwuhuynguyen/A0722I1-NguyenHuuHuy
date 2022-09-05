package _12_Java_Collection_Framework.Exercise.ArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    public static ArrayList<Product> products = new ArrayList<Product>(List.of(new Product[]{
            new Product(1, "Smartphone", 10000),
            new Product(2, "Laptop", 30000),
            new Product(3, "Tablet", 20000)
    }));

    Scanner scanner = new Scanner(System.in);
    ProductComparatorAscending productComparatorAscending = new ProductComparatorAscending();
    ProductComparatorDescending productComparatorDescending = new ProductComparatorDescending();

    protected void addProduct() {
        boolean check = false;
        do {
            int index = -1;
            System.out.print("Enter an ID of new product: ");
            int id = Integer.parseInt(scanner.nextLine());

            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getId() == id) {
                    index = i;
                    check = false;
                }
            }
            if (index == -1 || products.size() == 0)
                check = true;
            if (check) {
                System.out.print("Enter a name of new product: ");
                String name = scanner.nextLine();
                System.out.print("Enter a price of new product: ");
                int price = Integer.parseInt(scanner.nextLine());
                Product newProduct = new Product(id, name, price);
                products.add(newProduct);
            } else {
                System.out.println("Invalid ID, please try again!");
            }
        } while (!check);
    }
    protected void updateProduct() {
        System.out.printf("Enter an ID of product you want to update: ");
        int index = -1;
        int id = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                index = i;
                System.out.print("Enter a new name of the product: ");
                String name = scanner.nextLine();
                System.out.print("Enter a new price of the product: ");
                int price = Integer.parseInt(scanner.nextLine());
                products.get(index).setName(name);
                products.get(index).setPrice(price);
                break;
            }
        }
        if (index == -1) {
            System.out.println("Invalid index, please try again!");
        }
    }

    protected void searchProductByName() {
        int index = -1;
        System.out.printf("Enter a product's name you want to search: ");
        String name = scanner.nextLine();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName() == name) {
                index = i;
                System.out.println("Product{" + "id=" + products.get(i).getId()
                        + ", name='" + products.get(i).getName() + '\''
                        + ", price=" + products.get(i).getPrice() + '}');
            }
        }
        if (index == -1) {
            System.out.println("Invalid name, please try again!");
        }
    }
    protected void deleteProduct() {
        int index = -1;
        System.out.printf("Enter an ID of product you want to delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                index = i;
                products.remove(index);
            }
        }
        if (index == -1) {
            System.out.println("Invalid index, please try again!");
        }
    }
    protected void displayProducts() {
        System.out.println("-----List of products-----");
        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i));
        }
        System.out.println("--------------------------");
    }
    protected void sortAscendingOrder() {
        Collections.sort(products, productComparatorAscending);
        displayProducts();
    }
    protected void sortDescendingOrder() {
        Collections.sort(products, productComparatorDescending);
        displayProducts();
    }
}
