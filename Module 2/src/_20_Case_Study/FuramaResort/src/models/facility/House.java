package models.facility;

import models.facility.Facility;

public class House extends Facility {
    private String roomStandard;
    private int floors;

    public House() {

    }
    public House(String serviceName, double usableArea, double rentalCost, int maxCapacity,
                 String rentalType, String roomStandard, int floors) {
        super(serviceName, usableArea, rentalCost, maxCapacity, rentalType);
        this.roomStandard = roomStandard;
        this.floors = floors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    @Override
    public String toString() {
        return "House{" +
                "serviceName='" + getServiceName() + '\'' +
                ", usableArea=" + getUsableArea() +
                ", rentalCost=" + getRentalCost() +
                ", maxCapacity=" + getMaxCapacity() +
                ", rentalType='" + getRentalType() + '\'' +
                ", roomStandard='" + roomStandard + '\'' +
                ", floors=" + floors +
                '}';
    }
}
