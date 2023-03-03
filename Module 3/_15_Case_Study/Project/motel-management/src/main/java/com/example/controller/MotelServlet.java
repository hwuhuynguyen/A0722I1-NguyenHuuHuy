package com.example.controller;

import com.example.model.Motel;
import com.example.service.IMotelService;
import com.example.service.MotelService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MotelServlet", value = "/motels")
public class MotelServlet extends HttpServlet {
    private static final IMotelService iMotelService = new MotelService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "";
        switch (action) {
            case "insert-motel":
                displayInsertForm(request, response);
                break;
            case "update-motel":
                displayUpdateForm(request, response);
                break;
            case "delete-motel":
                displayDeleteForm(request, response);
                break;
            default:
                listAllMotels(request, response);
                break;
        }
    }

    private void displayInsertForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/motel/insert-motel.jsp");
        try {
            String newId = iMotelService.autoIncreaseId();
            request.setAttribute("newId", newId);
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void displayUpdateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/motel/update-motel.jsp");
        String id = request.getParameter("id");

        try {
            Motel motel = iMotelService.findMotelById(id);
            request.setAttribute("motel", motel);
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void displayDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        iMotelService.deleteMotelById(id);
        try {
            response.sendRedirect("/motels");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listAllMotels(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/motel/list-motels.jsp");
        List<Motel> motelList = iMotelService.getAllMotelsNotDeleted();

        try {
            request.setAttribute("motelList", motelList);
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
            case "insert-motel":
                addNewMotel(request, response);
                break;
            case "update-motel":
                editMotel(request, response);
                break;
            case "delete-motel":
                displayDeleteForm(request, response);
                break;
            default:
                listAllMotels(request, response);
                break;
        }
    }

    private void addNewMotel(HttpServletRequest request, HttpServletResponse response) {
        String roomId = request.getParameter("roomId");
        String customerName = request.getParameter("customerName");
        String phoneNumber = request.getParameter("phoneNumber");
        String startDay = request.getParameter("startDay");
        String paymentMethod = request.getParameter("paymentMethod");
        String note = request.getParameter("note");

        RequestDispatcher dispatcher;
        Motel motel = new Motel(roomId, customerName, phoneNumber, startDay, Integer.parseInt(paymentMethod), note);
        dispatcher = request.getRequestDispatcher("/motel/insert-motel.jsp");
        if (Integer.parseInt(paymentMethod) == 100) {
            request.setAttribute("message", "Please choose the payment method");
            String newId = iMotelService.autoIncreaseId();
            request.setAttribute("newId", newId);
        } else {
            iMotelService.insertNewMotel(motel);
            request.setAttribute("message", "Successfully add new motel");
        }

        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void editMotel(HttpServletRequest request, HttpServletResponse response) {
        String roomId = request.getParameter("roomId");
        String customerName = request.getParameter("customerName");
        String phoneNumber = request.getParameter("phoneNumber");
        String startDay = request.getParameter("startDay");
        String paymentMethod = request.getParameter("paymentMethod");
        String note = request.getParameter("note");

        RequestDispatcher dispatcher;
        Motel motel = iMotelService.findMotelById(roomId);
        motel.setCustomerName(customerName);
        motel.setPhoneNumber(phoneNumber);
        motel.setStartDay(startDay);
        motel.setPaymentMethod(Integer.parseInt(paymentMethod));
        motel.setNote(note);

        iMotelService.updateMotel(motel);

        dispatcher = request.getRequestDispatcher("/motel/update-motel.jsp");
        request.setAttribute("message", "Successfully update motel");

        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

}
