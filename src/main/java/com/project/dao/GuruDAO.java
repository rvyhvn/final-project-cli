package com.project.dao;

import com.project.model.Guru;
import com.project.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GuruDAO {
    private Connection connection;

    public GuruDAO(Connection connection) {
      this.connection = connection;        // Menginisialisasi koneksi ke database
    }

    public List<Guru> getAllGuru() {
        List<Guru> guruList = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            // Membuat pernyataan SQL
            String query = "SELECT * FROM guru";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            // Mengambil hasil query dan membangun objek Guru
            while (resultSet.next()) {
                Guru guru = new Guru();
                guru.setIdGuru(resultSet.getInt("id_guru"));
                guru.setNama(resultSet.getString("nama"));
                guru.set(resultSet.getString("mata_pelajaran"));
                guru.setPhone(resultSet.getString("phone"));
                guru.setEmail(resultSet.getString("email"));

                guruList.add(guru);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Menutup statement dan resultSet
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            // Menutup koneksi ke database
            DatabaseUtil.closeConnection(connection);
        }
        return guruList;
    }

    public Guru getGuruById(int id) {
        Guru guru = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            // Membuat pernyataan SQL dengan parameter
            String query = "SELECT * FROM guru WHERE id = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            // Mengambil hasil query dan membangun objek Guru
            if (resultSet.next()) {
                guru = new Guru();
                guru.setId(resultSet.getInt("id"));
                guru.setNama(resultSet.getString("nama"));
                guru.setMataPelajaran(resultSet.getString("mata_pelajaran"));
                guru.setNoTelepon(resultSet.getString("no_telepon"));
                guru.setEmail(resultSet.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Menutup statement dan resultSet
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return guru;
    }

    public void addGuru(Guru guru) {
        PreparedStatement statement = null;
        try {
            // Membuat pernyataan SQL dengan parameter
            String query = "INSERT INTO guru (nama, mata_pelajaran, no_telepon, email) VALUES (?, ?, ?, ?)";
            statement = connection.prepareStatement(query);
            statement.setString(1, guru.getNama());
            statement.setString(2, guru.getMataPelajaran());
            statement.setString(3, guru.getNoTelepon());
            statement.setString(4, guru.getEmail());

            // Menjalankan pernyataan SQL
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Menutup statement
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            // Menutup koneksi ke database
            DatabaseUtil.closeConnection(connection);
        }
    }

    public void updateGuru(Guru guru) {
        PreparedStatement statement = null;
        try {
            // Membuat pernyataan SQL dengan parameter
            String query = "UPDATE guru SET nama = ?, mata_pelajaran = ?, no_telepon = ?, email = ? WHERE id = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, guru.getNama());
            statement.setString(2, guru.getMataPelajaran());
            statement.setString(3, guru.getNoTelepon());
            statement.setString(4, guru.getEmail());
            statement.setInt(5, guru.getId());

            // Menjalankan pernyataan SQL
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Menutup statement
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            // Menutup koneksi ke database
            DatabaseUtil.closeConnection(connection);
        }
    }

    public void deleteGuru(int id) {
        PreparedStatement statement = null;
        try {
            // Membuat pernyataan SQL dengan parameter
            String query = "DELETE FROM guru WHERE id = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            // Menjalankan pernyataan SQL
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Menutup statement
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            // Menutup koneksi ke database
            DatabaseUtil.closeConnection(connection);
        }
    }
}
