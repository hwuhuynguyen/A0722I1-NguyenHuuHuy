package utils;

public interface ICustomerReadAndWriteFileCSV {
    String COMMA_DELIMITER = ",";
    String NEW_LINE_SEPARATOR = "\n";
    String FILE_HEADER_CUSTOMER =
            "Full Name,Birthday,Gender,ID Card,Phone Number,Email,Customer ID, Customer Type,Address";
    String FILE_PATH_CUSTOMER = "src/data/customer.csv";
}
