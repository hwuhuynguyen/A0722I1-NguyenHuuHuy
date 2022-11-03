package models.facility;

import models.facility.Facility;

public class Villa extends Facility {
    private String roomStandard;
    private double poolArea;
    private int floors;

    public Villa() {

    }
    public Villa(String serviceName, double usableArea, double rentalCost, int maxCapacity,
                 String rentalType, String roomStandard, double poolArea, int floors) {
        super(serviceName, usableArea, rentalCost, maxCapacity, rentalType);
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.floors = floors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    @Override
    public String toString() {
        return "Villa{" +
                "serviceName='" + getServiceName() + '\'' +
                ", usableArea=" + getUsableArea() +
                ", rentalCost=" + getRentalCost() +
                ", maxCapacity=" + getMaxCapacity() +
                ", rentalType='" + getRentalType() + '\'' +
                ", roomStandard='" + roomStandard + '\'' +
                ", poolArea=" + poolArea +
                ", floors=" + floors +
                '}';
    }
}
