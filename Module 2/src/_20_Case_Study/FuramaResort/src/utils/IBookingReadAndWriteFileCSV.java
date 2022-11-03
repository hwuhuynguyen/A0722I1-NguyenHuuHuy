package utils;

public interface IBookingReadAndWriteFileCSV {
    String COMMA_DELIMITER = ",";
    String NEW_LINE_SEPARATOR = "\n";
    String FILE_HEADER_BOOKING =
            "Booking ID,Start Date,End Date,Customer ID,Service Name,Service Type";
    String FILE_PATH_BOOKING = "src/data/booking.csv";
}
