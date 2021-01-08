/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author Laptophaidang.com
 */
public class SinhVien {
    private int id;
    private String ma_sv;
    private int id_lop;
    private String ho_ten;
    private boolean gioi_Tinh;
    private Date ngay_sinh;
    private Date ngay_nhap_hoc;
    private Date ngay_cap_nhat;
    private String di_dong;
    private String dt_gia_dinh;
    private String email;
    private String dia_chi;
    private String avatar;
    private String username;
    private String password;
    private String ghi_chu;
    private boolean trang_thai;

    public SinhVien() {
    }

    public SinhVien(int id, String ma_sv, int id_lop, String ho_ten, boolean gioi_Tinh, Date ngay_sinh, Date ngay_nhap_hoc, Date ngay_cap_nhat, String di_dong, String dt_gia_dinh, String email, String dia_chi, String avatar, String username, String password, String ghi_chu, boolean trang_thai) {
        this.id = id;
        this.ma_sv = ma_sv;
        this.id_lop = id_lop;
        this.ho_ten = ho_ten;
        this.gioi_Tinh = gioi_Tinh;
        this.ngay_sinh = ngay_sinh;
        this.ngay_nhap_hoc = ngay_nhap_hoc;
        this.ngay_cap_nhat = ngay_cap_nhat;
        this.di_dong = di_dong;
        this.dt_gia_dinh = dt_gia_dinh;
        this.email = email;
        this.dia_chi = dia_chi;
        this.avatar = avatar;
        this.username = username;
        this.password = password;
        this.ghi_chu = ghi_chu;
        this.trang_thai = trang_thai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMa_sv() {
        return ma_sv;
    }

    public void setMa_sv(String ma_sv) {
        this.ma_sv = ma_sv;
    }

    public int getId_lop() {
        return id_lop;
    }

    public void setId_lop(int id_lop) {
        this.id_lop = id_lop;
    }

    public String getHo_ten() {
        return ho_ten;
    }

    public void setHo_ten(String ho_ten) {
        this.ho_ten = ho_ten;
    }

    public boolean isGioi_Tinh() {
        return gioi_Tinh;
    }

    public void setGioi_Tinh(boolean gioi_Tinh) {
        this.gioi_Tinh = gioi_Tinh;
    }

    public Date getNgay_sinh() {
        return ngay_sinh;
    }

    public void setNgay_sinh(Date ngay_sinh) {
        this.ngay_sinh = ngay_sinh;
    }

    public Date getNgay_nhap_hoc() {
        return ngay_nhap_hoc;
    }

    public void setNgay_nhap_hoc(Date ngay_nhap_hoc) {
        this.ngay_nhap_hoc = ngay_nhap_hoc;
    }

    public Date getNgay_cap_nhat() {
        return ngay_cap_nhat;
    }

    public void setNgay_cap_nhat(Date ngay_cap_nhat) {
        this.ngay_cap_nhat = ngay_cap_nhat;
    }

    public String getDi_dong() {
        return di_dong;
    }

    public void setDi_dong(String di_dong) {
        this.di_dong = di_dong;
    }

    public String getDt_gia_dinh() {
        return dt_gia_dinh;
    }

    public void setDt_gia_dinh(String dt_gia_dinh) {
        this.dt_gia_dinh = dt_gia_dinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDia_chi() {
        return dia_chi;
    }

    public void setDia_chi(String dia_chi) {
        this.dia_chi = dia_chi;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGhi_chu() {
        return ghi_chu;
    }

    public void setGhi_chu(String ghi_chu) {
        this.ghi_chu = ghi_chu;
    }

    public boolean isTrang_thai() {
        return trang_thai;
    }

    public void setTrang_thai(boolean trang_thai) {
        this.trang_thai = trang_thai;
    }
    
    
}
