package com.project;

import com.project.controller.*;
import com.project.util.*;
import com.project.model.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class App {
    public static void main(String[] args) {
        try {
            Connection connection = DatabaseUtil.getConnection();
            WaliMuridController waliMuridController = new WaliMuridController(connection);

            // Memanggil fungsi getAllWaliMurid untuk mendapatkan daftar semua wali murid
            List<WaliMurid> waliMuridList = waliMuridController.getAllWaliMurid();

            // Iterasi melalui daftar wali murid dan cetak informasi setiap wali murid
            for (WaliMurid waliMurid : waliMuridList) {
                System.out.println("ID Wali: " + waliMurid.getIdWali());
                System.out.println("Nama: " + waliMurid.getNama());
                System.out.println("Email: " + waliMurid.getEmail());
                System.out.println("No. Telepon: " + waliMurid.getPhone());
                System.out.println("--------------------");
            }

            waliMuridController.closeConnection(); // Tutup koneksi setelah selesai
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
