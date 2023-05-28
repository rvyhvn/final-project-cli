package com.project.model;

/**
 * Entity
 */
public class Entity {

  private String nama;
  private String email;
  private String phone;

  public Entity(String nama, String email, String phone) {
    this.nama = nama;
    this.email = email;
    this.phone = phone;
  }

  public String getNama(){
    return nama;
  }

  public String getEmail(){
    return email; 
  }

  public String getPhone(){
    return phone;
  }

  public void setNama(String nama){
    this.nama = nama;
  }

  public void setEmail(String email){
    this.email = email;
  }

  public void setPhone(String phone){
    this.phone = phone;
  }

  @Override
  public String toString() {
      // TODO Auto-generated method stub
      return super.toString();
  }
}
