package _12_Java_Collection_Framework.Exercise.ArrayList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();

        Scanner scanner = new Scanner(System.in);
        int index = -1;

        do {
            System.out.println("------------PRODUCT MANAGEMENT------------");
            System.out.println("1. Add new product");
            System.out.println("2. Update product by ID");
            System.out.println("3. Delete product by ID");
            System.out.println("4. Display list of products");
            System.out.println("5. Search product by name");
            System.out.println("6. Sort product's prices in ascending order");
            System.out.println("7. Sort product's prices in descending order");
            System.out.println("8. Exit");
            System.out.println("-------------------------------------------");
            System.out.print("Enter your choice: ");
            index = Integer.parseInt(scanner.nextLine());
            switch (index) {
                case 1:
                    productManager.addProduct();
                    break;
                case 2:
                    productManager.updateProduct();
                    break;
                case 3:
                    productManager.deleteProduct();
                    break;
                case 4:
                    productManager.displayProducts();
                    break;
                case 5:
                    productManager.searchProductByName();
                    break;
                case 6:
                    productManager.sortAscendingOrder();
                    break;
                case 7:
                    productManager.sortDescendingOrder();
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Invalid choice, please try again!");
                    break;
            }
        } while (index != 8);

        productManager.displayProducts();

    }
}
