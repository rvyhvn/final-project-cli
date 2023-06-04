package com.project.controller;

import com.project.dao.MataPelajaranDAO;
import com.project.model.Kelas;
import com.project.model.MataPelajaran;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class MataPelajaranController {
    private MataPelajaranDAO mataPelajaranDAO;

    public MataPelajaranController() {
        try {
            // Mengatur koneksi database (menggunakan JDBC)
            String url = "jdbc:postgresql://localhost:5432/final";
            String username = "your-username";
            String password = "your-password";
            Connection connection = DriverManager.getConnection(url, username, password);

            // Membuat instance dari MataPelajaranDAO dengan koneksi database
            mataPelajaranDAO = new MataPelajaranDAO(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveMataPelajaran(MataPelajaran mataPelajaran) {
        mataPelajaranDAO.saveMataPelajaran(mataPelajaran);
    }

    public List<MataPelajaran> getAllMataPelajaran() {
        return mataPelajaranDAO.getAllMataPelajaran();
    }
}
