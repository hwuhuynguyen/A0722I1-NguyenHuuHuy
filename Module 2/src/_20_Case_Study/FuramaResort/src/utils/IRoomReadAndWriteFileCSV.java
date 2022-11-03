package utils;

public interface IRoomReadAndWriteFileCSV {
    String COMMA_DELIMITER = ",";
    String NEW_LINE_SEPARATOR = "\n";
    String FILE_HEADER_ROOM =
            "Service Name,Usable Area,Rental Cost,Max Capacity,Rental Type,Free Service Included";
    String FILE_PATH_ROOM = "src/data/room.csv";
}
