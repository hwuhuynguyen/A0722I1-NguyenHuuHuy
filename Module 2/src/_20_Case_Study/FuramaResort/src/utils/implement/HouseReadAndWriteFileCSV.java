package utils.implement;

import models.facility.House;
import models.facility.Room;
import utils.IHouseReadAndWriteFileCSV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class HouseReadAndWriteFileCSV implements IHouseReadAndWriteFileCSV {
    public static void writeFileCSV(List<House> list){
        FileWriter fileWriter = null;
        try{
            fileWriter = new FileWriter(FILE_PATH_HOUSE);
            fileWriter.append(FILE_HEADER_HOUSE);
            fileWriter.append(NEW_LINE_SEPARATOR);
//            "Service Name,Usable Area,Rental Cost,Max Capacity,Rental Type,Room Standard,Floors";

            for(House house : list){
                fileWriter.append(house.getServiceName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(house.getUsableArea()+"");
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(house.getRentalCost()+"");
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(house.getMaxCapacity()+"");
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(house.getRentalType());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(house.getRoomStandard());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(house.getFloors()+"");
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
        } catch (Exception e){
            System.err.println(e.getMessage());
            System.err.println("Error in CSV File Record");
        } finally {
            try{
                assert fileWriter != null;
                fileWriter.flush();
                fileWriter.close();
            }catch (Exception ex){
                ex.printStackTrace();
                System.err.println("Error while flushing or closing");
            }
        }
    }


    public static List<House> readFileCSV() {
        BufferedReader br = null;
        ArrayList<House> list = new ArrayList<>();
        try {
            br = new BufferedReader(new FileReader(FILE_PATH_HOUSE));
            String line = "";
            while (line != null) {
//                "Service Name,Usable Area,Rental Cost,Max Capacity,Rental Type,Room Standard,Floors";
                line = br.readLine();
                String[] splitData = line.split(COMMA_DELIMITER);
                if (splitData[0].equals("Service Name")) {
                    continue;
                }
                House house = new House();
                house.setServiceName(splitData[0]);
                house.setUsableArea(Double.parseDouble(splitData[1]));
                house.setRentalCost(Double.parseDouble(splitData[2]));
                house.setMaxCapacity(Integer.parseInt((splitData[3])));
                house.setRentalType(splitData[4]);
                house.setRoomStandard(splitData[5]);
                house.setFloors(Integer.parseInt(splitData[6]));
                list.add(house);
            }
        } catch (Exception e) {
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
