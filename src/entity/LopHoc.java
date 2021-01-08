/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Laptophaidang.com
 */
public class LopHoc {
    private int id;
    private String ten_lop;
    private String khoa_hoc;
    private int nien_khoa;
    private boolean trang_thai;

    public LopHoc() {
    }

    public LopHoc(int id, String ten_lop, String khoa_hoc, int nien_khoa, boolean trang_thai) {
        this.id = id;
        this.ten_lop = ten_lop;
        this.khoa_hoc = khoa_hoc;
        this.nien_khoa = nien_khoa;
        this.trang_thai = trang_thai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen_lop() {
        return ten_lop;
    }

    public void setTen_lop(String ten_lop) {
        this.ten_lop = ten_lop;
    }

    public String getKhoa_hoc() {
        return khoa_hoc;
    }

    public void setKhoa_hoc(String khoa_hoc) {
        this.khoa_hoc = khoa_hoc;
    }

    public int getNien_khoa() {
        return nien_khoa;
    }

    public void setNien_khoa(int nien_khoa) {
        this.nien_khoa = nien_khoa;
    }

    public boolean isTrang_thai() {
        return trang_thai;
    }

    public void setTrang_thai(boolean trang_thai) {
        this.trang_thai = trang_thai;
    }
    
    
}
