package com.project.controller;

import com.project.dao.KelasDAO;
import com.project.model.Kelas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class KelasController {
    private KelasDAO kelasDAO;
    private Connection connection;

    public KelasController() {
        // Konfigurasi koneksi database
        String url = "jdbc:postgresql://localhost:5432/nama_database"; // Ganti dengan URL dan nama database Anda
        String username = "username"; // Ganti dengan username database Anda
        String password = "password"; // Ganti dengan password database Anda

        try {
            connection = DriverManager.getConnection(url, username, password);
            kelasDAO = new KelasDAO(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addKelas(Kelas kelas) {
        kelasDAO.addKelas(kelas);
    }

    public List<Kelas> getAllKelas() {
        return kelasDAO.getAllKelas();
    }

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
