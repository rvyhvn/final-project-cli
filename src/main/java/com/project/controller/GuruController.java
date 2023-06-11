package com.project.controller;

import com.project.dao.GuruDAO;
import com.project.model.Guru;

import java.sql.Connection;
import java.util.List;

public class GuruController {

    private GuruDAO guruDAO;
    private Connection connection;

    public GuruController(Connection connection) {
        this.connection = connection;
        guruDAO = new GuruDAO(connection);
    }

    public void addGuru(String nama, String phone, String email) {
        Guru guru = new Guru(0, nama, email, phone, null, null);
        guruDAO.addGuru(guru);
    }

    public void updateGuru(int idGuru, String nama, String phone, String email) {
        Guru guru = guruDAO.getGuruById(idGuru);
        if (guru != null) {
            guru.setNama(nama);
            guru.setPhone(phone);
            guru.setEmail(email);
            guruDAO.updateGuru(guru);
        } else {
            System.out.println("Guru dengan ID " + idGuru + " tidak ditemukan");
        }
    }

    public void deleteGuru(int idGuru) {
        Guru guru = guruDAO.getGuruById(idGuru);
        if (guru != null) {
            guruDAO.deleteGuru(idGuru);
        } else {
            System.out.println("Guru dengan ID " + idGuru + " tidak ditemukan");
        }
    }

    public void getAllGuru() {
        List<Guru> guruList = guruDAO.getAllGuru();
        if (guruList.isEmpty()) {
            System.out.println("Tidak ada data guru");
        } else {
            for (Guru guru : guruList) {
                System.out.println("ID Guru: " + guru.getIdGuru());
                System.out.println("Nama: " + guru.getNama());
                System.out.println("Email: " + guru.getEmail());
                System.out.println("Phone: " + guru.getPhone());
                System.out.println("--------------------");
            }
        }
    }
}
