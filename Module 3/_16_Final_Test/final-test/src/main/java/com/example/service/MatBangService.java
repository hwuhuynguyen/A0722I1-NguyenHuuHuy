package com.example.service;

import com.example.model.MatBang;
import com.example.repository.IMatBangRepository;
import com.example.repository.MatBangRepository;

import java.util.List;

public class MatBangService implements IMatBangService {
    private static final IMatBangRepository iMatBangRepository = new MatBangRepository();
    @Override
    public List<MatBang> getAllMatBang() {
        return iMatBangRepository.getAllMatBang();
    }

    @Override
    public List<MatBang> getAllMatBangNotDeleted() {
        return iMatBangRepository.getAllMatBangNotDeleted();
    }

    @Override
    public List<MatBang> getAllMatBangSortedByDienTich() {
        return iMatBangRepository.getAllMatBangSortedByDienTich();
    }

    @Override
    public MatBang findMatBangById(String id) {
        return iMatBangRepository.findMatBangById(id);
    }

    @Override
    public void addNewMatBang(MatBang matBang) {
        iMatBangRepository.addNewMatBang(matBang);
    }

    @Override
    public void deleteMatBangById(String id) {
        iMatBangRepository.deleteMatBangById(id);
    }

    @Override
    public List<MatBang> searchMatBang(int loaiMatBangSearch, int giaTienSearch, int tangSearch) {
        return iMatBangRepository.searchMatBang(loaiMatBangSearch, giaTienSearch, tangSearch);
    }
}
