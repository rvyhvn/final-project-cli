package com.project.controller;

import com.project.model.*;
import java.sql.*;
import java.util.Scanner;

public class GuruController {
    private static Scanner scanner = new Scanner(System.in);
    private Connection connection;

    public GuruController(Connection connection) {
        this.connection = connection;
    }

    public void displayMenu(Connection connection) {
        try {
            while (true) {
                System.out.println("Menu Guru:");
                System.out.println("1. Lihat Daftar Guru");
                System.out.println("2. Tambah Data Guru");
                System.out.println("3. Ubah Data Guru");
                System.out.println("4. Hapus Data Guru");
                System.out.println("5. Kembali ke menu utama");
                System.out.print("Pilih menu: ");
                int pilihan = scanner.nextInt();

                if (pilihan == 1) {
                    lihatDaftarGuru(connection);
                } else if (pilihan == 2) {
                    tambahDataGuru(connection);
                } else if (pilihan == 3) {
                    ubahDataGuru(connection);
                } else if (pilihan == 4) {
                    hapusDataGuru(connection);
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

    public static void lihatDaftarGuru(Connection connection) throws SQLException {
        String query = "SELECT * FROM guru ORDER BY id ASC";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        System.out.println("Daftar Guru:");
        System.out.println("ID\tNama\t\t\tPhone\t\t\tEmail");

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String nama = resultSet.getString("nama");
            String phone = resultSet.getString("phone");
            String email = resultSet.getString("email");

            System.out.println(id + "\t" + nama + "\t\t" + phone + "\t\t" + email);
        }

        resultSet.close();
        statement.close();
    }

    public static void tambahDataGuru(Connection connection) throws SQLException {
        scanner.nextLine(); // Membuang new line

        System.out.print("Nama: ");
        String nama = scanner.nextLine();

        System.out.print("Phone: ");
        String phone = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        Guru guru = new Guru();
        guru.setNama(nama);
        guru.setPhone(phone);
        guru.setEmail(email);

        guru.tambahGuru(connection);

        System.out.println("Data guru berhasil ditambahkan.");
    }

    public static void ubahDataGuru(Connection connection) throws SQLException {
        scanner.nextLine(); // Membuang new line

        System.out.print("ID Guru yang akan diubah: ");
        int id = scanner.nextInt();

        Guru guru = Guru.getGuruById(connection, id);

        if (guru == null) {
            System.out.println("Data guru dengan ID tersebut tidak ditemukan.");
            return;
        }

        System.out.println("Data Guru:");
        System.out.println("Nama: " + guru.getNama());
        System.out.println("Phone: " + guru.getPhone());
        System.out.println("Email: " + guru.getEmail());

        scanner.nextLine(); // Membuang new line

        System.out.print("Nama baru (kosongkan jika tidak ingin mengubah): ");
        String nama = scanner.nextLine();

        System.out.print("Phone baru (kosongkan jika tidak ingin mengubah): ");
        String phone = scanner.nextLine();

        System.out.print("Email baru (kosongkan jika tidak ingin mengubah): ");
        String email = scanner.nextLine();

        if (!nama.isEmpty()) {
            guru.setNama(nama);
        }

        if (!phone.isEmpty()) {
            guru.setPhone(phone);
        }

        if (!email.isEmpty()) {
            guru.setEmail(email);
        }

        guru.updateGuru(connection);

        System.out.println("Data guru berhasil diubah.");
    }

    public static void hapusDataGuru(Connection connection) throws SQLException {
        System.out.print("ID Guru yang akan dihapus: ");
        int id = scanner.nextInt();

        Guru guru = Guru.getGuruById(connection, id);

        if (guru == null) {
            System.out.println("Data guru dengan ID tersebut tidak ditemukan.");
            return;
        }

        guru.hapusGuru(connection);

        System.out.println("Data guru berhasil dihapus.");
    }
}
