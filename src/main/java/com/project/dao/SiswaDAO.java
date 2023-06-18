package com.project.dao;

import com.project.model.*;
import com.project.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SiswaDAO {
    private Connection connection;

    // Constructor
    public SiswaDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Siswa> getAllSiswa() throws SQLException {
        List<Siswa> siswaList = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT s.id_siswa, s.nama, s.email, s.phone, k.id_kelas, k.tingkat, k.urutan, k.is_ipa, w.id_wali, w.nama AS nama_wali, w.email AS email_wali, w.phone AS phone_wali, wm.id_wali, wm.nama AS nama_wali, wm.email AS email_wali, wm.phone AS phone_wali FROM siswa s LEFT JOIN kelas k ON s.id_kelas = k.id_kelas LEFT JOIN wali_murid wm ON s.id_wali = wm.id_wali LEFT JOIN wali w ON wm.id_wali = w.id_wali;");
            while (resultSet.next()) {
                Siswa siswa = new Siswa();
                siswa.setIdSiswa(resultSet.getInt("id_siswa"));
                siswa.setNama(resultSet.getString("nama"));
                siswa.setEmail(resultSet.getString("email"));
                siswa.setPhone(resultSet.getString("phone"));

                Kelas kelas = new Kelas();
                kelas.setIdKelas(resultSet.getInt("id_kelas"));
                kelas.setTingkat(resultSet.getString("tingkat"));
                kelas.setUrutan(resultSet.getInt("urutan"));
                kelas.setIsIpa(resultSet.getBoolean("is_ipa"));

                WaliMurid waliMurid = new WaliMurid();
                waliMurid.setIdWali(resultSet.getInt("id_wali"));
                waliMurid.setNama(resultSet.getString("nama_wali"));
                waliMurid.setEmail(resultSet.getString("email_wali"));
                waliMurid.setPhone(resultSet.getString("phone_wali"));

                siswa.setKelas(kelas);
                siswa.setWaliMurid(waliMurid);

                siswaList.add(siswa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
            DatabaseUtil.closeConnection(connection);
        }
        return siswaList;
    }

    public Siswa getSiswaById(int idSiswa) throws SQLException {
        Siswa siswa = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement("SELECT s.id_siswa, s.nama, s.email, s.phone, k.id_kelas, k.tingkat, k.urutan, k.is_ipa, w.id_wali, w.nama AS nama_wali, w.email AS email_wali, w.phone AS phone_wali, wm.id_wali, wm.nama AS nama_wali, wm.email AS email_wali, wm.phone AS phone_wali FROM siswa s LEFT JOIN kelas k ON s.id_kelas = k.id_kelas LEFT JOIN wali_murid wm ON s.id_wali = wm.id_wali LEFT JOIN wali w ON wm.id_wali = w.id_wali WHERE s.id_siswa = ?;");
            statement.setInt(1, idSiswa);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                siswa = new Siswa();
                siswa.setIdSiswa(resultSet.getInt("id_siswa"));
                siswa.setNama(resultSet.getString("nama"));
                siswa.setEmail(resultSet.getString("email"));
                siswa.setPhone(resultSet.getString("phone"));

                Kelas kelas = new Kelas();
                kelas.setIdKelas(resultSet.getInt("id_kelas"));
                kelas.setTingkat(resultSet.getString("tingkat"));
                kelas.setUrutan(resultSet.getInt("urutan"));
                kelas.setIsIpa(resultSet.getBoolean("is_ipa"));

                WaliMurid waliMurid = new WaliMurid();
                waliMurid.setIdWali(resultSet.getInt("id_wali"));
                waliMurid.setNama(resultSet.getString("nama_wali"));
                waliMurid.setEmail(resultSet.getString("email_wali"));
                waliMurid.setPhone(resultSet.getString("phone_wali"));

                siswa.setKelas(kelas);
                siswa.setWaliMurid(waliMurid);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
            DatabaseUtil.closeConnection(connection);
        }
        return siswa;
    }

    public List<Siswa> getSiswaByKelas(int idKelas) throws SQLException {
        List<Siswa> siswaList = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement("SELECT s.id_siswa, s.nama, s.email, s.phone, k.id_kelas, k.tingkat, k.urutan, k.is_ipa, w.id_wali, w.nama AS nama_wali, w.email AS email_wali, w.phone AS phone_wali, wm.id_wali, wm.nama AS nama_wali, wm.email AS email_wali, wm.phone AS phone_wali FROM siswa s LEFT JOIN kelas k ON s.id_kelas = k.id_kelas LEFT JOIN wali_murid wm ON s.id_wali = wm.id_wali LEFT JOIN wali w ON wm.id_wali = w.id_wali WHERE k.id_kelas = ?;");
            statement.setInt(1, idKelas);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Siswa siswa = new Siswa();
                siswa.setIdSiswa(resultSet.getInt("id_siswa"));
                siswa.setNama(resultSet.getString("nama"));
                siswa.setEmail(resultSet.getString("email"));
                siswa.setPhone(resultSet.getString("phone"));

                Kelas kelas = new Kelas();
                kelas.setIdKelas(resultSet.getInt("id_kelas"));
                kelas.setTingkat(resultSet.getString("tingkat"));
                kelas.setUrutan(resultSet.getInt("urutan"));
                kelas.setIsIpa(resultSet.getBoolean("is_ipa"));

                WaliMurid waliMurid = new WaliMurid();
                waliMurid.setIdWali(resultSet.getInt("id_wali"));
                waliMurid.setNama(resultSet.getString("nama_wali"));
                waliMurid.setEmail(resultSet.getString("email_wali"));
                waliMurid.setPhone(resultSet.getString("phone_wali"));

                siswa.setKelas(kelas);
                siswa.setWaliMurid(waliMurid);

                siswaList.add(siswa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
            DatabaseUtil.closeConnection(connection);
        }
        return siswaList;
    }

    public void addSiswa(Siswa siswa) throws SQLException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("INSERT INTO siswa (nama, email, phone, id_kelas, id_wali) VALUES (?, ?, ?, ?, ?);");
            statement.setString(1, siswa.getNama());
            statement.setString(2, siswa.getEmail());
            statement.setString(3, siswa.getPhone());
            statement.setInt(4, siswa.getKelas().getIdKelas());
            statement.setInt(5, siswa.getWaliMurid().getIdWali());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            DatabaseUtil.closeConnection(connection);
        }
    }

    public void updateSiswa(Siswa siswa) throws SQLException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("UPDATE siswa SET nama = ?, email = ?, phone = ?, id_kelas = ?, id_wali = ? WHERE id_siswa = ?;");
            statement.setString(1, siswa.getNama());
            statement.setString(2, siswa.getEmail());
            statement.setString(3, siswa.getPhone());
            statement.setInt(4, siswa.getKelas().getIdKelas());
            statement.setInt(5, siswa.getWaliMurid().getIdWali());
            statement.setInt(6, siswa.getIdSiswa());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            DatabaseUtil.closeConnection(connection);
        }
    }

    public void deleteSiswa(int idSiswa) throws SQLException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("DELETE FROM siswa WHERE id_siswa = ?;");
            statement.setInt(1, idSiswa);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            DatabaseUtil.closeConnection(connection);
        }
    }
}
