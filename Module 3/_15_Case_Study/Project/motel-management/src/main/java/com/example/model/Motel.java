package com.example.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Motel {
    private String roomId;
    private String customerName;
    private String phoneNumber;
    private String startDay;
    private int paymentMethod;
    private String note;

    public Motel() {
    }

    public Motel(String customerName, String phoneNumber, String startDay, int paymentMethod, String note) {
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.startDay = startDay;
        this.paymentMethod = paymentMethod;
        this.note = note;
    }

    public Motel(String roomId, String customerName, String phoneNumber, String startDay, int paymentMethod, String note) {
        this.roomId = roomId;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.startDay = startDay;
        this.paymentMethod = paymentMethod;
        this.note = note;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public int getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(int paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Motel{" +
                "roomId='" + roomId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", startDay='" + startDay + '\'' +
                ", paymentMethod=" + paymentMethod +
                ", note='" + note + '\'' +
                '}';
    }

    public String getStartDayFormatted() {
        List<String> split = new ArrayList<>(List.of(startDay.split("-")));
        return split.get(2) + "-" + split.get(1) + "-" + split.get(0);
    }
}
