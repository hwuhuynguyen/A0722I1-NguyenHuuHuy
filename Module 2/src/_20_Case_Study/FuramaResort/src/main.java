import services.implement.CustomerServiceImplement;
import services.implement.EmployeeServiceImplement;
import services.implement.FacilityServiceImplement;

import java.util.Locale;

public class main {
    public static void main(String[] args) {
//        CustomerServiceImplement customerServiceImplement = new CustomerServiceImplement();
//        EmployeeServiceImplement employeeServiceImplement = new EmployeeServiceImplement();
//        FacilityServiceImplement facilityServiceImplement = new FacilityServiceImplement();
//        customerServiceImplement.displayAll();
//        customerServiceImplement.addNewCustomer();
//        customerServiceImplement.displayAll();
//
//        employeeServiceImplement.addNewEmployee();
//        employeeServiceImplement.displayAll();
//        customerServiceImplement.updateCustomer("KH001");
//        customerServiceImplement.displayAll();
//        facilityServiceImplement.displayAll();

        CustomerServiceImplement customerServiceImplement = new CustomerServiceImplement();
        customerServiceImplement.validateAge("03-11-2004");
    }
}
