package com.project;

import com.project.model.*;
import com.project.controller.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;


public class App {
    public static void main(String[] args) {
    
    Kelas kelas10 = new Kelas(1, "X", 3, true, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

    // Membuat objek WaliMurid
    WaliMurid waliMurid1 = new WaliMurid(1, "John Doe", "john@gmail,com", "0812345678", new ArrayList<>());

    // Membuat objek Nilai
    Nilai nilaiMean1 = new Nilai(1, 100.0, 70.0);

    // Membuat objek Siswa
    Siswa siswa = new Siswa(1, "John Smith", kelas10, "john.smith@example.com", "987654321", waliMurid1, nilaiMean1);

    int idSiswa = siswa.getIdSiswa();
    Kelas kelasSiswa = siswa.getKelas();
    WaliMurid waliMuridSiswa = siswa.getWaliMurid();
    Nilai nilaiMeanSiswa = siswa.getNilaiMean();

    // Menampilkan informasi siswa
    System.out.println("Informasi Siswa:");
    System.out.println("ID Siswa: " + idSiswa);
    System.out.println("Nama Siswa: " + siswa.getNama());
    System.out.println("Kelas: " + kelasSiswa.getNamaKelas());
    System.out.println("Email: " + siswa.getEmail());
    System.out.println("Phone: " + siswa.getPhone());
    System.out.println("Wali Murid: " + waliMuridSiswa.getNama());
    System.out.println("Nilai Mean: " + nilaiMeanSiswa.getNilai());
    }
}
