package services.implement;

import models.person.Customer;
import services.ICustomerService;
import utils.implement.CustomerReadAndWriteFileCSV;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class CustomerServiceImplement implements ICustomerService {
    private static List<Customer> customerList = new LinkedList<>();
    private static int totalCustomer = 0;
    static {
        customerList = CustomerReadAndWriteFileCSV.readFileCSV();
        totalCustomer = customerList.size();
    }
//    static {
//        customerList.add(new Customer("Nguyen Van A", ("03-12-2002"), false,
//                "11223344", "0123456789", "customer1@gmail.com", "KH001",
//                "Diamond", "Hanoi"));
//        customerList.add(new Customer("Nguyen Van B", ("12-06-2002"), true,
//                "11223344", "0123456789", "customer1@gmail.com", "KH002",
//                "Gold", "HoiAn"));
//        customerList.add(new Customer("Nguyen Van C", ("03-02-2009"), true,
//                "11223344", "0123456789", "customer1@gmail.com", "KH003",
//                "Silver", "Nha Trang"));
//        customerList.add(new Customer("Nguyen Van D", ("01-01-2005"), false,
//                "11223344", "0123456789", "customer1@gmail.com", "KH004",
//                "Member", "Da Nang"));
//    }

    @Override
    public List findAll() {
        return customerList;
    }

    @Override
    public void displayAll() {
        System.out.println("List of customers: ");
        for (Customer customer : customerList) {
            System.out.println(customer.toString());
        }
    }

    @Override
    public void addNewCustomer() {
        Customer customer = enterCustomerInfo();
        String fullName = customer.getFullName();
        String dateOfBirth = customer.getDateOfBirth();
        boolean gender = customer.isGender();
        String identityCard = customer.getIdentityCard();
        String phoneNumber = customer.getPhoneNumber();
        String email = customer.getEmail();
        String customerID = customer.getCustomerID();
        String customerType = customer.getCustomerType();
        String address = customer.getAddress();

        Customer newCustomer = new Customer(fullName, dateOfBirth, gender, identityCard, phoneNumber,
                email, customerID, customerType, address);

        if (totalCustomer < 9) {
            newCustomer.setCustomerID("KH00" + (++totalCustomer));
        } else {
            newCustomer.setCustomerID("KH0" + (++totalCustomer));
        }
        customerList.add(newCustomer);
        CustomerReadAndWriteFileCSV.writeFileCSV(customerList);
    }

    @Override
    public void updateCustomer(String customerID) {
        boolean check = false;
        for (Customer customer : customerList) {
            if (customer.getCustomerID().equals(customerID)) {
                check = true;
                Customer newCustomer = enterCustomerInfo();

                customer.setFullName(newCustomer.getFullName());
                customer.setDateOfBirth(newCustomer.getDateOfBirth());
                customer.setGender(newCustomer.isGender());
                customer.setIdentityCard(newCustomer.getIdentityCard());
                customer.setPhoneNumber(newCustomer.getPhoneNumber());
                customer.setEmail(newCustomer.getEmail());
                customer.setCustomerID(customerID);
                customer.setCustomerType(newCustomer.getCustomerType());
                customer.setAddress(newCustomer.getAddress());
            }
            CustomerReadAndWriteFileCSV.writeFileCSV(customerList);
        }
        if (!check) {
            System.err.println("Invalid customer ID, please try again!!!");
        }
    }

    @Override
    public Customer enterCustomerInfo() {
        Scanner scanner = new Scanner(System.in);
        Customer customer;
        System.out.print("Enter new customer full name: ");
        String newName = scanner.nextLine();
        String newDateOfBirth = null;
        do {
            System.out.print("Enter new customer's date of birth (dd-MM-yyyy): ");
            newDateOfBirth = scanner.nextLine();
            if (!validateDateOfBirth(newDateOfBirth)) {
                System.err.println("Invalid date of birth, please try again!!");
            }
            if (!validateAge(newDateOfBirth)) {
                System.err.println("Your age must be larger than 18 and smaller than 100!!!");
            }
        } while (!validateDateOfBirth(newDateOfBirth) || !validateAge(newDateOfBirth));
        System.out.print("Enter new customer's gender (male = true; female = false): ");
        boolean newGender = Boolean.parseBoolean(scanner.nextLine());
        System.out.print("Enter new customer's identity card: ");
        String newIdentityCard = scanner.nextLine();
        System.out.print("Enter new customer's phone number: ");
        String newPhoneNumber = scanner.nextLine();
        System.out.print("Enter new customer's email: ");
        String newEmail = scanner.nextLine();
        System.out.print("Enter new customer's customer type: ");
        String newCustomerType = scanner.nextLine();
        System.out.print("Enter new customer's address: ");
        String newAddress = scanner.nextLine();

        customer = new Customer(newName, (newDateOfBirth), (boolean) (newGender), newIdentityCard,
                newPhoneNumber, newEmail, "KH", newCustomerType, newAddress);
        return customer;
    }

    @Override
    public boolean validateDateOfBirth(String dateOfBirth) {
        LocalDateTime localDateTime;
        String pattern = "dd-MM-yyyy";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, Locale.ENGLISH);
        try {
            localDateTime = LocalDateTime.parse(dateOfBirth, formatter);
            String result = localDateTime.format(formatter);
            return result.equals(dateOfBirth);
        } catch (DateTimeParseException e) {
            try {
                LocalDate localDate = LocalDate.parse(dateOfBirth, formatter);
                String result = localDate.format(formatter);
                return result.equals(dateOfBirth);
            } catch (DateTimeParseException exception) {
                try {
                    LocalTime localTime = LocalTime.parse(dateOfBirth, formatter);
                    String result = localTime.format(formatter);
                    return result.equals(dateOfBirth);
                } catch (DateTimeParseException ignored) {
                }
            }
        }
        return false;
    }

    @Override
    public boolean validateAge(String dateOfBirth) {
        String pattern = "dd-MM-yyyy";
        int age = 0;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, Locale.ENGLISH);
        try {
            LocalDate newDateOfBirth = LocalDate.parse(dateOfBirth, formatter);
            age = Period.between(newDateOfBirth, LocalDate.now()).getYears();
        } catch (Exception exception) {

        }
        return (age >= 18 && age <= 100);
    }

    public static void displayCustomerMainInfo() {
        System.out.println("Display customers 's main information");
        for (Customer customer : customerList) {
            System.out.println(customer.displayMainInfo());
        }
    }

}
