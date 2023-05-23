package com.project.model;

/**
 * MataPelajaran
 */
public class MataPelajaran {

  private String namaMapel;
  private Kelas jenisKelas;

  public MataPelajaran(String namaMapel, Kelas jenisKelas) {
    this.namaMapel = namaMapel;
    this.jenisKelas = jenisKelas;
  }

  public String getNamaMapel(){
    return namaMapel;
  }

  public void setNamaMapel(String namaMapel){
    this.namaMapel = namaMapel;
  }

  public Kelas getJenisKelas(){
    return jenisKelas;
  }
}
