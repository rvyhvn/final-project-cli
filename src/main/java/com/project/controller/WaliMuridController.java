package com.project.controller;

import com.project.dao.WaliMuridDAO;
import com.project.model.WaliMurid;

import java.sql.Connection;
import java.util.List;

public class WaliMuridController {

    private WaliMuridDAO waliMuridDAO;

    public WaliMuridController(Connection connection) {
        this.waliMuridDAO = new WaliMuridDAO(connection);
    }

    public void addWaliMurid(int idWali, String nama, String email, String phone) {
        WaliMurid waliMurid = new WaliMurid(idWali, nama, email, phone, null);
        waliMuridDAO.addWaliMurid(waliMurid);
    }

    public void updateWaliMurid(int idWali, String nama, String email, String phone) {
        WaliMurid waliMurid = new WaliMurid(idWali, nama, email, phone, null);
        waliMuridDAO.updateWaliMurid(waliMurid);
    }

    public void deleteWaliMurid(int idWali) {
        waliMuridDAO.deleteWaliMurid(idWali);
    }

    public void getAllWaliMurid() {
        List<WaliMurid> waliMuridList = waliMuridDAO.getAllWaliMurid();
        if (waliMuridList.isEmpty()) {
            System.out.println("Tidak ada data wali murid");
        } else {
            for (WaliMurid waliMurid : waliMuridList) {
                System.out.println("ID Wali Murid: " + waliMurid.getIdWali());
                System.out.println("Nama: " + waliMurid.getNama());
                System.out.println("Email: " + waliMurid.getEmail());
                System.out.println("Phone: " + waliMurid.getPhone());
                System.out.println("--------------------");
            }
        }
    }
}
