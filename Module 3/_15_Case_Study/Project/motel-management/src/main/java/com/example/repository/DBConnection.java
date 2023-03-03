package com.example.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String jdbcURL = "jdbc:mysql://localhost:3308/module3";
    private static final String jdbcUsername = "root";
    private static final String jdbcPassword = "12345678";

    protected static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException exception) {
            // TODO Auto-generated catch block
            exception.printStackTrace();
        }
        return connection;
    }
}
