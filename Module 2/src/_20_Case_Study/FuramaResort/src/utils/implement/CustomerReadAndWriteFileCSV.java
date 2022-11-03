package utils.implement;

import models.person.Customer;
import utils.ICustomerReadAndWriteFileCSV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class CustomerReadAndWriteFileCSV implements ICustomerReadAndWriteFileCSV {
    public static void writeFileCSV(List<Customer> list){
        FileWriter fileWriter = null;
        try{
            fileWriter = new FileWriter(FILE_PATH_CUSTOMER);
            fileWriter.append(FILE_HEADER_CUSTOMER);
            fileWriter.append(NEW_LINE_SEPARATOR);
            for(Customer element : list){
                fileWriter.append(element.getFullName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(element.getDateOfBirth());
                fileWriter.append(COMMA_DELIMITER);
                if (element.isGender()) {
                    fileWriter.append("Male");
                } else {
                    fileWriter.append("Female");
                }
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(element.getIdentityCard());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(element.getPhoneNumber());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(element.getEmail());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(element.getCustomerID());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(element.getCustomerType());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(element.getAddress());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            System.out.println("Save successfully!");
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


    public static List<Customer> readFileCSV() {
        BufferedReader br = null;
        ArrayList<Customer> list = new ArrayList<Customer>();
        try {
            br = new BufferedReader(new FileReader(FILE_PATH_CUSTOMER));
            String line = "";
            while (line != null) {
                line = br.readLine();
                String[] splitData = line.split(COMMA_DELIMITER);
                if (splitData[0].equals("Full Name")) {
                    continue;
                }
//                "Full Name,Birthday,Gender,ID Card,Phone Number,Email,Customer ID, Customer Type,Address";
                Customer customer = new Customer();
                customer.setFullName(splitData[0]);
                customer.setDateOfBirth(splitData[1]);
                if (splitData[2].equals("Male")) {
                    customer.setGender(true);
                } else {
                    customer.setGender(false);
                }
                customer.setIdentityCard(splitData[3]);
                customer.setPhoneNumber(splitData[4]);
                customer.setEmail(splitData[5]);
                customer.setCustomerID(splitData[6]);
                customer.setCustomerType(splitData[7]);
                customer.setAddress(splitData[8]);
                list.add(customer);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
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
