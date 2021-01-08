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
public class KhieuNai {
    private int id;
    private int id_sinhvien;
    private String tieu_de;
    private String noi_dung;
    private Date ngay_tao;
    private Date ngay_cap_nhat;

    public KhieuNai() {
    }

    public KhieuNai(int id, int id_sinhvien, String tieu_de, String noi_dung, Date ngay_tao, Date ngay_cap_nhat) {
        this.id = id;
        this.id_sinhvien = id_sinhvien;
        this.tieu_de = tieu_de;
        this.noi_dung = noi_dung;
        this.ngay_tao = ngay_tao;
        this.ngay_cap_nhat = ngay_cap_nhat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_sinhvien() {
        return id_sinhvien;
    }

    public void setId_sinhvien(int id_sinhvien) {
        this.id_sinhvien = id_sinhvien;
    }

    public String getTieu_de() {
        return tieu_de;
    }

    public void setTieu_de(String tieu_de) {
        this.tieu_de = tieu_de;
    }

    public String getNoi_dung() {
        return noi_dung;
    }

    public void setNoi_dung(String noi_dung) {
        this.noi_dung = noi_dung;
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

    
}
