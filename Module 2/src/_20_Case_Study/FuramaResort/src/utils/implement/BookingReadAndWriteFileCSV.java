package utils.implement;

import models.booking.Booking;
import utils.IBookingReadAndWriteFileCSV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeSet;

public class BookingReadAndWriteFileCSV implements IBookingReadAndWriteFileCSV {
    public static void writeFileCSV(TreeSet<Booking> bookings) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(FILE_PATH_BOOKING);
            fileWriter.append(FILE_HEADER_BOOKING);
            fileWriter.append(NEW_LINE_SEPARATOR);
            for (Booking booking : bookings) {
                fileWriter.append(booking.getBookingID());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(booking.getStartDate());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(booking.getEndDate());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(booking.getCustomerID());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(booking.getServiceName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(booking.getServiceType());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
        } catch (IOException exception) {
            System.err.println(exception.getMessage());
        } finally {
            try{
                assert fileWriter != null;
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception ex){
                ex.printStackTrace();
                System.err.println("Error while flushing or closing");
            }
        }
    }
    public static TreeSet<Booking> readFileCSV() {
        BufferedReader bufferedReader = null;
        TreeSet<Booking> bookingTreeSet = new TreeSet<>();
        try {
            bufferedReader = new BufferedReader(new FileReader(FILE_PATH_BOOKING));
            String line = "";
            while (line != null) {
                line = bufferedReader.readLine();
                String[] splitData = line.split(COMMA_DELIMITER);
                if (splitData[0].equals("Booking ID")) {
                    continue;
                }
//                "Booking ID,Start Date,End Date,Customer ID,Service Name,Service Type"
                Booking newBooking = new Booking();
                newBooking.setBookingID(splitData[0]);
                newBooking.setStartDate(splitData[1]);
                newBooking.setEndDate(splitData[2]);
                newBooking.setCustomerID(splitData[3]);
                newBooking.setServiceName(splitData[4]);
                newBooking.setServiceType(splitData[5]);
                bookingTreeSet.add(newBooking);
            }
        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        } finally {
            try {
                assert bufferedReader != null;
                bufferedReader.close();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        return bookingTreeSet;
    }
}
