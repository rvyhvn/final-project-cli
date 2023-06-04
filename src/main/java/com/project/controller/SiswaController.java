package com.project.controller;

import com.project.dao.SiswaDAO;
import com.project.model.Kelas;
import com.project.model.Nilai;
import com.project.model.Siswa;
import com.project.model.WaliMurid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class SiswaController {
    private SiswaDAO siswaDAO;

    public SiswaController() {
        try {
            String url = "jdbc:postgresql://localhost:5432/final";
            String username = "your-username";
            String password = "your-password";
            Connection connection = DriverManager.getConnection(url, username, password);
            siswaDAO = new SiswaDAO(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveSiswa(Siswa siswa) {
        siswaDAO.addSiswa(siswa);
    }

    public List<Siswa> getAllSiswa() {
        return siswaDAO.getAllSiswa();
    }
}
