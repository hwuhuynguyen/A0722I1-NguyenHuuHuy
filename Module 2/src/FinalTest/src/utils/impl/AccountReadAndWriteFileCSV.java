package utils.impl;

import model.Account;
import model.DepositAccount;
import model.SavingAccount;
import utils.IAccountReadAndWriteFileCSV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class AccountReadAndWriteFileCSV implements IAccountReadAndWriteFileCSV {
    public static void writeFileCSV(List<Account> list){
        FileWriter fileWriter = null;
        try{
            fileWriter = new FileWriter(FILE_PATH_ACCOUNT);
            for(Account element : list){
                if (element instanceof SavingAccount) {
                    fileWriter.append(String.valueOf(element.getId()));
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append(element.getAccountCode());
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append(element.getAccountUser());
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append(element.getDateCreate());
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append(String.valueOf(((SavingAccount) element).getMoney()));
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append(((SavingAccount) element).getDateOfSaving());
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append(String.valueOf(((SavingAccount) element).getRate()));
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append(String.valueOf(((SavingAccount) element).getMonth()));
                    fileWriter.append(NEW_LINE_SEPARATOR);
                } else if (element instanceof DepositAccount){
                    fileWriter.append(element.getId() + "");
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append(element.getAccountCode());
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append(element.getAccountUser());
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append(element.getDateCreate());
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append(((DepositAccount) element).getCardNumber());
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append(((DepositAccount) element).getAmount() + "");
                    fileWriter.append(NEW_LINE_SEPARATOR);
                }
            }
            System.out.println("Save successfully!");
            System.out.println();
        } catch (Exception e){
            e.printStackTrace();
            System.err.println("Error in CSV File Record");
        } finally {
            try{
                assert fileWriter != null;
                fileWriter.flush();
                fileWriter.close();
            }catch (Exception ex){
                ex.printStackTrace();
                System.err.println("Error while flushing or closing");
            }
        }
    }


    public static List<Account> readFileCSV() {
        BufferedReader br = null;
        ArrayList<Account> list = new ArrayList<>();
        try {
            br = new BufferedReader(new FileReader(FILE_PATH_ACCOUNT));
            String line = "";
            while (line != null) {
                line = br.readLine();
                String[] splitData = line.split(COMMA_DELIMITER);
                if (splitData.length == 8) {
                    SavingAccount account = new SavingAccount();
                    account.setId(Integer.parseInt(splitData[0]));
                    account.setAccountCode(splitData[1]);
                    account.setAccountUser(splitData[2]);
                    account.setDateCreate(splitData[3]);
                    account.setMoney(Double.parseDouble(splitData[4]));
                    account.setDateOfSaving(splitData[5]);
                    account.setRate(Double.parseDouble(splitData[6]));
                    account.setMonth(Integer.parseInt(splitData[7]));
                    list.add(account);
                } else {
                    DepositAccount account = new DepositAccount();
                    account.setId(Integer.parseInt(splitData[0]));
                    account.setAccountCode(splitData[1]);
                    account.setAccountUser(splitData[2]);
                    account.setDateCreate(splitData[3]);
                    account.setCardNumber(splitData[4]);
                    account.setAmount(Double.parseDouble(splitData[5]));
                    list.add(account);
                }

            }
        } catch (Exception e) {
//            System.err.println(e.getMessage());
        } finally {
            try {
                assert br != null;
                br.close();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        return list;
    }
}
