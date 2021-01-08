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
public class PhanQuyenChiTiet {
    private int id_quyen;
    private int id_gv;
    private Date ngay_cap_nhat;
    private String ghi_chu;

    public PhanQuyenChiTiet() {
    }

    public PhanQuyenChiTiet(int id_quyen, int id_gv, Date ngay_cap_nhat, String ghi_chu) {
        this.id_quyen = id_quyen;
        this.id_gv = id_gv;
        this.ngay_cap_nhat = ngay_cap_nhat;
        this.ghi_chu = ghi_chu;
    }

    public int getId_quyen() {
        return id_quyen;
    }

    public void setId_quyen(int id_quyen) {
        this.id_quyen = id_quyen;
    }

    public int getId_gv() {
        return id_gv;
    }

    public void setId_gv(int id_gv) {
        this.id_gv = id_gv;
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
    
    
}
