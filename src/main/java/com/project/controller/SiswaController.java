package com.project.controller;

import com.project.dao.SiswaDAO;
import com.project.model.Kelas;
import com.project.model.Nilai;
import com.project.model.Siswa;
import com.project.model.WaliMurid;
import com.project.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class SiswaController {
    private SiswaDAO siswaDAO;

    public SiswaController() {
        try {
            Connection connection = DatabaseUtil.getConnection();
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
