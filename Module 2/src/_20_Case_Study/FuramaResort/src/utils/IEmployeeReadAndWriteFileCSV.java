package utils;

public interface IEmployeeReadAndWriteFileCSV {
    String COMMA_DELIMITER = ",";
    String NEW_LINE_SEPARATOR = "\n";
    String FILE_HEADER_EMPLOYEE =
            "Full Name,Birthday,Gender,ID Card,Phone Number,Email,Employee ID,Level,Position,Salary";
    String FILE_PATH_EMPLOYEE = "src/data/employee.csv";
}
