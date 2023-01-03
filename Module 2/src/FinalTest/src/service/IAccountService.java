package service;

import exception.NotFoundBankAccountException;

public interface IAccountService {
    void displayAll();
    void addNewSavingAccount();
    void addNewDepositAccount();
    void deleteAccount() throws NotFoundBankAccountException;
    void searchAccount() throws NotFoundBankAccountException;
}
