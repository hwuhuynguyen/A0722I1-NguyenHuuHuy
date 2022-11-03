package services;

import java.util.List;
import java.util.Map;

public interface IFacilityService extends IService {
    Map<String, List> findAll();

    void addNewService();

    void addNewVillaDetail();

    void addNewHouseDetail();

    void addNewRoomDetail();

    String getServiceNameByServiceType(String serviceType);

    boolean validateArea(double area);

    boolean validateRentalCost(double rentalCost);

    boolean validateMaxCapacity(int maxCapacity);

    boolean validateNumberOfFloors(int floors);
}
