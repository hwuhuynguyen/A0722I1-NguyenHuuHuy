package services;

import models.person.Employee;

import java.util.List;

public interface IEmployeeService extends IService {
    List findAll();

    void addNewEmployee();

    void updateEmployee(String employeeID);

    Employee enterEmployeeInfo();

    boolean validateDateOfBirth(String dateOfBirth);

    boolean validateAge(String dateOfBirth);

}
