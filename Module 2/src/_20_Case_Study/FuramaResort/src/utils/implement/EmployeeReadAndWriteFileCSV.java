package utils.implement;

import models.person.Employee;
import utils.IEmployeeReadAndWriteFileCSV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class EmployeeReadAndWriteFileCSV implements IEmployeeReadAndWriteFileCSV {
//    @Override
    public static void writeFileCSV(List<Employee> list){
        FileWriter fileWriter = null;
        try{
            fileWriter = new FileWriter(FILE_PATH_EMPLOYEE);
            fileWriter.append(FILE_HEADER_EMPLOYEE);
            fileWriter.append(NEW_LINE_SEPARATOR);
            for(Employee element : list){
                fileWriter.append(element.getFullName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(element.getDateOfBirth());
                fileWriter.append(COMMA_DELIMITER);
                if (element.isGender()) {
                    fileWriter.append("Male");
                } else {
                    fileWriter.append("Female");
                }
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(element.getIdentityCard());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(element.getPhoneNumber());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(element.getEmail());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(element.getEmployeeID());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(element.getLevel());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(element.getPosition());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(element.getSalary()));
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            System.out.println("Saved successfully!");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Error in CSV File Record");
        } finally {
            try{
                assert fileWriter != null;
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception ex){
                ex.printStackTrace();
                System.out.println("Error while flushing or closing");
            }
        }
    }

//    @Override
    public static List<Employee> readFileCSV() {
        BufferedReader br = null;
        List<Employee> list = new ArrayList<>();
        try {
            br = new BufferedReader(new FileReader(FILE_PATH_EMPLOYEE));
            String line = "";
            while (line != null) {
                line = br.readLine();
                String[] splitData = line.split(COMMA_DELIMITER);
                if (splitData[0].equals("Full Name")) {
                    continue;
                }
//                "Full Name,Birthday,Gender,ID Card,Phone Number,Email,Employee ID,Level,Position,Salary,";
                Employee employee = new Employee();
                employee.setFullName(splitData[0]);
                employee.setDateOfBirth(splitData[1]);
                if (splitData[2].equals("Male")) {
                    employee.setGender(true);
                } else {
                    employee.setGender(false);
                }
                employee.setIdentityCard(splitData[3]);
                employee.setPhoneNumber(splitData[4]);
                employee.setEmail(splitData[5]);
                employee.setEmployeeID(splitData[6]);
                employee.setLevel(splitData[7]);
                employee.setPosition(splitData[8]);
                employee.setSalary(Double.parseDouble(splitData[9]));
                list.add(employee);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                assert br != null;
                br.close();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        return list;
    }
}
