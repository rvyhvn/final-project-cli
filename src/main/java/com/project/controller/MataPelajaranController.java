package com.project.controller;

import com.project.dao.MataPelajaranDAO;
import com.project.model.MataPelajaran;
import com.project.util.DatabaseUtil;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class MataPelajaranController {
    private MataPelajaranDAO mataPelajaranDAO;

    public MataPelajaranController() {
        try {
            Connection connection = DatabaseUtil.getConnection();
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
