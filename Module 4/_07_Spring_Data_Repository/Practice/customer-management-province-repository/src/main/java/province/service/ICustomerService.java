package province.service;

import province.model.Customer;
import province.model.Province;

public interface ICustomerService extends IGeneralService<Customer> {
    Iterable<Customer> findAllByProvince(Province province);

}
