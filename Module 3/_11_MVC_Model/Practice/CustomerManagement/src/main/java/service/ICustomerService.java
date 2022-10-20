package service;

import model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAllCustomers();

    void addNewCustomer(Customer customer);

    Customer findCustomerById(int id);

    void updateCustomer(int id, Customer customer);

    void removeCustomer(int id);
}
