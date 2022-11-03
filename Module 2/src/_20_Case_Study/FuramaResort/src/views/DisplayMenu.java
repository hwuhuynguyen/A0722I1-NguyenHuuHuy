package views;

public class DisplayMenu {

    public static void displayMainMenu() {
        System.out.println();
        System.out.println("-------- Main menu --------");
        System.out.println("1. Employee Management\n" +
                "2. Customer Management\n" +
                "3. Facility Management\n" +
                "4. Booking Management\n" +
                "5. Promotion Management\n" +
                "6. Exit");
        System.out.println("---------------------------");
        System.out.print("Enter your choice: ");
    };
    public static void displayEmployeeMenu() {
        System.out.println();
        System.out.println("--- Employee management ---");
        System.out.println("1. Display list employees\n" +
                "2. Add new employee\n" +
                "3. Edit employee\n" +
                "4. Return main menu");
        System.out.println("---------------------------");
        System.out.print("Enter your choice: ");
    }
    public static void displayCustomerMenu() {
        System.out.println();
        System.out.println("--- Customer management ---");
        System.out.println("1. Display list customers\n" +
                "2. Add new customer\n" +
                "3. Edit customer\n" +
                "4. Return main menu");
        System.out.println("---------------------------");
        System.out.print("Enter your choice: ");
    }
    public static void displayFacilityMenu() {
        System.out.println();
        System.out.println("--- Facility management ---");
        System.out.println("1. Display list facility\n" +
                "2. Add new facility\n" +
                "3. Display list facility maintenance\n" +
                "4. Return main menu");
        System.out.println("---------------------------");
        System.out.print("Enter your choice: ");
    }
    public static void displayFacilitySubMenuAdd() {
        System.out.println();
        System.out.println("---- Add new facility ----");
        System.out.println("1. Add New Villa\n" +
                "2. Add New House\n" +
                "3. Add New Room\n" +
                "4. Back to facility management menu");
        System.out.println("---------------------------");
        System.out.print("Enter your choice: ");
    }
    public static void displayBookingMenu() {
        System.out.println();
        System.out.println("--- Booking management ---");
        System.out.println("1. Add new booking\n" +
                "2. Display list booking\n" +
                "3. Create new contracts\n" +
                "4. Display list contracts\n" +
                "5. Edit contracts\n" +
                "6. Return main menu");
        System.out.println("---------------------------");
        System.out.print("Enter your choice: ");
    }
    public static void displayPromotionMenu() {
        System.out.println();
        System.out.println("--- Promotion management ---");
        System.out.println("1. Display list customers use service\n" +
                "2. Display list customers get voucher\n" +
                "3. Return main menu");
        System.out.println("---------------------------");
        System.out.print("Enter your choice: ");
    }

    public static void displaySubMenuFacility() {
        System.out.println();
        System.out.println("---------------------------");
        System.out.println("----- Type of services ----");
        System.out.println("1. Villa");
        System.out.println("2. House");
        System.out.println("3. Room");
        System.out.println("---------------------------");
        System.out.print("Enter your choice: ");
    }
}
