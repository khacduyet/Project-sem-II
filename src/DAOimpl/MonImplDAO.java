/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOimpl;

import dao.MonHocDAO;
import entity.Mon;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
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
public class MonImplDAO implements MonHocDAO {

    private Connection con;

    public MonImplDAO() {
    }

    public MonImplDAO(Connection con) {
        this.con = con;
    }

    @Override
    public List<Mon> getAll() {
        List<Mon> results = new ArrayList<>();
        try {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM tbl_mon");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Mon mon = new Mon(rs.getInt("id"), rs.getString("ten_mon"), rs.getString("noi_dung"), rs.getString("mo_ta"), rs.getDate("ngay_tao"), rs.getDate("ngay_cap_nhat"), rs.getBoolean("trang_thai"));
                results.add(mon);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MonImplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return results;
    }

    @Override
    public Mon getById(int key) {
        Mon mon = null;
        try {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM tbl_mon WHERE id = ?");
            pst.setInt(1, key);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                mon = new Mon(rs.getInt("id"), rs.getString("ten_mon"), rs.getString("noi_dung"), rs.getString("mo_ta"), rs.getDate("ngay_tao"), rs.getDate("ngay_cap_nhat"), rs.getBoolean("trang_thai"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MonImplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mon;
    }

    @Override
    public void insert(Mon m) {
        PreparedStatement pst;
        try {
            pst = con.prepareStatement("INSERT INTO tbl_mon VALUES(?,?,?,?,?,?)");
            pst.setString(1, m.getTen_mon());
            pst.setString(2, m.getNoi_dung());
            pst.setString(3, m.getMota());
            pst.setDate(4, (Date) m.getNgay_tao());
            pst.setDate(5, (Date) m.getNgay_cap_nhat());
            pst.setBoolean(6, m.isTrang_thai());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MonImplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Mon m) {
        try {
            PreparedStatement pst = con.prepareStatement("UPDATE tbl_mon SET ten_mon = ? ,noi_dung = ? ,mo_ta = ?, ngay_tao = ? ,ngay_cap_nhat = ? ,trang_thai = ? WHERE id = ?");
            pst.setString(1, m.getTen_mon());
            pst.setString(2, m.getNoi_dung());
            pst.setString(3, m.getMota());
            pst.setDate(4, (Date) m.getNgay_tao());
            pst.setDate(5, (Date) m.getNgay_cap_nhat());
            pst.setBoolean(6, m.isTrang_thai());
            pst.setInt(7, m.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MonImplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement pst = con.prepareStatement("DELETE FROM tbl_mon WHERE id = ?");
            pst.setInt(1,id);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MonImplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
