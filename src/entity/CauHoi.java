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
public class CauHoi {
    private int id;
    private int id_mon;
    private int id_hang;
    private String noi_dung;
    private Date ngay_tao;
    private Date ngay_cap_nhat;
    private String ghi_chu;
    private boolean trang_thai;

    public CauHoi() {
    }

    public CauHoi(int id) {
        this.id = id;
    }

    
    public CauHoi(int id, int id_mon, int id_hang,  String noi_dung, Date ngay_tao, Date ngay_cap_nhat, String ghi_chu, boolean trang_thai) {
        this.id = id;
        this.id_mon = id_mon;
        this.id_hang = id_hang;
        this.noi_dung = noi_dung;
        this.ngay_tao = ngay_tao;
        this.ngay_cap_nhat = ngay_cap_nhat;
        this.ghi_chu = ghi_chu;
        this.trang_thai = trang_thai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_mon() {
        return id_mon;
    }

    public void setId_mon(int id_mon) {
        this.id_mon = id_mon;
    }

    public int getId_hang() {
        return id_hang;
    }

    public void setId_hang(int id_hang) {
        this.id_hang = id_hang;
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

    @Override
    public String toString() {
        return this.noi_dung = noi_dung;
    }
    
    
}
