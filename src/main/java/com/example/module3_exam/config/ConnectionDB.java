package com.example.module3_exam.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private Connection connection;

    public static ConnectionDB instance = null;
    public static final String URL = "jdbc:mysql://localhost:3306/module3_exam";
    public static final String USER = "root";

    public static final String PASSWORD = "chetdicon";

    public ConnectionDB() {
    }



    public static Connection getConnect() {
        Connection connect = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Ket noi thanh cong");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connect;

    }

}
