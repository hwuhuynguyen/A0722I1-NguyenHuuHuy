package com.example.motelmanagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.Date;

@Entity
@Table(name = "motel")
public class Motel {
    @Id
    private String id;
    @NotBlank(message = "Vui lòng nhập tên người thuê")
    @Pattern(regexp = "^[^\\d\\W_]+(?:\\s+[^\\d\\W_]+)+$", message = "Tên người thuê chỉ được chứa chữ cái")
    private String customerName;
    @NotBlank(message = "Vui lòng nhập số điện thoại")
    @Size(min = 10, max = 10, message = "Số điện thoại phải độ dài bằng 10")
    @Pattern(regexp = "^0\\d{9}$", message = "Số điện thoại phải bắt đầu bằng số '0' và chỉ gồm các chữ số")
    private String phoneNumber;
    @NotNull(message = "Vui lòng nhập ngày thuê phòng")
    private Date startedDate;
    @ManyToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;
    private String note;
    private boolean isDeleted;

    public Motel() {
    }

    public Motel(String id, String customerName, String phoneNumber, Date startedDate, Payment payment, String note) {
        this.id = id;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.startedDate = startedDate;
        this.payment = payment;
        this.note = note;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Date getStartedDate() {
        return startedDate;
    }

    public void setStartedDate(Date startedDate) {
        this.startedDate = startedDate;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public String toString() {
        return "Motel{" +
                "id='" + id + '\'' +
                ", customerName='" + customerName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", startedDate=" + startedDate +
                ", payment=" + payment +
                ", note='" + note + '\'' +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
