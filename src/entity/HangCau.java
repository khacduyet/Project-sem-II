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
public class HangCau {

    private int id;
    private String ma_hang;
    private String mo_ta;
    private float muc_diem;
    private Date ngay_tao;
    private Date ngay_cap_nhat;
    private boolean status;

    public HangCau() {
    }

    public HangCau(int id, String ma_hang, String mo_ta, float muc_diem, Date ngay_tao, Date ngay_cap_nhat, boolean status) {
        this.id = id;
        this.ma_hang = ma_hang;
        this.mo_ta = mo_ta;
        this.muc_diem = muc_diem;
        this.ngay_tao = ngay_tao;
        this.ngay_cap_nhat = ngay_cap_nhat;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMa_hang() {
        return ma_hang;
    }

    public void setMa_hang(String ma_hang) {
        this.ma_hang = ma_hang;
    }

    public String getMo_ta() {
        return mo_ta;
    }

    public void setMo_ta(String mo_ta) {
        this.mo_ta = mo_ta;
    }

    public float getMuc_diem() {
        return muc_diem;
    }

    public void setMuc_diem(float muc_diem) {
        this.muc_diem = muc_diem;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
