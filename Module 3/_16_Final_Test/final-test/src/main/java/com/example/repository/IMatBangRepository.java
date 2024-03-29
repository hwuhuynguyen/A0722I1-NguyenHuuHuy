package com.example.repository;

import com.example.model.MatBang;

import java.util.List;

public interface IMatBangRepository {
    List<MatBang> getAllMatBang();
    List<MatBang> getAllMatBangNotDeleted();
    List<MatBang> getAllMatBangSortedByDienTich();
    MatBang findMatBangById(String id);
    void addNewMatBang(MatBang matBang);
    void deleteMatBangById(String id);
    List<MatBang> searchMatBang(int loaiMatBangSearch, int giaTienSearch, int tangSearch);
}
