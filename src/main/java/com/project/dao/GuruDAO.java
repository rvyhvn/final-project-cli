package com.project.dao;

import com.project.model.Guru;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GuruDAO {

    private Connection connection;

    public GuruDAO(Connection connection) {
        this.connection = connection;
    }

    public void addGuru(Guru guru) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO guru (nama, phone, email) VALUES (?, ?, ?)");
            statement.setString(1, guru.getNama());
            statement.setString(2, guru.getPhone());
            statement.setString(3, guru.getEmail());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateGuru(Guru guru) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE guru SET nama = ?, phone = ?, email = ? WHERE id_guru = ?");
            statement.setString(1, guru.getNama());
            statement.setString(2, guru.getPhone());
            statement.setString(3, guru.getEmail());
            statement.setInt(4, guru.getIdGuru());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteGuru(int idGuru) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM guru WHERE id_guru = ?");
            statement.setInt(1, idGuru);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Guru getGuruById(int idGuru) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM guru WHERE id_guru = ?");
            statement.setInt(1, idGuru);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String nama = resultSet.getString("nama");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                return new Guru(idGuru, nama, email, phone, null, null);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Guru> getAllGuru() {
        List<Guru> guruList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM guru");
            while (resultSet.next()) {
                int idGuru = resultSet.getInt("id_guru");
                String nama = resultSet.getString("nama");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                Guru guru = new Guru(idGuru, nama, email, phone, null, null);
                guruList.add(guru);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return guruList;
    }
}
