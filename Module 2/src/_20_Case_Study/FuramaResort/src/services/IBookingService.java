package services;

public interface IBookingService extends IService {
    void addNewBooking();

    boolean validateDate(String date);
}
