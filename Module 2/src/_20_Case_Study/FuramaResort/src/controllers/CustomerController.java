package controllers;

import services.implement.CustomerServiceImplement;
import services.ICustomerService;

import java.util.Scanner;

import static views.DisplayMenu.displayCustomerMenu;

public class CustomerController {
    private static final ICustomerService customerServiceImplement = new CustomerServiceImplement();
    public static void processCustomerController() {
        int choice;
        do {
            displayCustomerMenu();
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    customerServiceImplement.displayAll();
                    break;
                case 2:
                    customerServiceImplement.addNewCustomer();
                    break;
                case 3:
                    String customerID;
                    Scanner scanner1 = new Scanner(System.in);
                    System.out.print("Enter customer's customer ID you want to update: ");
                    customerID = scanner1.nextLine();
                    customerServiceImplement.updateCustomer(customerID);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid choice!! Please try again!!");
                    break;
            }
        } while (choice != 4);
    }

}
