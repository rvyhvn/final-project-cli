package com.project.model;

import java.sql.*;
import java.util.*;


/**
 * Siswa
 */
public class Siswa extends Entity {

  private int idSiswa;
  private Kelas kelas;
  private WaliMurid waliMurid;
  private Nilai nilaiMean;


  public Siswa(int idSiswa, String nama, Kelas kelas, String email, String phone, WaliMurid waliMurid, Nilai nilaiMean) {
    super(nama, email, phone);
    this.idSiswa = idSiswa;
    this.kelas = kelas;
    this.waliMurid = waliMurid;
    this.nilaiMean = nilaiMean;
  }

  public int getIdSiswa() {
    return idSiswa;
  }

  public Kelas getKelas() {
    return kelas; 
  }

  public WaliMurid getWaliMurid() {
    return waliMurid;
  }

  public Nilai getNilaiMean() {
    return nilaiMean;
  }

  public void setKelas(Kelas kelas) {
    this.kelas = kelas;
  }

  public void setWaliMurid(WaliMurid waliMurid) {
    this.waliMurid = waliMurid;
  }

  public void setNilaiMean(Nilai nilaiMean) {
    this.nilaiMean = nilaiMean;
  }

  // CRUD
  
  public static Siswa getSiswaById(Connection connection, int id) throws SQLException {
    String query = "SELECT * FROM siswa WHERE id = ?";

    PreparedStatement preparedStatement = connection.prepareStatement(query);
    preparedStatement.setInt(1, id);

    ResultSet resultSet = preparedStatement.executeQuery();

    if (resultSet.next()) {
      int idSiswa = resultSet.getInt("id");
      String nama = resultSet.getString("nama");
      String email = resultSet.getString("email");
      String phone = resultSet.getString("phone");

      WaliMurid waliMurid = new WaliMurid(
        resultSet.getInt("id_wali"),
        resultSet.getString("nama"),
        resultSet.getString("phone"),
        resultSet.getString("email"),
        new ArrayList<Siswa>()
        );
      
      Nilai nilaiMean = new Nilai(
        resultSet.getInt("id_nilai"),
        resultSet.getDouble("nilai"),
        resultSet.getDouble("nilai_mean"),
        new ArrayList<Siswa>()
        );

      Kelas kelas = new Kelas(
        resultSet.getInt("id_kelas"),
        resultSet.getString("tingkat"),
        resultSet.getInt("urutan"),
        resultSet.getBoolean("is_ipa"),
        new ArrayList<Guru>(),
        new ArrayList<Siswa>(),
        new ArrayList<MataPelajaran>()
      );

      return new Siswa(idSiswa, nama, kelas, email, phone, waliMurid, nilaiMean);
    } else {
      return null;
    }
  }
}
