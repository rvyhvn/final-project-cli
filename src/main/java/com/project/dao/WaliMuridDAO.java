package com.project.dao;

import com.project.model.WaliMurid;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WaliMuridDAO {

    private Connection connection;

    public WaliMuridDAO(Connection connection) {
        this.connection = connection;
    }

    public void addWaliMurid(WaliMurid waliMurid) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO wali_murid (nama, phone, email) VALUES (?, ?, ?)");
            statement.setString(1, waliMurid.getNama());
            statement.setString(2, waliMurid.getPhone());
            statement.setString(3, waliMurid.getEmail());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateWaliMurid(WaliMurid waliMurid) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE wali_murid SET nama = ?, phone = ?, email = ? WHERE id_wali = ?");
            statement.setString(1, waliMurid.getNama());
            statement.setString(2, waliMurid.getPhone());
            statement.setString(3, waliMurid.getEmail());
            statement.setInt(4, waliMurid.getIdWali());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteWaliMurid(int idWali) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM wali_murid WHERE id_wali = ?");
            statement.setInt(1, idWali);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public WaliMurid getWaliMuridById(int idWali) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM wali_murid WHERE id_wali = ?");
            statement.setInt(1, idWali);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String nama = resultSet.getString("nama");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                return new WaliMurid(idWali, nama, email, phone, null);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<WaliMurid> getAllWaliMurid() {
        List<WaliMurid> waliMuridList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM wali_murid");
            while (resultSet.next()) {
                int idWali = resultSet.getInt("id_wali");
                String nama = resultSet.getString("nama");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                WaliMurid waliMurid = new WaliMurid(idWali, nama, email, phone, null);
                waliMuridList.add(waliMurid);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return waliMuridList;
    }
}
