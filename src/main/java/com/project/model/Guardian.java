package com.project.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Guardian {
    private int id;
    private String nama;
    private String email;
    private String phone;

    public Guardian() {
    }

    public Guardian(int id, String nama, String email, String phone) {
        this.id = id;
        this.nama = nama;
        this.email = email;
        this.phone = phone;
    }

    // Getter dan setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Metode untuk operasi CRUD

    public void tambahGuardian(Connection connection) throws SQLException {
        String query = "INSERT INTO guardian (nama, email, phone) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, nama);
        statement.setString(2, email);
        statement.setString(3, phone);
        statement.executeUpdate();
        statement.close();
    }

    public void updateGuardian(Connection connection) throws SQLException {
        String query = "UPDATE guardian SET nama = ?, email = ?, phone = ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, nama);
        statement.setString(2, email);
        statement.setString(3, phone);
        statement.setInt(4, id);
        statement.executeUpdate();
        statement.close();
    }

    public void hapusGuardian(Connection connection) throws SQLException {
        String query = "DELETE FROM guardian WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        statement.executeUpdate();
        statement.close();
    }

    public static Guardian getGuardianById(Connection connection, int id) throws SQLException {
        String query = "SELECT * FROM guardian WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();

        Guardian guardian = null;
        if (resultSet.next()) {
            String nama = resultSet.getString("nama");
            String email = resultSet.getString("email");
            String phone = resultSet.getString("phone");
            guardian = new Guardian(id, nama, email, phone);
        }

        resultSet.close();
        statement.close();
        return guardian;
    }
}
