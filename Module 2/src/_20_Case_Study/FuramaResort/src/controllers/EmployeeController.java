package controllers;

import services.implement.EmployeeServiceImplement;
import services.IEmployeeService;

import java.util.Scanner;

import static views.DisplayMenu.displayEmployeeMenu;

public class EmployeeController {
    private static final IEmployeeService employeeServiceImplement = new EmployeeServiceImplement();
    public static void processEmployeeController() {
        int choice;
        do {
            displayEmployeeMenu();
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    employeeServiceImplement.displayAll();
                    break;
                case 2:
                    employeeServiceImplement.addNewEmployee();
                    break;
                case 3:
                    String employeeID;
                    Scanner scanner1 = new Scanner(System.in);
                    System.out.print("Enter employee's employee ID you want to update: ");
                    employeeID = scanner1.nextLine();
                    employeeServiceImplement.updateEmployee(employeeID);
                    break;
                case 4:
                    break;
                default:
                    System.err.println("Invalid choice!! Please try again!!");
                    break;
            }
        } while (choice != 4);
    }

}

