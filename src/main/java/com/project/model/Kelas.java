package com.project.model;

public class Kelas {
    private int id;
    private String nama;
    private String jenisKelas;
    private Guru guru;
    private Siswa siswa;

    public Kelas(int id, String nama,Guru guru, Siswa siswa) {
        this.id = id;
        this.nama = nama;
        this.guru = guru;
        this.siswa = siswa;
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

    public String getJenisKelas(){
      return jenisKelas;
    }

    public void setJenisKelas(String jenisKelas){
      this.jenisKelas = jenisKelas;
    }

    public Guru getEmail() {
        return guru;
    }

    public void setEmail(Guru guru) {
        this.guru = guru;
    }

    public Siswa getSiswa() {
        return siswa;
    }

    public void setSiswa(Siswa siswa) {
        this.siswa = siswa;
    }
    
}
