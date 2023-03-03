package com.example.service;

import com.example.model.Motel;
import com.example.repository.IMotelRepository;
import com.example.repository.MotelRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MotelService implements IMotelService {
    private static final IMotelRepository iMotelRepository = new MotelRepository();

    @Override
    public List<Motel> getAllMotels() {
        return iMotelRepository.getAllMotels();
    }

    @Override
    public List<Motel> getAllMotelsNotDeleted() {
        return iMotelRepository.getAllMotelsNotDeleted();
    }

    @Override
    public Motel findMotelById(String roomId) {
        return iMotelRepository.findMotelById(roomId);
    }

    @Override
    public void insertNewMotel(Motel motel) {
        iMotelRepository.insertNewMotel(motel);
    }

    @Override
    public void updateMotel(Motel motel) {
        iMotelRepository.updateMotel(motel);
    }

    @Override
    public void deleteMotelById(String roomId) {
        iMotelRepository.deleteMotelById(roomId);
    }

    @Override
    public String autoIncreaseId() {
        List<Motel> motelList = iMotelRepository.getAllMotels();
        String newId = "";
        int totalMotel = motelList.size();
        if (totalMotel < 9) {
            newId = "PT-00" + ++totalMotel;
        } else {
            newId = "PT-0" + ++totalMotel;
        }
        return newId;
    }

    @Override
    public String formatDate(String date) {
        List<String> split = new ArrayList<>(List.of(date.split("-")));
        Collections.reverse(split);
        String newDate = split.get(0) + "-" + split.get(1) + "-" + split.get(2);
        return newDate;
    }

//    public static void main(String[] args) {
//        MotelService motelService = new MotelService();
//        System.out.println(motelService.formatDate("1999-12-23"));
//    }
}
