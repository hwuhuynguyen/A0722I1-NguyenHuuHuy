package com.example.furama.service;

import com.example.furama.entity.Class;
import com.example.furama.repository.IClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClassService implements IClassService {
    @Autowired
    private IClassRepository classRepository;

    @Override
    public Iterable<Class> findAll() {
        return classRepository.findAll();
    }

    @Override
    public Optional<Class> findById(String id) {
        return classRepository.findById(id);
    }

    @Override
    public void save(Class aClass) {
        classRepository.save(aClass);
    }

    @Override
    public void remove(String id) {
        classRepository.deleteById(id);
    }
}
