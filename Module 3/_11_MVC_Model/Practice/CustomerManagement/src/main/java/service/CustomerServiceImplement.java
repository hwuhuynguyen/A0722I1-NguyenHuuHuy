package service;

import model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImplement implements ICustomerService {
    private static Map<Integer, Customer> customers;

    static {
        customers = new HashMap<>();
        customers.put(1, new Customer(1, "John", "john@codegym.vn", "HaNoi"));
        customers.put(2, new Customer(2, "Bill", "bill@codegym.vn", "HoiAn"));
        customers.put(3, new Customer(3, "Alex", "alex@codegym.vn", "SaiGon"));
        customers.put(4, new Customer(4, "Adam", "adam@codegym.vn", "Beijing"));
        customers.put(5, new Customer(5, "Sophia", "sophia@codegym.vn", "Miami"));
        customers.put(6, new Customer(6, "Rose", "rose@codegym.vn", "NewYork"));
    }

    @Override
    public List<Customer> findAllCustomers() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public void addNewCustomer(Customer customer) {
        customers.put(customer.getId(), customer);
    }

    @Override
    public Customer findCustomerById(int id) {
        return customers.get(id);
    }

    @Override
    public void updateCustomer(int id, Customer customer) {
        customers.put(id, customer);
    }

    @Override
    public void removeCustomer(int id) {
        customers.remove(id);
    }
}
