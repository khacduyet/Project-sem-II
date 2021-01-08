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
public class BoDeChiTiet {
    private int id_bode;
    private int id_cauhoi;
    private float diem;

    public BoDeChiTiet() {
    }

    public BoDeChiTiet(int id_bode, int id_cauhoi, float diem) {
        this.id_bode = id_bode;
        this.id_cauhoi = id_cauhoi;
        this.diem = diem;
    }

    public int getId_bode() {
        return id_bode;
    }

    public void setId_bode(int id_bode) {
        this.id_bode = id_bode;
    }

    public int getId_cauhoi() {
        return id_cauhoi;
    }

    public void setId_cauhoi(int id_cauhoi) {
        this.id_cauhoi = id_cauhoi;
    }

    public float getDiem() {
        return diem;
    }

    public void setDiem(float diem) {
        this.diem = diem;
    }
    
    
    
}
