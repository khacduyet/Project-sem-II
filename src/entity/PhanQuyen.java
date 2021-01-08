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
public class PhanQuyen {
    private int id_quyen;
    private String ma_quyen;
    private String mo_ta;

    public PhanQuyen() {
    }

    public PhanQuyen(int id_quyen, String ma_quyen, String mo_ta) {
        this.id_quyen = id_quyen;
        this.ma_quyen = ma_quyen;
        this.mo_ta = mo_ta;
    }

    public int getId_quyen() {
        return id_quyen;
    }

    public void setId_quyen(int id_quyen) {
        this.id_quyen = id_quyen;
    }

    public String getMa_quyen() {
        return ma_quyen;
    }

    public void setMa_quyen(String ma_quyen) {
        this.ma_quyen = ma_quyen;
    }

    public String getMo_ta() {
        return mo_ta;
    }

    public void setMo_ta(String mo_ta) {
        this.mo_ta = mo_ta;
    }
    
    
}
