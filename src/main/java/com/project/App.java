package com.project;

import com.project.model.*;
import com.project.controller.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;


public class App {
    public static void main(String[] args) {
    
    Kelas kelas10 = new Kelas(1, "X", 3, true, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

    // Membuat objek WaliMurid
    WaliMurid waliMurid1 = new WaliMurid(1, "John Doe", "john@gmail,com", "0812345678", new ArrayList<>());

    // Membuat objek Nilai
    Nilai nilaiMean1 = new Nilai(1, 100.0, 70.0);

    // Membuat objek Siswa
    Siswa siswa = new Siswa(1, "John Smith", kelas10, "john.smith@example.com", "987654321", waliMurid1, nilaiMean1);

    // Membuat objek Guru
    Guru guru = new Guru(1, "Jane Doe", "jane@gmail.com", "0812345678", null, null);

    // Membuat objek Nilai
    Nilai nilai = new Nilai(1, 90.0, 80.0);
    
    // Membuat objek Laporan
    int idLaporan = 1;
    Date tanggal = new Date();
    Laporan laporan = new Laporan(idLaporan, tanggal, kelas10, siswa, guru, nilai);

    // Ekspor ke CSV
    String filePath = "output.csv";
    try {
        laporan.exportToCSV(filePath);
        System.out.println("Laporan berhasil diekspor ke " + filePath);
    } catch (IOException e) {
        System.out.println("Terjadi kesalahan saat mencoba mengekspor laporan: " + e.getMessage());
    }


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
