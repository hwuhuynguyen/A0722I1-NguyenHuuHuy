package com.service;

import com.model.Smartphone;

import java.util.List;
import java.util.Optional;

public interface ISmartphoneService {
    List<Smartphone> findAll();

    Optional<Smartphone> findById(Long id);

    Smartphone save(Smartphone smartPhone);

    void remove(Long id);
}
