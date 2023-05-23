package com.project.model;

import java.util.Date;

/**
 * Laporan
 */
public class Laporan {

  private int id;
  private Siswa siswa;
  private Guru guru;
  private Kelas kelas;
  private Nilai nilai;
  private Date tanggal;

  public Laporan(int id, Siswa siswa, Guru guru, Kelas kelas, Nilai nilai, Date tanggal) {
    this.id = id;
    this.siswa = siswa;
    this.guru = guru;
    this.kelas = kelas;
    this.nilai = nilai;
    this.tanggal = tanggal;
  }

  public int getId(){
    return id;
  }

  public void setId(int id){
    this.id = id;
  }

  public Siswa getSiswa(){
    return siswa;
  }

  public Guru getGuru(){
    return guru;
  }

  public Kelas getKelas(){
    return kelas;
  }

  public Nilai getNilai(){
    return nilai;
  }

  public Date getTanggal(){
    return tanggal;
  }

  public void setTanggal(Date tanggal){
    this.tanggal = tanggal;
  }
}
