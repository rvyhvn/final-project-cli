package com.project.view;

import com.project.*;
import com.project.controller.*;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.SQLException;

public class Menu {
    private Scanner scanner;
    private Connection connection;

    public Menu(Connection connection) {
        this.scanner = new Scanner(System.in);
        this.connection = connection;
    }



    public void displayMenu() {
        while (true) {
            System.out.println("=== MENU UTAMA ===");
            System.out.println("1. Menu Siswa");
            System.out.println("2. Menu Wali Murid");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();

            if (pilihan == 1) {
                SiswaController menuSiswa = new SiswaController(connection);
                menuSiswa.displayMenu(connection);
            } else if (pilihan == 2) {
                GuardianController menuGuardian = new GuardianController(connection);
                menuGuardian.displayMenu(connection);
            } else if (pilihan == 3) {
                System.out.println("Anda selesai menggunakan program");
                break;
            } else {
                System.out.println("Menu tidak valid. Silakan pilih menu yang valid.");
            }

            System.out.println();
        }

        scanner.close(); // Close the scanner when no longer needed
    }
}

