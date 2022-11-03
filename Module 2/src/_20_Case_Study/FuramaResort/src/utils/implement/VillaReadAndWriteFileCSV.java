package utils.implement;

import models.facility.House;
import models.facility.Villa;
import utils.IVillaReadAndWriteFileCSV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class VillaReadAndWriteFileCSV implements IVillaReadAndWriteFileCSV {
    public static void writeFileCSV(List<Villa> list){
        FileWriter fileWriter = null;
        try{
            fileWriter = new FileWriter(FILE_PATH_VILLA);
            fileWriter.append(FILE_HEADER_VILLA);
            fileWriter.append(NEW_LINE_SEPARATOR);
//            "Service Name,Usable Area,Rental Cost,Max Capacity,Rental Type,Room Standard,Pool Area,Floors";
            for(Villa villa : list){
                fileWriter.append(villa.getServiceName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(villa.getUsableArea()+"");
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(villa.getRentalCost()+"");
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(villa.getMaxCapacity()+"");
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(villa.getRentalType());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(villa.getRoomStandard());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(villa.getPoolArea()+"");
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(villa.getFloors()+"");
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


    public static List<Villa> readFileCSV() {
        BufferedReader br = null;
        ArrayList<Villa> list = new ArrayList<>();
        try {
            br = new BufferedReader(new FileReader(FILE_PATH_VILLA));
            String line = "";
            while (line != null) {
//                "Service Name,Usable Area,Rental Cost,Max Capacity,Rental Type,Room Standard,Pool Area,Floors";
                line = br.readLine();
                String[] splitData = line.split(COMMA_DELIMITER);
                if (splitData[0].equals("Service Name")) {
                    continue;
                }
                Villa villa = new Villa();
                villa.setServiceName(splitData[0]);
                villa.setUsableArea(Double.parseDouble(splitData[1]));
                villa.setRentalCost(Double.parseDouble(splitData[2]));
                villa.setMaxCapacity(Integer.parseInt((splitData[3])));
                villa.setRentalType(splitData[4]);
                villa.setRoomStandard(splitData[5]);
                villa.setPoolArea(Double.parseDouble(splitData[6]));
                villa.setFloors(Integer.parseInt(splitData[7]));
                list.add(villa);
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
