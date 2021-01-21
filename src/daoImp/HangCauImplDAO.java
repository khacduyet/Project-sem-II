/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImp;

import dao.HangCauDAO;
import entity.HangCau;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Laptophaidang.com
 */
public class HangCauImplDAO implements HangCauDAO {

    private Connection con;

    public HangCauImplDAO() {
    }

    public HangCauImplDAO(Connection con) {
        this.con = con;
    }

    @Override
    public List<HangCau> getAll() {
        List<HangCau> results = new ArrayList<>();
        try {
            CallableStatement cs = con.prepareCall("{CALL getAllHangCau}");
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                HangCau hc = new HangCau(rs.getInt("id"), rs.getString("ma_hang"), rs.getString("mo_ta"), rs.getFloat("muc_diem"), rs.getDate("ngay_tao"), rs.getDate("ngay_cap_nhat"), rs.getBoolean("status"));
                results.add(hc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HangCauImplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return results;
    }

    @Override
    public HangCau getById(int key) {
        HangCau hc = null;
        try {
            CallableStatement cs = con.prepareCall("{CALL getByIdHangCau(?)}");
            cs.setInt(1, key);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                hc = new HangCau(rs.getInt("id"), rs.getString("ma_hang"), rs.getString("mo_ta"), rs.getFloat("muc_diem"), rs.getDate("ngay_tao"), rs.getDate("ngay_cap_nhat"), rs.getBoolean("status"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(HangCauImplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hc;
    }

    @Override
    public void insert(HangCau m) {
        try {
            CallableStatement cs = con.prepareCall("{CALL insertHangCau(?,?,?,?,?,?)}");
            cs.setString(1, m.getMa_hang());
            cs.setString(2, m.getMo_ta());
            cs.setFloat(3, m.getMuc_diem());
            cs.setDate(4, (Date) m.getNgay_tao());
            cs.setDate(5, (Date) m.getNgay_cap_nhat());
            cs.setBoolean(6, m.isStatus());
            cs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HangCauImplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(HangCau m) {
        try {
            CallableStatement cs = con.prepareCall("{CALL updateHangCau(?,?,?,?,?,?)}");
            cs.setString(1, m.getMa_hang());
            cs.setString(2, m.getMo_ta());
            cs.setFloat(3, m.getMuc_diem());
            cs.setDate(4, (Date) m.getNgay_cap_nhat());
            cs.setBoolean(5, m.isStatus());
            cs.setInt(6, m.getId());
            cs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HangCauImplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int id) {
        try {
            CallableStatement cs = con.prepareCall("{CALL deleteHangCau(?)}");
            cs.setInt(1, id);
            cs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HangCauImplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void changerStt(HangCau m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
