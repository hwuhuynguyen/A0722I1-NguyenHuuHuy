package customer_management.service;

import customer_management.service.implement.SimpleCustomerServiceImplement;

public class CustomerServiceFactory {
    private static ICustomerService singleton;

    public static synchronized ICustomerService getInstance() {
        if (singleton == null) {
            singleton = new SimpleCustomerServiceImplement();
        }
        return singleton;
    }
}
