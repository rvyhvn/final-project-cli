package com.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/final", "hanshi", "ehanpintar");

            Menu menu = new Menu(connection);
            menu.displayMenu();

            connection.close();
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC driver not found. Make sure it is added to the classpath.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
