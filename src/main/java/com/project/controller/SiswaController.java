package com.project.controller;

import com.project.model.Siswa;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SiswaController {
    private Connection connection;

    public SiswaController(Connection connection) {
        this.connection = connection;
    }

    public void lihatDaftarSiswa() throws SQLException {
        String query = "SELECT * FROM siswa ORDER BY id ASC";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        System.out.println("Daftar Siswa:");
        System.out.println("ID\tNama\t\t\tKelas\t\t\tEmail\t\t\tWali Murid ID\t\t\tNilai Mean ID");

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String nama = resultSet.getString("nama");
            String kelas = resultSet.getString("kelas");
            String email = resultSet.getString("email");
            int waliMuridId = resultSet.getInt("wali_murid_id");
            int nilaiMeanId = resultSet.getInt("nilai_mean_id");

            System.out.println(id + "\t" + nama + "\t\t" + kelas + "\t\t" + email + "\t\t" + waliMuridId + "\t\t\t" + nilaiMeanId);
        }

        resultSet.close();
        statement.close();
    }
}
