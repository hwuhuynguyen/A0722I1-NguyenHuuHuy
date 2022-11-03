package utils;

public interface IVillaReadAndWriteFileCSV {
    String COMMA_DELIMITER = ",";
    String NEW_LINE_SEPARATOR = "\n";
    String FILE_HEADER_VILLA =
            "Service Name,Usable Area,Rental Cost,Max Capacity,Rental Type,Room Standard,Pool Area,Floors";
    String FILE_PATH_VILLA = "src/data/villa.csv";
}
