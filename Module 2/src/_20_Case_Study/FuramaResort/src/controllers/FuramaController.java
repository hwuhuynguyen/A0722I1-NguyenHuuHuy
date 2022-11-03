package controllers;

import java.util.Scanner;

import static controllers.BookingController.processBookingController;
import static controllers.CustomerController.processCustomerController;
import static controllers.EmployeeController.processEmployeeController;
import static controllers.FacilityController.processFacilityController;
import static views.DisplayMenu.*;

public class FuramaController {
    public static void main(String[] args) {
        processMainMenu();
    }
    static void processMainMenu() {
        int choice;
        Scanner scanner = new Scanner(System.in);
        do {
            displayMainMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    processEmployeeController();
                    break;
                case 2:
                    processCustomerController();
                    break;
                case 3:
                    processFacilityController();
                    break;
                case 4:
                    processBookingController();
                    break;
                case 5:
                    displayPromotionMenu();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Invalid choice!!! Please try again!!!");
                    break;
            }
        } while (choice != 6);
        System.out.println("See you later!!!");
    }

}
