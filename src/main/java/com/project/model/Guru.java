package com.project.model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import com.project.model.Kelas;
import com.project.model.Laporan;
/**
 * Guru
 */
public class Guru extends Entity {

  private int idGuru;
  private ArrayList<Kelas> kelas;
  private ArrayList<Laporan> laporan;

  public Guru(int idGuru, String nama, String email, String phone, ArrayList<Kelas> kelas, ArrayList<Laporan> laporan) {
    super(nama, email, phone);
    this.idGuru = idGuru;
    this.kelas = kelas;
    this.laporan = laporan;
  }

  public Guru() {
    super("", "", "");
    this.idGuru = 0;
    this.kelas = new ArrayList<>();
    this.laporan = new ArrayList<>();
  }

  public int getIdGuru(){
    return idGuru;
  }

  public void setIdGuru(int idGuru){
    this.idGuru = idGuru;
  }

  public ArrayList<Kelas> getKelas(){
    return kelas;
  }

  public void setKelas(ArrayList<Kelas> kelas){
    this.kelas = kelas;
  }

  public ArrayList<Laporan> getLaporan(){
    return laporan;
  }

  public void setLaporan(ArrayList<Laporan> laporan){
    this.laporan = laporan;
  }
}
