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
public class GiaoVien {
    private int id;
    private String ma_gv;
    private String ho_ten;
    private boolean gioi_tinh;
    private Date ngay_sinh;
    private String dien_thoai;
    private String dia_chi;
    private String email;
    private Date ngay_tao;
    private Date ngay_cap_nhat;
    private boolean trang_thai;
    private String username;
    private String password;

    public GiaoVien() {
    }

    public GiaoVien(int id, String ma_gv, String ho_ten, boolean gioi_tinh, Date ngay_sinh, String dien_thoai, String dia_chi, String email, Date ngay_tao, Date ngay_cap_nhat, boolean trang_thai, String username, String password) {
        this.id = id;
        this.ma_gv = ma_gv;
        this.ho_ten = ho_ten;
        this.gioi_tinh = gioi_tinh;
        this.ngay_sinh = ngay_sinh;
        this.dien_thoai = dien_thoai;
        this.dia_chi = dia_chi;
        this.email = email;
        this.ngay_tao = ngay_tao;
        this.ngay_cap_nhat = ngay_cap_nhat;
        this.trang_thai = trang_thai;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMa_gv() {
        return ma_gv;
    }

    public void setMa_gv(String ma_gv) {
        this.ma_gv = ma_gv;
    }

    public String getHo_ten() {
        return ho_ten;
    }

    public void setHo_ten(String ho_ten) {
        this.ho_ten = ho_ten;
    }

    public boolean isGioi_tinh() {
        return gioi_tinh;
    }

    public void setGioi_tinh(boolean gioi_tinh) {
        this.gioi_tinh = gioi_tinh;
    }

    public Date getNgay_sinh() {
        return ngay_sinh;
    }

    public void setNgay_sinh(Date ngay_sinh) {
        this.ngay_sinh = ngay_sinh;
    }

    public String getDien_thoai() {
        return dien_thoai;
    }

    public void setDien_thoai(String dien_thoai) {
        this.dien_thoai = dien_thoai;
    }

    public String getDia_chi() {
        return dia_chi;
    }

    public void setDia_chi(String dia_chi) {
        this.dia_chi = dia_chi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getNgay_tao() {
        return ngay_tao;
    }

    public void setNgay_tao(Date ngay_tao) {
        this.ngay_tao = ngay_tao;
    }

    public Date getNgay_cap_nhat() {
        return ngay_cap_nhat;
    }

    public void setNgay_cap_nhat(Date ngay_cap_nhat) {
        this.ngay_cap_nhat = ngay_cap_nhat;
    }

    public boolean isTrang_thai() {
        return trang_thai;
    }

    public void setTrang_thai(boolean trang_thai) {
        this.trang_thai = trang_thai;
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
    
    
}
