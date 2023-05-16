package com.example.furama.service;

import codegym.vn.springboot.entity.ClassName;
import codegym.vn.springboot.entity.Student;

import java.util.List;

public interface ClassNameService {
    void create(ClassName className);
    void update(ClassName className);
    void delete(String id);
    List<ClassName> findAll();
    ClassName findById(String id);
}
