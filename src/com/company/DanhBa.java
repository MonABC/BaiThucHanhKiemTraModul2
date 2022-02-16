package com.company;

import java.io.Serializable;

public class DanhBa implements Serializable {
    private String hoVaten;
    private int SoDienThoai;
    private String diaChi;
    private String email;
    private String facebook;

    public DanhBa() {
    }

    public DanhBa(String hoVaten, int soDienThoai, String diaChi, String email, String facebook) {
        this.hoVaten = hoVaten;
        SoDienThoai = soDienThoai;
        this.diaChi = diaChi;
        this.email = email;
        this.facebook = facebook;
    }

    public String getHoVaten() {
        return hoVaten;
    }

    public void setHoVaten(String hoVaten) {
        this.hoVaten = hoVaten;
    }

    public int getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(int soDienThoai) {
        SoDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    @Override
    public String toString() {
        return "DanhBa: " +
                "họ và tên: " + hoVaten +
                ", số điện thoại: " + SoDienThoai +
                ", địa chị: " + diaChi +
                ", email: " + email +
                ", facebook: " + facebook;
    }
}
