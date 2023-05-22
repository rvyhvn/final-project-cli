package com.project.model;

public class Guru {
    private int id;
    private String nama;
    private String email;
    private String phone;

    public Guru(int id, String nama, String email, String phone) {
        this.id = id;
        this.nama = nama;
        this.email = email;
        this.phone = phone;
    }

    // Getter dan setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
}
