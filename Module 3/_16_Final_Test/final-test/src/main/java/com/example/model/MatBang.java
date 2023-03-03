package com.example.model;

import java.util.ArrayList;
import java.util.List;

public class MatBang {
    private String maMatBang;
    private int dienTich;
    private int trangThai;
    private int tang;
    private int loaiMatBang;
    private int giaTien;
    private String ngayBatDau;
    private String ngayKetThuc;
    private String moTa;

    public MatBang() {
    }

    public MatBang(int dienTich, int trangThai, int tang, int loaiMatBang, int giaTien,
                   String ngayBatDau, String ngayKetThuc, String moTa) {
        this.dienTich = dienTich;
        this.trangThai = trangThai;
        this.tang = tang;
        this.loaiMatBang = loaiMatBang;
        this.giaTien = giaTien;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.moTa = moTa;
    }

    public MatBang(String maMatBang, int dienTich, int trangThai, int tang, int loaiMatBang,
                   int giaTien, String ngayBatDau, String ngayKetThuc, String moTa) {
        this.maMatBang = maMatBang;
        this.dienTich = dienTich;
        this.trangThai = trangThai;
        this.tang = tang;
        this.loaiMatBang = loaiMatBang;
        this.giaTien = giaTien;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.moTa = moTa;
    }

    public String getMaMatBang() {
        return maMatBang;
    }

    public void setMaMatBang(String maMatBang) {
        this.maMatBang = maMatBang;
    }

    public int getDienTich() {
        return dienTich;
    }

    public void setDienTich(int dienTich) {
        this.dienTich = dienTich;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public int getTang() {
        return tang;
    }

    public void setTang(int tang) {
        this.tang = tang;
    }

    public int getLoaiMatBang() {
        return loaiMatBang;
    }

    public void setLoaiMatBang(int loaiMatBang) {
        this.loaiMatBang = loaiMatBang;
    }

    public int getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(int giaTien) {
        this.giaTien = giaTien;
    }

    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    @Override
    public String toString() {
        return "MatBang{" +
                "maMatBang='" + maMatBang + '\'' +
                ", dienTich=" + dienTich +
                ", trangThai=" + trangThai +
                ", tang=" + tang +
                ", loaiMatBang=" + loaiMatBang +
                ", giaTien=" + giaTien +
                ", ngayBatDau='" + ngayBatDau + '\'' +
                ", ngayKetThuc='" + ngayKetThuc + '\'' +
                ", moTa='" + moTa + '\'' +
                '}';
    }

    public String formatDate(String date) {
        List<String> split = new ArrayList<>(List.of(date.split("-")));
        return split.get(2) + "/" + split.get(1) + "/" + split.get(0);
    }
}
