package com.project;

import com.project.view.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class App {
    public static void main(String[] args) {
        String DB_URL = "jdbc:postgresql://localhost:5432/final";
        String USER = "postgres";
        String PASS = "";

        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);

            Menu menu = new Menu(connection);
            menu.displayMenu();

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
