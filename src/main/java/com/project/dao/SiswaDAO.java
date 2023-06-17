package com.project.dao;

import com.project.model.Siswa;
import com.project.model.Kelas;
import com.project.model.Nilai;
import com.project.model.WaliMurid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SiswaDAO {
    private Connection connection;

    public SiswaDAO(Connection connection) {
        this.connection = connection;
    }

    public void addSiswa(Siswa siswa) {
        String query = "INSERT INTO siswa (id_siswa, nama, id_kelas, email, phone, id_wali, id_nilai) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, siswa.getIdSiswa());
            statement.setString(2, siswa.getNama());
            statement.setInt(3, siswa.getKelas().getIdKelas());
            statement.setString(4, siswa.getEmail());
            statement.setString(5, siswa.getPhone());
            statement.setInt(6, siswa.getWaliMurid().getIdWali());
            statement.setInt(7, siswa.getNilaiMean().getIdNilai());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Siswa> getAllSiswa() {
        String query = "SELECT * FROM siswa";
        List<Siswa> siswaList = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Siswa siswa = mapResultSetToSiswa(resultSet);
                siswaList.add(siswa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return siswaList;
    }

    private Siswa mapResultSetToSiswa(ResultSet resultSet) throws SQLException {
        int idSiswa = resultSet.getInt("id_siswa");
        String nama = resultSet.getString("nama");
        int idKelas = resultSet.getInt("kelas_id");
        String email = resultSet.getString("email");
        String phone = resultSet.getString("phone");
        int idWali = resultSet.getInt("wali_id");
        int idNilai = resultSet.getInt("nilai_id");

        // Dapatkan objek Kelas, WaliMurid, dan Nilai dengan menggunakan DAO yang sesuai

        KelasDAO kelasDAO = new KelasDAO(connection);
        Kelas kelas = kelasDAO.getKelasById(idKelas);

        WaliMuridDAO waliMuridDAO = new WaliMuridDAO(connection);
        WaliMurid waliMurid = waliMuridDAO.getWaliMuridById(idWali);

        NilaiDAO nilaiDAO = new NilaiDAO(connection);
        Nilai nilaiMean = nilaiDAO.getNilaiById(idNilai);

        return new Siswa(idSiswa, nama, kelas, email, phone, waliMurid, nilaiMean);
    }
}
