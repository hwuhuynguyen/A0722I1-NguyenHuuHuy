package com.example.service;

import com.example.model.Motel;

import java.util.List;

public interface IMotelService {
    List<Motel> getAllMotels();
    List<Motel> getAllMotelsNotDeleted();
    Motel findMotelById(String roomId);
    void insertNewMotel(Motel motel);
    void updateMotel(Motel motel);
    void deleteMotelById(String roomId);
    String autoIncreaseId();

    String formatDate(String date);
}
