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
public class DapAn {
    private int id;
    private int id_cauhoi;
    private String noi_dung;
    private boolean dap_an; // dung hoac sai

    public DapAn() {
    }

    public DapAn(int id, int id_cauhoi, String noi_dung, boolean dap_an) {
        this.id = id;
        this.id_cauhoi = id_cauhoi;
        this.noi_dung = noi_dung;
        this.dap_an = dap_an;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_cauhoi() {
        return id_cauhoi;
    }

    public void setId_cauhoi(int id_cauhoi) {
        this.id_cauhoi = id_cauhoi;
    }

    public String getNoi_dung() {
        return noi_dung;
    }

    public void setNoi_dung(String noi_dung) {
        this.noi_dung = noi_dung;
    }

    public boolean isDap_an() {
        return dap_an;
    }

    public void setDap_an(boolean dap_an) {
        this.dap_an = dap_an;
    }
    
    
}
