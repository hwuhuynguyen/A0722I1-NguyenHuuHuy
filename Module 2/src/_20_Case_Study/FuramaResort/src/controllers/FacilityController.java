package controllers;

import services.implement.FacilityServiceImplement;
import services.IFacilityService;

import java.util.Scanner;

import static views.DisplayMenu.displayFacilityMenu;

public class FacilityController {
    private static final IFacilityService facilityServiceImplement = new FacilityServiceImplement();
    public static void processFacilityController() {
        int choice;
        do {
            displayFacilityMenu();
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    facilityServiceImplement.displayAll();
                    break;
                case 2:
                    facilityServiceImplement.addNewService();
                    break;
                case 3:

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
