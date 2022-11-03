package models.facility;

import models.facility.Facility;

public class Room extends Facility {
    private String freeServiceIncluded;

    public Room() {

    }
    public Room(String serviceName, double usableArea, double rentalCost, int maxCapacity,
                String rentalType, String freeServiceIncluded) {
        super(serviceName, usableArea, rentalCost, maxCapacity, rentalType);
        this.freeServiceIncluded = freeServiceIncluded;
    }

    public String getFreeServiceIncluded() {
        return freeServiceIncluded;
    }

    public void setFreeServiceIncluded(String freeServiceIncluded) {
        this.freeServiceIncluded = freeServiceIncluded;
    }

    @Override
    public String toString() {
        return "Room{" +
                "serviceName='" + getServiceName() + '\'' +
                ", usableArea=" + getUsableArea() +
                ", rentalCost=" + getRentalCost() +
                ", maxCapacity=" + getMaxCapacity() +
                ", rentalType='" + getRentalType() + '\'' +
                ", freeServiceIncluded='" + freeServiceIncluded + '\'' +
                '}';
    }
}
