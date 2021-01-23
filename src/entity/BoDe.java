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
public class BoDe {
    private int id;
    private int id_giangvien;
    private String noi_dung;
    private Date ngay_tao;
    private Date ngay_cap_nhat;
    private String mo_ta;
    private boolean trang_thai;

    public BoDe() {
    }

    public BoDe(int id, int id_giangvien, String noi_dung, Date ngay_tao, Date ngay_cap_nhat, String mo_ta, boolean trang_thai) {
        this.id = id;
        this.id_giangvien = id_giangvien;
        this.noi_dung = noi_dung;
        this.ngay_tao = ngay_tao;
        this.ngay_cap_nhat = ngay_cap_nhat;
        this.mo_ta = mo_ta;
        this.trang_thai = trang_thai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_giangvien() {
        return id_giangvien;
    }

    public void setId_giangvien(int id_giangvien) {
        this.id_giangvien = id_giangvien;
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

    public String getMo_ta() {
        return mo_ta;
    }

    public void setMo_ta(String mo_ta) {
        this.mo_ta = mo_ta;
    }

    public boolean isTrang_thai() {
        return trang_thai;
    }

    public void setTrang_thai(boolean trang_thai) {
        this.trang_thai = trang_thai;
    }
    
    @Override
    public String toString(){
        return noi_dung;
    }
}
