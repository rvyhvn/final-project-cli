package com.project.controller;

import com.project.dao.LoginDAO;
import com.project.model.Guru;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LoginController {
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;

    private final String DB_URL = "jdbc:postgresql://localhost:5432/your_database";
    private final String DB_USERNAME = "your_username";
    private final String DB_PASSWORD = "your_password";

    public void login() {
        String email = emailField.getText();
        String password = passwordField.getText();

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            LoginDAO loginDAO = new LoginDAO(connection);
            Guru guru = loginDAO.login(email, password);
            if (guru != null) {
                // Login berhasil, lakukan aksi sesuai kebutuhan
                // Misalnya, pindah ke halaman utama setelah login sukses
                // MainViewController mainViewController = new MainViewController(guru);
                // mainViewController.showMainView();
            } else {
                showErrorMessage("Login gagal", "Email atau password salah");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            showErrorMessage("Error", "Terjadi kesalahan saat mengakses database");
        }
    }

    private void showErrorMessage(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
