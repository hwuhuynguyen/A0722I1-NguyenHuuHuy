package com.example.motelmanagement.service;

import com.example.motelmanagement.entity.Motel;
import com.example.motelmanagement.entity.Payment;
import com.example.motelmanagement.repository.IMotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MotelService implements IMotelService {
    @Autowired
    private IMotelRepository motelRepository;

    @Override
    public Iterable<Motel> findAll() {
        return motelRepository.findAll();
    }

    @Override
    public Optional<Motel> findById(String id) {
        return motelRepository.findById(id);
    }

    @Override
    public void save(Motel motel) {
        motelRepository.save(motel);
    }

    @Override
    public void remove(String id) {
        motelRepository.deleteById(id);
    }

    @Override
    public Iterable<Motel> findAvailableMotels() {
        return motelRepository.findAvailableMotels();
    }

    @Override
    public Iterable<Motel> searchByCustomerNameContainingIgnoreCase(String keyword) {
        return motelRepository.searchByCustomerNameContainingIgnoreCase(keyword);
    }

    @Override
    public Iterable<Motel> searchAvailableMotelsByPaymentMethod(Payment payment) {
        return motelRepository.searchAvailableMotelsByPaymentMethod(payment);
    }

    @Override
    public Iterable<Motel> findAvailableMotelsByIdIn(String[] ids) {
        return motelRepository.findAvailableMotelsByIdIn(ids);
    }
}
