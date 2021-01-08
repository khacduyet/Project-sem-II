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
public class KetQua {
    private int id_sv;
    private int id_bode;
    private Date ngay_thi;
    private float tong_diem;

    public KetQua() {
    }

    public KetQua(int id_sv, int id_bode, Date ngay_thi, float tong_diem) {
        this.id_sv = id_sv;
        this.id_bode = id_bode;
        this.ngay_thi = ngay_thi;
        this.tong_diem = tong_diem;
    }

    public int getId_sv() {
        return id_sv;
    }

    public void setId_sv(int id_sv) {
        this.id_sv = id_sv;
    }

    public int getId_bode() {
        return id_bode;
    }

    public void setId_bode(int id_bode) {
        this.id_bode = id_bode;
    }

    public Date getNgay_thi() {
        return ngay_thi;
    }

    public void setNgay_thi(Date ngay_thi) {
        this.ngay_thi = ngay_thi;
    }

    public float getTong_diem() {
        return tong_diem;
    }

    public void setTong_diem(float tong_diem) {
        this.tong_diem = tong_diem;
    }
    
    
}
