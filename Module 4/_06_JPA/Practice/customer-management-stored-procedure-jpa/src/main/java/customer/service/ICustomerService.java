package customer.service;

import customer.model.Customer;

public interface ICustomerService {
    boolean insertWithStoredProcedure(Customer customer);
}
