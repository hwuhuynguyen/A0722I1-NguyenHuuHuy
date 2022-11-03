package models.person;

import java.util.Date;

public class Employee extends Person {
    private String employeeID;
    private String level;
    private String position;
    private double salary;

    public Employee() {
        super();
    }
    public Employee(String fullName, String dateOfBirth, boolean gender, String identityCard, String phoneNumber,
                    String email, String employeeID, String level, String position, double salary) {
        super(fullName, dateOfBirth, gender, identityCard, phoneNumber, email);
        this.employeeID = employeeID;
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        if (isGender()) {
            return "Employee{" +
                    "fullName='" + getFullName() + '\'' +
                    ", dateOfBirth=" + getDateOfBirth() +
                    ", gender=" + "male" +
                    ", identityCard='" + getIdentityCard() + '\'' +
                    ", phoneNumber='" + getPhoneNumber() + '\'' +
                    ", email='" + getEmail() + '\'' +
                    ", employeeID='" + employeeID + '\'' +
                    ", level='" + level + '\'' +
                    ", position='" + position + '\'' +
                    ", salary=" + salary +
                    '}';
        } else {
            return "Employee{" +
                    "fullName='" + getFullName() + '\'' +
                    ", dateOfBirth=" + getDateOfBirth() +
                    ", gender=" + "female" +
                    ", identityCard='" + getIdentityCard() + '\'' +
                    ", phoneNumber='" + getPhoneNumber() + '\'' +
                    ", email='" + getEmail() + '\'' +
                    ", employeeID='" + employeeID + '\'' +
                    ", level='" + level + '\'' +
                    ", position='" + position + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }
}
