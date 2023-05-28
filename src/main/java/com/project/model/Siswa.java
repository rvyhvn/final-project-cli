package com.project.model;

/**
 * Siswa
 */
public class Siswa extends Entity {

  private int idSiswa;
  private Kelas kelas;
  private WaliMurid waliMurid;
  private Nilai nilaiMean;

  public Siswa(int idSiswa, String nama, Kelas kelas, String email, String phone, WaliMurid waliMurid, Nilai nilaiMean) {
    super(nama, email, phone); 
    this.idSiswa = idSiswa;
    this.waliMurid = waliMurid;
    this.nilaiMean = nilaiMean;
  }

  public int getIdSiswa(){
    return idSiswa;
  }

  public Kelas getKelas(){
   return kelas; 
  }

  public WaliMurid getWaliMurid(){
    return waliMurid;
  }

  public void setKelas(Kelas kelas){
    this.kelas = kelas;
  }

  public void setWaliMurid(WaliMurid waliMurid){
    this.waliMurid = waliMurid;
  }
}
