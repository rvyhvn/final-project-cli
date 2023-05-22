package com.project;

import java.sql.*;
import java.util.Scanner;

public class MenuGuardian {
    private static Scanner scanner = new Scanner(System.in);
    private Connection connection;

    public MenuGuardian(Connection connection) {
      this.connection = connection;
    }

    public void displayMenu(Connection connection) {
        try {
            while (true) {
                System.out.println("Menu Guardian:");
                System.out.println("1. Lihat Daftar Wali Murid");
                System.out.println("2. Tambah Data Wali");
                System.out.println("3. Ubah Data Wali");
                System.out.println("4. Hapus Data Wali");
                System.out.println("5. Kembali ke menu utama");
                System.out.print("Pilih menu: ");
                int pilihan = scanner.nextInt();

                if (pilihan == 1) {
                    lihatDaftarWali(connection);
                } else if (pilihan == 2) {
                    tambahDataWali(connection);
                } else if (pilihan == 3) {
                    ubahDataWali(connection);
                } else if (pilihan == 4) {
                    hapusDataWali(connection);
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

    public static void lihatDaftarWali(Connection connection) throws SQLException {
        String query = "SELECT * FROM guardian ORDER BY id ASC";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        System.out.println("Daftar Wali Murid:");
        System.out.println("ID\tNama\t\t\t\t\tEmail\t\t\tNomor Telepon");

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String nama = resultSet.getString("nama");
            String email = resultSet.getString("email");
            String telepon = resultSet.getString("phone");

            System.out.println(id + "\t" + nama + "\t\t" + "\t\t\t" + "\t\t" + email + "\t\t" + telepon);
        }

        resultSet.close();
        statement.close();
    }

    public static void tambahDataWali(Connection connection) throws SQLException {
        scanner.nextLine(); // Membuang new line

        System.out.print("Nama: ");
        String nama = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Nomor Telepon: ");
        String telepon = scanner.nextLine();

        Guardian wali = new Guardian();
        wali.setNama(nama);
        wali.setEmail(email);
        wali.setPhone(telepon);

        wali.tambahGuardian(connection);

        System.out.println("Data wali murid berhasil ditambahkan.");
    }

    public static void ubahDataWali(Connection connection) throws SQLException {
        scanner.nextLine(); // Membuang new line

        System.out.print("ID Wali Murid yang akan diubah: ");
        int id = scanner.nextInt();

        Guardian wali = Guardian.getGuardianById(connection, id);

        if (wali == null) {
            System.out.println("Data wali murid dengan ID tersebut tidak ditemukan.");
            return;
        }

        System.out.println("Data Wali Murid:");
        System.out.println("Nama: " + wali.getNama());
        System.out.println("Email: " + wali.getEmail());
        System.out.println("Nomor Telepon: " + wali.getPhone());

        scanner.nextLine(); // Membuang new line

        System.out.print("Nama baru (kosongkan jika tidak ingin mengubah): ");
        String nama = scanner.nextLine();

        System.out.print("Email baru (kosongkan jika tidak ingin mengubah): ");
        String email = scanner.nextLine();

        System.out.print("Nomor Telepon baru (kosongkan jika tidak ingin mengubah): ");
        String telepon = scanner.nextLine();

        if (!nama.isEmpty()) {
            wali.setNama(nama);
        }

        if (!email.isEmpty()) {
            wali.setEmail(email);
        }

        if (!telepon.isEmpty()) {
            wali.setPhone(telepon);
        }

        wali.updateGuardian(connection);

        System.out.println("Data wali murid berhasil diubah.");
    }

    public static void hapusDataWali(Connection connection) throws SQLException {
        System.out.print("ID Wali Murid yang akan dihapus: ");
        int id = scanner.nextInt();

        Guardian wali = Guardian.getGuardianById(connection, id);

        if (wali == null) {
            System.out.println("Data wali murid dengan ID tersebut tidak ditemukan.");
            return;
        }

        wali.hapusGuardian(connection);

        System.out.println("Data wali murid berhasil dihapus.");
    }
}
