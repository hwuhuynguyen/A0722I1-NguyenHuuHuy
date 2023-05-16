package com.example.motelmanagement.service;

import com.example.motelmanagement.entity.Motel;
import com.example.motelmanagement.entity.Payment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IMotelService extends IGeneralService<Motel> {
    Iterable<Motel> findAvailableMotels();
    Iterable<Motel> searchByCustomerNameContainingIgnoreCase(String keyword);
    Iterable<Motel> searchAvailableMotelsByPaymentMethod(Payment payment);
    Iterable<Motel> findAvailableMotelsByIdIn(String[] ids);
}
