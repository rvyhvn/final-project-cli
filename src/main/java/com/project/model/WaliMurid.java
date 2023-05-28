package com.project.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class WaliMurid extends Entity {
    private int id;
    private ArrayList<Siswa> anak;

    public WaliMurid(int id, String nama, String email, String phone, ArrayList<Siswa> anak) {
      super(nama, email, phone);
      this.id = id;
      this.anak = anak;
    }

    // Getter dan setter

    public int getId() {
      return id;
    }

    public void setId(int id) {
      this.id = id;
    }

    public ArrayList<Siswa> getAnak(){
      return anak;
    }

    public void setAnak(ArrayList<Siswa> anak){
      this.anak = anak;
    }
    // Metode untuk operasi CRUD

}
