package com.project.model;

import java.sql.*;
import java.util.*;


public class Siswa {
    public int id;
    public String nama;
    public String kelas;
    public String email;
    public int guardianId;
    public double nilaiAkhir;

    public Siswa() {
    }

    public Siswa(int id, String nama, String kelas, String email, int guardianId, double nilaiAkhir) {
        this.id = id;
        this.nama = nama;
        this.kelas = kelas;
        this.email = email;
        this.guardianId = guardianId;
        this.nilaiAkhir = nilaiAkhir;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getGuardianId() {
        return guardianId;
    }

    public void setGuardianId(int guardianId) {
        this.guardianId = guardianId;
    }

    public double getNilaiAkhir() {
        return nilaiAkhir;
    }

    public void setNilaiAkhir(double nilaiAkhir) {
        this.nilaiAkhir = nilaiAkhir;
    }

    public void tambahSiswa(Connection connection) throws SQLException {
        String query = "INSERT INTO siswa (nama, kelas, email, guardian_id, nilai_akhir) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, nama);
        preparedStatement.setString(2, kelas);
        preparedStatement.setString(3, email);
        preparedStatement.setInt(4, guardianId);
        preparedStatement.setDouble(5, nilaiAkhir);

        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public void updateSiswa(Connection connection) throws SQLException {
        String query = "UPDATE siswa SET nama = ?, kelas = ?, email = ?, guardian_id = ?, nilai_akhir = ? WHERE id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, nama);
        preparedStatement.setString(2, kelas);
        preparedStatement.setString(3, email);
        preparedStatement.setInt(4, guardianId);
        preparedStatement.setDouble(5, nilaiAkhir);
        preparedStatement.setInt(6, id);

        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public void hapusSiswa(Connection connection) throws SQLException {
        String query = "DELETE FROM siswa WHERE id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);

        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    
    public static Siswa getSiswaById(Connection connection, int id) throws SQLException {
        String query = "SELECT * FROM siswa WHERE id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            String nama = resultSet.getString("nama");
            String kelas = resultSet.getString("kelas");
            String email = resultSet.getString("email");
            int guardianId = resultSet.getInt("guardian_id");
            double nilaiAkhir = resultSet.getDouble("nilai_akhir");

            return new Siswa(id, nama, kelas, email, guardianId, nilaiAkhir);
        }

        resultSet.close();
        preparedStatement.close();

        return null;
    }

}
