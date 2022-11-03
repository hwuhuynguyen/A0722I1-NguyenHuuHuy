package services;

import models.person.Customer;

import java.util.List;

public interface ICustomerService extends IService {
    List findAll();

    void addNewCustomer();

    void updateCustomer(String customerID);

    Customer enterCustomerInfo();

    boolean validateDateOfBirth(String dateOfBirth);

    boolean validateAge(String dateOfBirth);

}
