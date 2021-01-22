/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImp;

import dao.CauHoiDAO;
import entity.CauHoi;
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
public class CauHoiImplDAO implements CauHoiDAO {

    private Connection con;

    public CauHoiImplDAO() {
    }

    public CauHoiImplDAO(Connection con) {
        this.con = con;
    }

    @Override
    public List<CauHoi> getAll() {
        List<CauHoi> results = new ArrayList<>();
        try {
            CallableStatement cs = con.prepareCall("{CALL getAllCauHoi}");
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                CauHoi ch = new CauHoi(rs.getInt("id"), rs.getInt("id_mon"), rs.getInt("id_hang"),
                        rs.getString("noi_dung"), rs.getDate("ngay_tao"), rs.getDate("ngay_cap_nhat"), rs.getString("ghi_chu"), rs.getBoolean("trang_thai"));
                results.add(ch);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CauHoiImplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return results;
    }

    @Override
    public CauHoi getById(int key) {
        CauHoi ch = null;
        try {
            CallableStatement cs = con.prepareCall("{CALL getByIdCauHoi(?)}");
            cs.setInt(1, key);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                ch = new CauHoi(rs.getInt("id"), rs.getInt("id_mon"), rs.getInt("id_hang"),
                        rs.getString("noi_dung"), rs.getDate("ngay_tao"), rs.getDate("ngay_cap_nhat"), rs.getString("ghi_chu"), rs.getBoolean("trang_thai"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CauHoiImplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ch;
    }

    @Override
    public void insert(CauHoi lp) {
        try {
            CallableStatement cs = con.prepareCall("{CALL insertCauHoi(?,?,?,?,?,?,?)}");
            cs.setInt(1, lp.getId_mon());
            cs.setInt(2, lp.getId_hang());
            cs.setString(3, lp.getNoi_dung());
            cs.setDate(4, (Date) lp.getNgay_tao());
            cs.setDate(5, (Date) lp.getNgay_cap_nhat());
            cs.setString(6, lp.getGhi_chu());
            cs.setBoolean(7, lp.isTrang_thai());
            cs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CauHoiImplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(CauHoi lp) {
        CallableStatement cs;
        try {
            cs = con.prepareCall("{CALL updateCauHoi(?,?,?,?,?,?,?,?)}");
            cs.setInt(1, lp.getId_mon());
            cs.setInt(2, lp.getId_hang());
            cs.setString(3, lp.getNoi_dung());
            cs.setDate(4, (Date) lp.getNgay_cap_nhat());
            cs.setString(5, lp.getGhi_chu());
            cs.setBoolean(6, lp.isTrang_thai());
            cs.setInt(7, lp.getId());
            cs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CauHoiImplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int id) {
        try {
            CallableStatement cs = con.prepareCall("{CALL deleteCauHoi(?)}");
            cs.setInt(1, id);
            cs.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(CauHoiImplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public CauHoi getIdInsert() {
        CauHoi ch = null;
        try {
            CallableStatement cs = con.prepareCall("{CALL idFitInsert}");
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                ch = new CauHoi(rs.getInt("id"), rs.getInt("id_mon"), rs.getInt("id_hang"),
                        rs.getString("noi_dung"), rs.getDate("ngay_tao"), rs.getDate("ngay_cap_nhat"), rs.getString("ghi_chu"), rs.getBoolean("trang_thai"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CauHoiImplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ch;
    }

    @Override
    public List<CauHoi> getAllBySubject() {
        List<CauHoi> results = new ArrayList<>();
        try {
            CallableStatement cs = con.prepareCall("{CALL getAllCauHoi}");
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                CauHoi ch = new CauHoi(rs.getInt("id"), rs.getInt("id_mon"), rs.getInt("id_hang"),
                        rs.getString("noi_dung"), rs.getDate("ngay_tao"), rs.getDate("ngay_cap_nhat"), rs.getString("ghi_chu"), rs.getBoolean("trang_thai"));
                results.add(ch);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CauHoiImplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return results;
    }
}
