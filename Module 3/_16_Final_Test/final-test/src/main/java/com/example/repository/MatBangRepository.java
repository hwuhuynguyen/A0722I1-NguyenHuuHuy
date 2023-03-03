package com.example.repository;

import com.example.model.MatBang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MatBangRepository implements IMatBangRepository {
    private static final String SELECT_ALL_MATBANG = "SELECT * FROM mat_bang";
    private static final String SELECT_ALL_MATBANG_NOT_DELETED = "SELECT * FROM mat_bang WHERE da_xoa = 0";
    private static final String SELECT_MATBANG_BY_ID = "SELECT * FROM mat_bang WHERE ma_mat_bang = ? AND da_xoa = 0";
    private static final String SELECT_MATBANG_SORTED_BY_DIEN_TICH = "SELECT * FROM mat_bang WHERE da_xoa = 0 ORDER BY dien_tich ASC";

    private static final String INSERT_MATBANG =
            "INSERT INTO mat_bang (ma_mat_bang, dien_tich, trang_thai, tang, loai_mat_bang, gia_tien, ngay_bat_dau, ngay_ket_thuc, mo_ta)"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String SEARCH_MATBANG = "SELECT * FROM mat_bang WHERE loai_mat_bang = ? AND gia_tien = ? AND tang = ?";
    private static final String DELETE_MATBANG_BY_ID = "UPDATE mat_bang SET da_xoa = 1 WHERE ma_mat_bang = ?";

    @Override
    public List<MatBang> getAllMatBang() {
        List<MatBang> matBangList = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_MATBANG)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String maMatBang = resultSet.getString("ma_mat_bang");
                int dienTich = resultSet.getInt("dien_tich");
                int trangThai = resultSet.getInt("trang_thai");
                int tang = resultSet.getInt("tang");
                int loaiMatBang = resultSet.getInt("loai_mat_bang");
                int giaTien = resultSet.getInt("gia_tien");
                String ngayBatDau = resultSet.getString("ngay_bat_dau");
                String ngayKetThuc = resultSet.getString("ngay_ket_thuc");
                String moTa = resultSet.getString("mo_ta");

                MatBang matBang = new MatBang(maMatBang, dienTich, trangThai, tang, loaiMatBang, giaTien, ngayBatDau, ngayKetThuc, moTa);
                matBangList.add(matBang);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return matBangList;
    }

    @Override
    public List<MatBang> getAllMatBangNotDeleted() {
        List<MatBang> matBangList = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_MATBANG_NOT_DELETED)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String maMatBang = resultSet.getString("ma_mat_bang");
                int dienTich = resultSet.getInt("dien_tich");
                int trangThai = resultSet.getInt("trang_thai");
                int tang = resultSet.getInt("tang");
                int loaiMatBang = resultSet.getInt("loai_mat_bang");
                int giaTien = resultSet.getInt("gia_tien");
                String ngayBatDau = resultSet.getString("ngay_bat_dau");
                String ngayKetThuc = resultSet.getString("ngay_ket_thuc");
                String moTa = resultSet.getString("mo_ta");

                MatBang matBang = new MatBang(maMatBang, dienTich, trangThai, tang, loaiMatBang, giaTien, ngayBatDau, ngayKetThuc, moTa);
                matBangList.add(matBang);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return matBangList;
    }

    @Override
    public List<MatBang> getAllMatBangSortedByDienTich() {
        List<MatBang> matBangList = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MATBANG_SORTED_BY_DIEN_TICH)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String maMatBang = resultSet.getString("ma_mat_bang");
                int dienTich = resultSet.getInt("dien_tich");
                int trangThai = resultSet.getInt("trang_thai");
                int tang = resultSet.getInt("tang");
                int loaiMatBang = resultSet.getInt("loai_mat_bang");
                int giaTien = resultSet.getInt("gia_tien");
                String ngayBatDau = resultSet.getString("ngay_bat_dau");
                String ngayKetThuc = resultSet.getString("ngay_ket_thuc");
                String moTa = resultSet.getString("mo_ta");

                MatBang matBang = new MatBang(maMatBang, dienTich, trangThai, tang, loaiMatBang, giaTien, ngayBatDau, ngayKetThuc, moTa);
                matBangList.add(matBang);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return matBangList;
    }

    @Override
    public MatBang findMatBangById(String id) {
        MatBang matBang = null;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MATBANG_BY_ID)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String maMatBang = resultSet.getString("ma_mat_bang");
                int dienTich = resultSet.getInt("dien_tich");
                int trangThai = resultSet.getInt("trang_thai");
                int tang = resultSet.getInt("tang");
                int loaiMatBang = resultSet.getInt("loai_mat_bang");
                int giaTien = resultSet.getInt("gia_tien");
                String ngayBatDau = resultSet.getString("ngay_bat_dau");
                String ngayKetThuc = resultSet.getString("ngay_ket_thuc");
                String moTa = resultSet.getString("mo_ta");

                matBang = new MatBang(maMatBang, dienTich, trangThai, tang, loaiMatBang, giaTien, ngayBatDau, ngayKetThuc, moTa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return matBang;
    }

    @Override
    public void addNewMatBang(MatBang matBang) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MATBANG)) {
            preparedStatement.setString(1, matBang.getMaMatBang());
            preparedStatement.setInt(2, matBang.getDienTich());
            preparedStatement.setInt(3, matBang.getTrangThai());
            preparedStatement.setInt(4, matBang.getTang());
            preparedStatement.setInt(5, matBang.getLoaiMatBang());
            preparedStatement.setInt(6, matBang.getGiaTien());
            preparedStatement.setString(7, matBang.getNgayBatDau());
            preparedStatement.setString(8, matBang.getNgayKetThuc());
            preparedStatement.setString(9, matBang.getMoTa());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteMatBangById(String id) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_MATBANG_BY_ID)) {
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<MatBang> searchMatBang(int loaiMatBangSearch, int giaTienSearch, int tangSearch) {
        List<MatBang> matBangList = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_MATBANG)) {
            preparedStatement.setInt(1, loaiMatBangSearch);
            preparedStatement.setInt(2, giaTienSearch);
            preparedStatement.setInt(3, tangSearch);
            System.err.println(SEARCH_MATBANG);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String maMatBang = resultSet.getString("ma_mat_bang");
                int dienTich = resultSet.getInt("dien_tich");
                int trangThai = resultSet.getInt("trang_thai");
                int tang = resultSet.getInt("tang");
                int loaiMatBang = resultSet.getInt("loai_mat_bang");
                int giaTien = resultSet.getInt("gia_tien");
                String ngayBatDau = resultSet.getString("ngay_bat_dau");
                String ngayKetThuc = resultSet.getString("ngay_ket_thuc");
                String moTa = resultSet.getString("mo_ta");

                MatBang matBang = new MatBang(maMatBang, dienTich, trangThai, tang, loaiMatBang, giaTien, ngayBatDau, ngayKetThuc, moTa);
                matBangList.add(matBang);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return matBangList;
    }
}
