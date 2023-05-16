package com.example.motelmanagement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "payment")
public class Payment {
    @Id
    private String id;
    private String paymentMethod;

    @JsonBackReference
    @OneToMany(mappedBy = "payment", fetch = FetchType.LAZY)
    private Set<Motel> motelList;

    public Payment() {
    }

    public Payment(String id, String paymentMethod, Set<Motel> motelList) {
        this.id = id;
        this.paymentMethod = paymentMethod;
        this.motelList = motelList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Set<Motel> getMotelList() {
        return motelList;
    }

    public void setMotelList(Set<Motel> motelList) {
        this.motelList = motelList;
    }
}
