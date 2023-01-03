package controller;

import service.IAccountService;
import service.impl.AccountService;
import exception.NotFoundBankAccountException;

import java.util.Scanner;

import static view.Menu.*;

public class AccountController {
    private static final IAccountService accountService = new AccountService();
    public static void processController() {
        int choice;
        do {
            displayMainMenu();
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    displayAddSubMenu();
                    int anotherChoice = scanner.nextInt();
                    switch (anotherChoice) {
                        case 1 -> accountService.addNewSavingAccount();
                        case 2 -> accountService.addNewDepositAccount();
                        default -> System.out.println("Invalid choice!! Please try again!!");
                    }
                    break;
                case 2:
                    try {
                        accountService.deleteAccount();
                    } catch (NotFoundBankAccountException exception) {
                        System.err.println(exception.getMessage());
                    }
                    break;
                case 3:
                    accountService.displayAll();
                    break;
                case 4:
                    try {
                        accountService.searchAccount();
                    } catch (NotFoundBankAccountException exception) {
                        System.err.println(exception.getMessage());
                    }
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid choice!! Please try again!!");
                    break;
            }
        } while (choice != 5);
    }
}
