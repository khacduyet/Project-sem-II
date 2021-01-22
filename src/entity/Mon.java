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
public class Mon {
    private int id;
    private String ten_mon;
    private String noi_dung;
    private String mota;
    private Date ngay_tao;
    private Date ngay_cap_nhat;
    private boolean trang_thai;

    public Mon() {
    }

    public Mon(int id, String ten_mon, String noi_dung, String mota, Date ngay_tao, Date ngay_cap_nhat, boolean trang_thai) {
        this.id = id;
        this.ten_mon = ten_mon;
        this.noi_dung = noi_dung;
        this.mota = mota;
        this.ngay_tao = ngay_tao;
        this.ngay_cap_nhat = ngay_cap_nhat;
        this.trang_thai = trang_thai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen_mon() {
        return ten_mon;
    }

    public void setTen_mon(String ten_mon) {
        this.ten_mon = ten_mon;
    }

    public String getNoi_dung() {
        return noi_dung;
    }

    public void setNoi_dung(String noi_dung) {
        this.noi_dung = noi_dung;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
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

    @Override
    public String toString() {
        return this.ten_mon = ten_mon;
    }
    
    
    
}
