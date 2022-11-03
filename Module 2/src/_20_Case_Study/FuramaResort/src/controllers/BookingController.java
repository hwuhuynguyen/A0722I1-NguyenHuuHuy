package controllers;

import services.implement.BookingServiceImplement;
import services.IBookingService;

import java.util.Scanner;

import static views.DisplayMenu.displayBookingMenu;

public class BookingController {
    private static final IBookingService bookingServiceImplement = new BookingServiceImplement();
    public static void processBookingController() {
        int choice;
        do {
            displayBookingMenu();
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    bookingServiceImplement.addNewBooking();
                    break;
                case 2:
                    bookingServiceImplement.displayAll();
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                default:
            }
        } while (choice != 6);
    }
}
