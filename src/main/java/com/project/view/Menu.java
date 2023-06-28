package com.project.view;

import com.project.controller.*;
import java.util.Scanner;
import java.sql.*;

/**
 * Menu
 */
public class Menu {

    private SiswaController siswaController;
    private GuruController guruController;
    private Connection connection;
    public Menu() {
        siswaController = new SiswaController(connection);
        guruController = new GuruController();
    }

    public void tampilMenu() {
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("Menu:");
            System.out.println("1. Kelola Siswa");
            System.out.println("2. Kelola Guru");
            System.out.println("3. Kelola Wali Murid");
            System.out.println("0. Keluar");
            System.out.print("Masukkan pilihan Anda: ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    tampilMenuSiswa();
                    break;
                case 2:
                    tampilMenuGuru();
                    break;
                case 3:
                    tampilMenuWaliMurid();
                    break;
                case 0:
                    System.out.println("Terima kasih. Program berakhir.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    break;
            }
        } while (pilihan != 0);

        scanner.close();
    }

    private void tampilMenuSiswa() {
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\nSub Menu - Kelola Siswa:");
            System.out.println("1. Tampilkan daftar siswa");
            System.out.println("2. Tambah siswa");
            System.out.println("3. Update siswa");
            System.out.println("4. Hapus siswa");
            System.out.println("0. Kembali");
            System.out.print("Masukkan pilihan Anda: ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    // Panggil fungsi untuk menampilkan daftar siswa
                    break;
                case 2:
                    // Panggil fungsi untuk menambahkan siswa
                    break;
                case 3:
                    // Panggil fungsi untuk memperbarui siswa
                    break;
                case 4:
                    // Panggil fungsi untuk menghapus siswa
                    break;
                case 0:
                    System.out.println("Kembali ke menu utama.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    break;
            }
        } while (pilihan != 0);

        scanner.close();
    }

    private void tampilMenuGuru() {
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\nSub Menu - Kelola Guru:");
            System.out.println("1. Tampilkan daftar guru");
            System.out.println("2. Tambah guru");
            System.out.println("3. Update guru");
            System.out.println("4. Hapus guru");
            System.out.println("0. Kembali");
            System.out.print("Masukkan pilihan Anda: ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    // Panggil fungsi untuk menampilkan daftar guru
                    break;
                case 2:
                    // Panggil fungsi untuk menambahkan guru
                    break;
                case 3:
                    // Panggil fungsi untuk memperbarui guru
                    break;
                case 4:
                    // Panggil fungsi untuk menghapus guru
                    break;
                case 0:
                    System.out.println("Kembali ke menu utama.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    break;
            }
        } while (pilihan != 0);

        scanner.close();
    }

    private void tampilMenuWaliMurid() {
        System.out.println("\nSub Menu - Kelola Wali Murid:");
        // Tambahkan logika untuk submenu Wali Murid di sini (jika ada)
    }
}
