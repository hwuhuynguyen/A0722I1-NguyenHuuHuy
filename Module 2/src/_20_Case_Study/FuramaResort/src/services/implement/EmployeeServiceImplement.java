package services.implement;

import models.person.Employee;
import services.IEmployeeService;
import utils.implement.EmployeeReadAndWriteFileCSV;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class EmployeeServiceImplement implements IEmployeeService {
    private static List<Employee> employeeList = new ArrayList<>();
    private static int totalEmployee = 0;
    static {
        employeeList = EmployeeReadAndWriteFileCSV.readFileCSV();
        totalEmployee = employeeList.size();
    }
//    static {
//        employeeList.add(new Employee("Nguyen Van A", ("03-12-2002"), false,
//                "11223344", "0123456789", "employee1@gmail.com", "NV001",
//                "Intern", "Finance", 1000));
//        employeeList.add(new Employee("Nguyen Van B", ("10-02-2002"), true,
//                "11223344", "0123456789", "employee2@gmail.com", "NV002",
//                "Fresher", "IT", 2000));
//        employeeList.add(new Employee("Nguyen Van C", ("25-06-2002"), false,
//                "11223344", "0123456789", "employee3@gmail.com", "NV003",
//                "Junior", "Security", 3000));
//        employeeList.add(new Employee("Nguyen Van D", ("22-01-2002"), false,
//                "11223344", "0123456789", "employee4@gmail.com", "NV004",
//                "Middle", "Planning", 4000));
//    }
    @Override
    public List findAll() {
        return employeeList;
    }

    @Override
    public void displayAll() {
        System.out.println("List of employees: ");
        for (Employee employee : employeeList) {
            System.out.println(employee.toString());
        }
    }

    @Override
    public void addNewEmployee() {
        Employee employee = enterEmployeeInfo();
        String fullName = employee.getFullName();
        String dateOfBirth = employee.getDateOfBirth();
        boolean gender = employee.isGender();
        String identityCard = employee.getIdentityCard();
        String phoneNumber = employee.getPhoneNumber();
        String email = employee.getEmail();
        String employeeID = employee.getEmployeeID();
        String level = employee.getLevel();
        String position = employee.getPosition();
        double salary = employee.getSalary();

        Employee newEmployee = new Employee(fullName, dateOfBirth, gender, identityCard, phoneNumber,
                email, employeeID, level, position, salary);

        if (totalEmployee < 9) {
            newEmployee.setEmployeeID("NV00" + (++totalEmployee));
        } else {
            newEmployee.setEmployeeID("NV0" + (++totalEmployee));
        }
        employeeList.add(newEmployee);
        EmployeeReadAndWriteFileCSV.writeFileCSV(employeeList);
    }

    @Override
    public void updateEmployee(String employeeID) {
        boolean check = false;
        for (Employee employee : employeeList) {
            if (employee.getEmployeeID().equals(employeeID)) {
                check = true;
                Employee newEmployee = enterEmployeeInfo();

                employee.setFullName(newEmployee.getFullName());
                employee.setDateOfBirth(newEmployee.getDateOfBirth());
                employee.setGender(newEmployee.isGender());
                employee.setIdentityCard(newEmployee.getIdentityCard());
                employee.setPhoneNumber(newEmployee.getPhoneNumber());
                employee.setEmail(newEmployee.getEmail());
                employee.setEmployeeID(employeeID);
                employee.setLevel(newEmployee.getLevel());
                employee.setPosition(newEmployee.getPosition());
                employee.setSalary(newEmployee.getSalary());
            }
            EmployeeReadAndWriteFileCSV.writeFileCSV(employeeList);
        }
        if (!check) {
            System.out.println("Invalid employee ID, please try again!!!");
        }
    }

    @Override
    public Employee enterEmployeeInfo() {
        Scanner scanner = new Scanner(System.in);
        Employee employee;
        System.out.print("Enter new employee full name: ");
        String newName = scanner.nextLine();
        String newDateOfBirth = null;
        do {
            System.out.print("Enter new employee's date of birth (dd-MM-yyyy): ");
            newDateOfBirth = scanner.nextLine();
            if (!validateDateOfBirth(newDateOfBirth)) {
                System.err.println("Invalid date of birth, please try again!!!");
            }
            if (!validateAge(newDateOfBirth)) {
                System.err.println("Your age must be larger than 18 and smaller than 100!!!");
            }
        } while (!validateDateOfBirth(newDateOfBirth) || !validateAge(newDateOfBirth));
        System.out.print("Enter new employee's gender (male = true; female = false): ");
        boolean newGender = Boolean.parseBoolean(scanner.nextLine());
        System.out.print("Enter new employee's identity card: ");
        String newIdentityCard = scanner.nextLine();
        System.out.print("Enter new employee's phone number: ");
        String newPhoneNumber = scanner.nextLine();
        System.out.print("Enter new employee's email: ");
        String newEmail = scanner.nextLine();
        System.out.print("Enter new employee's level: ");
        String newLevel = scanner.nextLine();
        System.out.print("Enter new employee's position: ");
        String newPosition = scanner.nextLine();
        System.out.print("Enter new employee's salary: ");
        double newSalary = scanner.nextDouble();

        employee = new Employee(newName, (newDateOfBirth), (boolean) (newGender), newIdentityCard,
                newPhoneNumber, newEmail, "NV", newLevel, newPosition, newSalary);
        return employee;
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
}
