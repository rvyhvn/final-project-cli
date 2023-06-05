package com.project.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
    private static final String URL = "jdbc:postgresql://localhost:5432/final"; // Ganti dengan URL dan nama database Anda
    private static final String USERNAME = "your-username"; // Ganti dengan username database Anda
    private static final String PASSWORD = "your-password"; // Ganti dengan password database Anda

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
