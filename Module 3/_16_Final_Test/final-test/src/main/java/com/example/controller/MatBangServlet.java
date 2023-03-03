package com.example.controller;

import com.example.model.MatBang;
import com.example.service.IMatBangService;
import com.example.service.MatBangService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MatBangServlet", value = "/matBangs")
public class MatBangServlet extends HttpServlet {
    private static final IMatBangService iMatBangService = new MatBangService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "";
        switch (action) {
            case "add-mat-bang":
                displayAddMatBangForm(request, response);
                break;
            case "delete-mat-bang":
                displayDeleteMatBangForm(request, response);
                break;
            case "search-mat-bang":
                displaySearchMatBangForm(request, response);
                break;
            default:
                listAllMatBang(request, response);
                break;
        }
    }


    private void displayAddMatBangForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/matbang/add.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void displaySearchMatBangForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/matbang/search.jsp");
        List<MatBang> matBangList = iMatBangService.getAllMatBangSortedByDienTich();

        try {
            request.setAttribute("matBangList", matBangList);
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void displayDeleteMatBangForm(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        iMatBangService.deleteMatBangById(id);
        try {
            response.sendRedirect("/matBangs");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listAllMatBang(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/matbang/list.jsp");
        List<MatBang> matBangList = iMatBangService.getAllMatBangSortedByDienTich();

        try {
            request.setAttribute("matBangList", matBangList);
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "";
        switch (action) {
            case "add-mat-bang":
                addMatBang(request, response);
                break;
            case "search-mat-bang":
                timkiemMatBang(request, response);
                break;
            default:
                listAllMatBang(request, response);
                break;
        }
    }

    private void timkiemMatBang(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/matbang/search.jsp");

        int loaiMB = Integer.parseInt(request.getParameter("loaiMatBang"));
        int tang = Integer.parseInt(request.getParameter("tang"));
        int tien = Integer.parseInt(request.getParameter("giaTien"));
        List<MatBang> matBangList = iMatBangService.searchMatBang(loaiMB, tien, tang);

        try {
            request.setAttribute("matBangList", matBangList);
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void addMatBang(HttpServletRequest request, HttpServletResponse response) {
            String maMatBang = request.getParameter("maMatBang");
            int dienTich = Integer.parseInt(request.getParameter("dienTich"));
            int trangThai = Integer.parseInt(request.getParameter("trangThai"));
            int tang = Integer.parseInt(request.getParameter("tang"));
            int loaiMatBang = Integer.parseInt(request.getParameter("loaiMatBang"));
            int giaTien = Integer.parseInt(request.getParameter("giaTien"));
            String ngayBatDau = request.getParameter("ngayBatDau");
            String ngayKetThuc = request.getParameter("ngayKetThuc");
            String moTa = request.getParameter("moTa");

            RequestDispatcher dispatcher;
            MatBang matBang = new MatBang(maMatBang, dienTich, trangThai, tang, loaiMatBang, giaTien, ngayBatDau, ngayKetThuc, moTa);
            dispatcher = request.getRequestDispatcher("/matbang/add.jsp");
            iMatBangService.addNewMatBang(matBang);
            request.setAttribute("message", "Them moi mat bang thanh cong");

            try {
                response.sendRedirect("/matBangs");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}

