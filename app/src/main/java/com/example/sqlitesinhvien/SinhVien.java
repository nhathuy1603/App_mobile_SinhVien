package com.example.sqlitesinhvien;

import java.io.Serializable;

public class SinhVien implements Serializable {
    private String maSV156;
    private String tenSV156;
    private String mota156;
    private int diem;
    private String maLop;

    public SinhVien(String maSV110, String tenSV110, String mota110, int diem, String maLop) {
        this.maSV156 = maSV156;
        this.tenSV156 = tenSV156;
        this.mota156 = mota156;
        this.diem = diem;
        this.maLop = maLop;
    }

    public String getMaSV156() {
        return maSV156;
    }

    public void setMaSV156(String maSV110) {
        this.maSV156 = maSV156;
    }

    public String getTenSV156() {
        return tenSV156;
    }

    public void setTenSV156(String tenSV110) {
        this.tenSV156 = tenSV156;
    }

    public String getMota156() {
        return mota156;
    }

    public void setMota156(String mota156) {
        this.mota156 = mota156;
    }

    public int getDiem() {
        return diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }
}
