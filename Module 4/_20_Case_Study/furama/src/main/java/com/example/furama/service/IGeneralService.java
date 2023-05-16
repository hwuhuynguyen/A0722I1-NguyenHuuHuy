package com.example.furama.service;

import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();

    Optional<T> findById(String id);

    void save(T t);

    void remove(String id);
}
