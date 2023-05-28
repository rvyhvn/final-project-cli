package com.project.model;

/**
 * MataPelajaran
 */
public class MataPelajaran {
  
  private int id;
  private String namaMapel;
  private Kelas kelas;

  public MataPelajaran(int id, String namaMapel, Kelas kelas) {
    this.id = id;
    this.namaMapel = namaMapel;
    this.kelas = kelas;
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

  public Kelas getKelas(){
    return kelas;
  }
}
