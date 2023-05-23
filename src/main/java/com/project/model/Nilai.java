package com.project.model;

/**
 * Nilai
 */
public class Nilai {

  private double nilai;
  private MataPelajaran mataPelajaran;
  private Siswa siswa;

  public Nilai(double nilai, MataPelajaran mataPelajaran, Siswa siswa) {
    this.nilai = nilai;
    this.mataPelajaran = mataPelajaran;
    this.siswa = siswa;
  }

  public double getNilai(){
    return nilai;
  }

  public void setNilai(double nilai){
    this.nilai = nilai;
  }

  public MataPelajaran getMataPelajaran(){
    return mataPelajaran;
  }

  public Siswa getSiswa(){
    return siswa;
  }
}
