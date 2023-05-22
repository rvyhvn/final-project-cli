package com.project.controller;

import com.project.model.*;
import java.sql.*;
import java.util.Scanner;

public class SiswaController {
    private static Scanner scanner = new Scanner(System.in);
    private Connection connection;

    public SiswaController(Connection connection) {
      this.connection = connection;
    }

    public void displayMenu(Connection connection) {
        try {
            while (true) {
                System.out.println("Menu Siswa:");
                System.out.println("1. Lihat Daftar Siswa");
                System.out.println("2. Tambah Data Siswa");
                System.out.println("3. Ubah Data Siswa");
                System.out.println("4. Hapus Data Siswa");
                System.out.println("5. Kembali ke menu utama");
                System.out.print("Pilih menu: ");
                int pilihan = scanner.nextInt();

                if (pilihan == 1) {
                    lihatDaftarSiswa(connection);
                } else if (pilihan == 2) {
                    tambahDataSiswa(connection);
                } else if (pilihan == 3) {
                    ubahDataSiswa(connection);
                } else if (pilihan == 4) {
                    hapusDataSiswa(connection);
                } else if (pilihan == 5) {
                    System.out.println("Anda selesai menggunakan program");
                    break;
                } else {
                    System.out.println("Menu tidak valid. Silakan pilih menu yang valid.");
                }

                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void lihatDaftarSiswa(Connection connection) throws SQLException {
        String query = "SELECT * FROM siswa ORDER BY id ASC";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        System.out.println("Daftar Siswa:");
        System.out.println("ID\tNama\t\t\tKelas\t\t\tNilai Akhir\t\t\tEmail\t\t\tGuardian ID");

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String nama = resultSet.getString("nama");
            String kelas = resultSet.getString("kelas");
            double nilaiAkhir = resultSet.getDouble("nilai_akhir");
            String email = resultSet.getString("email");
            int guardianId = resultSet.getInt("guardian_id");

            System.out.println(id + "\t" + nama + "\t\t" + kelas + "\t\t\t" + nilaiAkhir + "\t\t" + email + "\t\t" + guardianId);
        }

        resultSet.close();
        statement.close();
    }

    public static void tambahDataSiswa(Connection connection) throws SQLException {
        scanner.nextLine(); // Membuang new line

        System.out.print("Nama: ");
        String nama = scanner.nextLine();

        System.out.print("Kelas: ");
        String kelas = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.println("Nilai akhir siswa: ");
        double nilaiAkhir = scanner.nextDouble();

        System.out.print("ID Wali Murid: ");
        int guardianId = scanner.nextInt();

        Siswa siswa = new Siswa();
        siswa.setNama(nama);
        siswa.setKelas(kelas);
        siswa.setEmail(email);
        siswa.setNilaiAkhir(nilaiAkhir);
        siswa.setGuardianId(guardianId);

        siswa.tambahSiswa(connection);

        System.out.println("Data siswa berhasil ditambahkan.");
    }

    public static void ubahDataSiswa(Connection connection) throws SQLException {
        scanner.nextLine(); // Membuang new line

        System.out.print("ID Siswa yang akan diubah: ");
        int id = scanner.nextInt();

        Siswa siswa = Siswa.getSiswaById(connection, id);

        if (siswa == null) {
            System.out.println("Data siswa dengan ID tersebut tidak ditemukan.");
            return;
        }

        System.out.println("Data Siswa:");
        System.out.println("Nama: " + siswa.getNama());
        System.out.println("Kelas: " + siswa.getKelas());
        System.out.println("Email: " + siswa.getEmail());
        System.out.println("Nilai akhir: " + siswa.getNilaiAkhir());
        System.out.println("ID Wali Murid: " + siswa.getGuardianId());

        scanner.nextLine(); // Membuang new line

        System.out.print("Nama baru (kosongkan jika tidak ingin mengubah): ");
        String nama = scanner.nextLine();

        System.out.print("Kelas baru (kosongkan jika tidak ingin mengubah): ");
        String kelas = scanner.nextLine();

        System.out.print("Email baru (kosongkan jika tidak ingin mengubah): ");
        String email = scanner.nextLine();

        System.out.println("Nilai akhir baru: ");
        double nilaiAkhir = scanner.nextDouble();

        System.out.print("ID Wali Murid baru (kosongkan jika tidak ingin mengubah): ");
        int guardianId = scanner.nextInt();

        if (!nama.isEmpty()) {
            siswa.setNama(nama);
        }

        if (!kelas.isEmpty()) {
            siswa.setKelas(kelas);
        }

        if (!email.isEmpty()) {
            siswa.setEmail(email);
        }

        if (nilaiAkhir != 0) {
            siswa.setNilaiAkhir(nilaiAkhir);
        }
        if (guardianId != 0) {
            siswa.setGuardianId(guardianId);
        }

        siswa.updateSiswa(connection);

        System.out.println("Data siswa berhasil diubah.");
    }

    public static void hapusDataSiswa(Connection connection) throws SQLException {
        System.out.print("ID Siswa yang akan dihapus: ");
        int id = scanner.nextInt();

        Siswa siswa = Siswa.getSiswaById(connection, id);

        if (siswa == null) {
            System.out.println("Data siswa dengan ID tersebut tidak ditemukan.");
            return;
        }

        siswa.hapusSiswa(connection);

        System.out.println("Data siswa berhasil dihapus.");
    }
}
