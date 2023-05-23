package com.project.model;

/**
 * MataPelajaran
 */
public class MataPelajaran {
  
  private int id;
  private String namaMapel;
  private Kelas jenisKelas;

  public MataPelajaran(int id, String namaMapel, Kelas jenisKelas) {
    this.id = id;
    this.namaMapel = namaMapel;
    this.jenisKelas = jenisKelas;
  }

  public int getId(){
    return id;
  }

  public void setId(int id){
    this.id = id;
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
