package view;

public class Menu {
    public static void displayMainMenu() {
        System.out.println("----BANK ACCOUNT MANAGEMENT----");
        System.out.println("1. Add new account");
        System.out.println("2. Delete account");
        System.out.println("3. View list of bank accounts");
        System.out.println("4. Search for bank account");
        System.out.println("5. Exit");
        System.out.println("-------------------------------");
        System.out.print("Enter your choice (1-5): ");
    }
    public static void displayAddSubMenu() {
        System.out.println("--------ADD NEW ACCOUNT--------");
        System.out.println("1. Saving account");
        System.out.println("2. Deposit account");
        System.out.println("-------------------------------");
        System.out.print("Enter your choice (1-2): ");
    }
}
