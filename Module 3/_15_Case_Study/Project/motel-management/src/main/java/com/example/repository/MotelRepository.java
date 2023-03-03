package com.example.repository;

import com.example.model.Motel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MotelRepository implements IMotelRepository {
    private static final String SELECT_ALL_MOTELS = "SELECT * FROM motel";
    private static final String SELECT_ALL_MOTELS_NOT_DELETED = "SELECT * FROM motel WHERE isDeleted = 0";
    private static final String SELECT_MOTELS_BY_ID = "SELECT * FROM motel WHERE room_id = ? AND isDeleted = 0";
    private static final String INSERT_MOTEL =
            "INSERT INTO motel (room_id, customer_name, phone_number, start_day, payment_method, note)"
            + "VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_MOTEL = "UPDATE motel SET customer_name = ?, phone_number = ?," +
            "start_day = ?, payment_method = ?, note = ? WHERE room_id = ?";
    private static final String DELETE_MOTEL_BY_ID = "UPDATE motel SET isDeleted = 1 WHERE room_id = ?";

    @Override
    public List<Motel> getAllMotels() {
        List<Motel> motelList = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_MOTELS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String roomId = resultSet.getString("room_id");
                String customerName = resultSet.getString("customer_name");
                String phoneNumber = resultSet.getString("phone_number");
                String startDay = resultSet.getString("start_day");
                int paymentMethod = resultSet.getInt("payment_method");
                String note = resultSet.getString("note");
                if (note == null) note = "";

                Motel motel = new Motel(roomId, customerName, phoneNumber, startDay, paymentMethod, note);
                motelList.add(motel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return motelList;
    }

    @Override
    public List<Motel> getAllMotelsNotDeleted() {
        List<Motel> motelList = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_MOTELS_NOT_DELETED)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String roomId = resultSet.getString("room_id");
                String customerName = resultSet.getString("customer_name");
                String phoneNumber = resultSet.getString("phone_number");
                String startDay = resultSet.getString("start_day");
                int paymentMethod = resultSet.getInt("payment_method");
                String note = resultSet.getString("note");
                if (note == null) note = "";

                Motel motel = new Motel(roomId, customerName, phoneNumber, startDay, paymentMethod, note);
                motelList.add(motel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return motelList;
    }

    @Override
    public Motel findMotelById(String id) {
        Motel motel = null;
        try (Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MOTELS_BY_ID)) {
            preparedStatement.setString(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String roomId = resultSet.getString("room_id");
                String customerName = resultSet.getString("customer_name");
                String phoneNumber = resultSet.getString("phone_number");
                String startDay = resultSet.getString("start_day");
                int paymentMethod = resultSet.getInt("payment_method");
                String note = resultSet.getString("note");
                if (note == null) note = "";

                motel = new Motel(roomId, customerName, phoneNumber, startDay, paymentMethod, note);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return motel;
    }

    public static void main(String[] args) {
        MotelRepository motelRepository = new MotelRepository();
        List<Motel> motelList = motelRepository.getAllMotelsNotDeleted();
        for (Motel motel : motelList) System.err.println(motel);
        System.err.println(motelRepository.findMotelById("PT-001"));
    }

    @Override
    public void insertNewMotel(Motel motel) {
        try (Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MOTEL)) {
            preparedStatement.setString(1, motel.getRoomId());
            preparedStatement.setString(2, motel.getCustomerName());
            preparedStatement.setString(3, motel.getPhoneNumber());
            preparedStatement.setString(4, motel.getStartDay());
            preparedStatement.setInt(5, motel.getPaymentMethod());
            preparedStatement.setString(6, motel.getNote());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateMotel(Motel motel) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_MOTEL)) {
            preparedStatement.setString(1, motel.getCustomerName());
            preparedStatement.setString(2, motel.getPhoneNumber());
            preparedStatement.setString(3, motel.getStartDay());
            preparedStatement.setInt(4, motel.getPaymentMethod());
            preparedStatement.setString(5, motel.getNote());
            preparedStatement.setString(6, motel.getRoomId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteMotelById(String roomId) {
        try (Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_MOTEL_BY_ID)) {
            preparedStatement.setString(1, roomId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
