package com.project.model;

/**
 * Kelas
 */
public class Kelas {

  private int idKelas;
  private String tingkat;
  private int urutan;
  private boolean isIpa;
  private Guru guru;
  private Siswa siswa;

  public Kelas(int idKelas, String tingkat, int urutan, boolean isIpa, Guru guru, Siswa siswa) {
    this.idKelas = idKelas;
    this.tingkat = tingkat;
    this.urutan = urutan;
    this.isIpa = isIpa;
    this.guru = guru;
    this.siswa = siswa;
  }

  public int getIdKelas(){
    return idKelas;
  }

  public String getTingkat(){
    return tingkat;
  }

  public int getUrutan(){
    return urutan;
  }

  public boolean getIsIpa(){
    return isIpa;
  }

  public Guru getGuru(){
    return guru; 
  }
}
