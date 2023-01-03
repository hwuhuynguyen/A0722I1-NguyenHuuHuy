package service.impl;

import model.Account;
import model.DepositAccount;
import model.SavingAccount;
import service.IAccountService;
import utils.impl.AccountReadAndWriteFileCSV;
import exception.NotFoundBankAccountException;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AccountService implements IAccountService {
    private static List<Account> accountList = new LinkedList<>();
    private static int lastIndex = 0;
//    static {
//        accountList.add(new SavingAccount(1, "123", "Nguyen Van A",
//                "04/05/2020", 15000, "05/05/2020", 5, 6));
//        accountList.add(new SavingAccount(2, "123", "Nguyen Van A",
//                "04/05/2020", 15000, "05/05/2020", 5, 6));
//        accountList.add(new SavingAccount(3, "123", "Nguyen Van A",
//                "04/05/2020", 15000, "05/05/2020", 5, 6));
//        accountList.add(new SavingAccount(4, "123", "Nguyen Van A",
//                "04/05/2020", 15000, "05/05/2020", 5, 6));
//        accountList.add(new DepositAccount(5, "123", "Nguyen Van A",
//                "04/05/2020", "0512122020", 6));
//        accountList.add(new DepositAccount(6, "123", "Nguyen Van A",
//                "04/05/2020", "0512122020", 6));
//    }
    static {
        accountList = AccountReadAndWriteFileCSV.readFileCSV();
        lastIndex = accountList.get(accountList.size() - 1).getId() ;
    }

    @Override
    public void displayAll() {
        System.out.println("List of accounts: ");
        for (Account account : accountList) {
            account.getInformation();
        }
        System.out.println();
    }

    @Override
    public void addNewSavingAccount() {
        Scanner scanner = new Scanner(System.in);
        Account account;
        System.out.print("Enter new account code: ");
        String accountCode = scanner.nextLine();
        System.out.print("Enter new account user: ");
        String accountUser = scanner.nextLine();
        System.out.print("Enter new creation date: ");
        String dateCreate = scanner.nextLine();
        System.out.print("Enter new money: ");
        double money = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter new date of saving: ");
        String dateSaving = scanner.nextLine();
        System.out.print("Enter new rate: ");
        double rate = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter new month: ");
        int month = Integer.parseInt(scanner.nextLine());

        accountList = AccountReadAndWriteFileCSV.readFileCSV();
        lastIndex = accountList.get(accountList.size() - 1).getId() ;

        int id = lastIndex + 1;
        account = new SavingAccount(id, accountCode, accountUser, dateCreate, money, dateSaving, rate, month);
        accountList.add(account);

        AccountReadAndWriteFileCSV.writeFileCSV(accountList);
    }

    @Override
    public void addNewDepositAccount() {
        Scanner scanner = new Scanner(System.in);
        Account account;
        System.out.print("Enter new account code: ");
        String accountCode = scanner.nextLine();
        System.out.print("Enter new account user: ");
        String accountUser = scanner.nextLine();
        System.out.print("Enter new date create: ");
        String dateCreate = scanner.nextLine();
        System.out.print("Enter new card number: ");
        String cardNumber = scanner.nextLine();
        System.out.print("Enter new amount: ");
        double amount = Double.parseDouble(scanner.nextLine());

        accountList = AccountReadAndWriteFileCSV.readFileCSV();
        lastIndex = accountList.get(accountList.size() - 1).getId() ;

        int id = lastIndex + 1;
        account = new DepositAccount(id, accountCode, accountUser, dateCreate, cardNumber, amount);
        accountList.add(account);

        AccountReadAndWriteFileCSV.writeFileCSV(accountList);
    }

    @Override
    public void deleteAccount() throws NotFoundBankAccountException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the account code you want to delete: ");
        String code = scanner.nextLine();
        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).getAccountCode().equals(code)) {
                accountList.remove(i);
                break;
            }
            if (i == (accountList.size() - 1)) {
                throw new NotFoundBankAccountException("Account is not exist! Try again!");
            }
        }
        AccountReadAndWriteFileCSV.writeFileCSV(accountList);
    }

    @Override
    public void searchAccount() throws NotFoundBankAccountException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the account's code or account's user of the account you want to search: ");
        String input = scanner.nextLine();
        boolean check = false;
        for (Account account : accountList) {
            if (account.getAccountCode().contains(input) || account.getAccountUser().contains(input)) {
                check = true;
                account.getInformation();
            }
        }
        if (!check) {
            throw new NotFoundBankAccountException("Account is not exist! Try again!");
        }
        System.out.println();
    }
}
