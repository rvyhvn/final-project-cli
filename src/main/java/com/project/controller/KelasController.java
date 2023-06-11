package com.project.controller;

import com.project.dao.KelasDAO;
import com.project.model.Kelas;
import com.project.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class KelasController {
    private KelasDAO kelasDAO;
    private Connection connection;

    public KelasController() {
        try {
            connection = DatabaseUtil.getConnection();
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
