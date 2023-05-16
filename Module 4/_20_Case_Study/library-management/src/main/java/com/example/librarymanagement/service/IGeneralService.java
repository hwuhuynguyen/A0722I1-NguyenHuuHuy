package com.example.librarymanagement.service;

import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();
    Optional<T> findById(String id);
    void save(T t);
    void removeById(String id);
}
