package models.booking;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Booking implements Comparable<Booking> {
    private String bookingID;
    private String startDate;
    private String endDate;
    private String customerID;
    private String serviceName;
    private String serviceType;

    public Booking() {

    }

    public Booking(String bookingID, String startDate, String endDate, String customerID, String serviceName, String serviceType) {
        this.bookingID = bookingID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customerID = customerID;
        this.serviceName = serviceName;
        this.serviceType = serviceType;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingID='" + bookingID + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", customerID='" + customerID + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", serviceType='" + serviceType + '\'' +
                '}';
    }

    @Override
    public int compareTo(Booking booking) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date newStartDate = simpleDateFormat.parse(startDate);
            Date newBookingStartDate = simpleDateFormat.parse(booking.startDate);

            Date newEndDate = simpleDateFormat.parse(endDate);
            Date newBookingEndDate = simpleDateFormat.parse(booking.endDate);

            if (!newStartDate.equals(newBookingStartDate)) {
                return newStartDate.compareTo(newBookingStartDate);
            } else {
                return newEndDate.compareTo(newBookingEndDate);
            }
        } catch (ParseException exception) {
            System.err.println(exception.getMessage());
        }
        return 0;
    }
}
