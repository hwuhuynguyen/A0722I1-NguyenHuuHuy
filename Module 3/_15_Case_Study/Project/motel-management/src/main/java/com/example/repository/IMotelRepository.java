package com.example.repository;

import com.example.model.Motel;

import java.util.List;

public interface IMotelRepository {
    List<Motel> getAllMotels();
    List<Motel> getAllMotelsNotDeleted();
    Motel findMotelById(String roomId);
    void insertNewMotel(Motel motel);
    void updateMotel(Motel motel);
    void deleteMotelById(String roomId);
}
