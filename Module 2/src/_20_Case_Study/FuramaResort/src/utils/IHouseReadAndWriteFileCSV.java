package utils;

public interface IHouseReadAndWriteFileCSV {
    String COMMA_DELIMITER = ",";
    String NEW_LINE_SEPARATOR = "\n";
    String FILE_HEADER_HOUSE =
            "Service Name,Usable Area,Rental Cost,Max Capacity,Rental Type,Room Standard,Floors";
    String FILE_PATH_HOUSE = "src/data/house.csv";
}
