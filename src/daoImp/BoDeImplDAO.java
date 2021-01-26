/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImp;

import dao.BoDeDAO;
import entity.BoDe;
import entity.BoDeChiTiet;
import java.sql.CallableStatement;
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
public class BoDeImplDAO implements BoDeDAO {

    private Connection con;

    public BoDeImplDAO() {
    }

    public BoDeImplDAO(Connection con) {
        this.con = con;
    }

    @Override
    public List<BoDe> getAll() {
        List<BoDe> results = new ArrayList<>();
        try {
            CallableStatement cs = con.prepareCall("{CALL getAllBoDe}");
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                BoDe bd = new BoDe(rs.getInt("id"), rs.getInt("id_GiangVien"), rs.getString("noi_dung"), rs.getDate("ngay_tao"), rs.getDate("ngay_cap_nhat"), rs.getString("mo_ta"), rs.getBoolean("trang_thai"));
                results.add(bd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BoDeImplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return results;
    }

    @Override
    public BoDe getById(int id) {
        BoDe bd = null;
        try {
            CallableStatement cs = con.prepareCall("{CALL getByIdBoDe(?)}");
            cs.setInt(1, id);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                bd = new BoDe(rs.getInt("id"), rs.getInt("id_GiangVien"), rs.getString("noi_dung"), rs.getDate("ngay_tao"), rs.getDate("ngay_cap_nhat"), rs.getString("mo_ta"), rs.getBoolean("trang_thai"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BoDeImplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bd;
    }

    @Override
    public void insert(BoDe bd) {
        CallableStatement cs;
        try {
            cs = con.prepareCall("{CALL insertBoDe(?,?,?,?,?,?)}");
            cs.setInt(1, bd.getId_giangvien());
            cs.setString(2, bd.getNoi_dung());
            cs.setDate(3, (Date) bd.getNgay_tao());
            cs.setDate(4, (Date) bd.getNgay_cap_nhat());
            cs.setString(5, bd.getMo_ta());
            cs.setBoolean(6, bd.isTrang_thai());
            cs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BoDeImplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(BoDe bd) {
        CallableStatement cs;
        try {
            cs = con.prepareCall("{CALL updateBoDe(?,?,?,?,?,?)}");
            cs.setInt(1, bd.getId_giangvien());
            cs.setString(2, bd.getNoi_dung());
            cs.setDate(3, (Date) bd.getNgay_cap_nhat());
            cs.setString(4, bd.getMo_ta());
            cs.setBoolean(5, bd.isTrang_thai());
            cs.setInt(6, bd.getId());
            cs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BoDeImplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int id) {
        try {
            CallableStatement cs = con.prepareCall("{CALL deleteBoDe(?)}");
            cs.setInt(1, id);
            cs.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(BoDeImplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void insBoDeChiTiet(BoDeChiTiet bd) {
        CallableStatement cs;
        try {
            cs = con.prepareCall("{CALL insertBoDeChiTiet(?,?,?)}");
            cs.setInt(1, bd.getId_bode());
            cs.setInt(2, bd.getId_cauhoi());
            cs.setFloat(3, bd.getDiem());
            cs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BoDeImplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public BoDe idFitInsExam() {
        BoDe bd = null;
        try {
            CallableStatement cs = con.prepareCall("{CALL idFitInsertExam()}");
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                bd = new BoDe(rs.getInt("id"), rs.getInt("id_GiangVien"), rs.getString("noi_dung"), rs.getDate("ngay_tao"), rs.getDate("ngay_cap_nhat"), rs.getString("mo_ta"), rs.getBoolean("trang_thai"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BoDeImplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bd;
    }

    @Override
    public BoDeChiTiet getByIdChiTiet(int id_bd, int id_ch) {
        BoDeChiTiet bd = null;
        try {
            PreparedStatement pst = con.prepareStatement("SELECT TOP 1 * FROM tbl_bodechitiet WHERE id_BoDe = ? OR id_CauHoi = ?");
            pst.setInt(1, id_bd);
            pst.setInt(2, id_ch);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                bd = new BoDeChiTiet(rs.getInt("id_BoDe"), rs.getInt("id_CauHoi"), rs.getFloat("diem"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BoDeImplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bd;
    }

    @Override
    public void updateStatusExam(BoDe bd) {
        CallableStatement cs;
        try {
            cs = con.prepareCall("UPDATE tbl_BoDe SET trang_thai = ? where id = ?");
            cs.setBoolean(1, bd.isTrang_thai());
            cs.setInt(2, bd.getId());
            cs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BoDeImplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<BoDeChiTiet> getAllByIdExam(int id) {
        List<BoDeChiTiet> bd = new ArrayList<>();
        try {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM tbl_bodechitiet WHERE id_BoDe = ?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                BoDeChiTiet b = new BoDeChiTiet(rs.getInt("id_BoDe"), rs.getInt("id_CauHoi"), rs.getFloat("diem"));
                bd.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BoDeImplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bd;
    }

    @Override
    public List<BoDe> getAllByStatus() {
        List<BoDe> results = new ArrayList<>();
        try {
            CallableStatement cs = con.prepareCall("{CALL getExamByStatus}");
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                BoDe bd = new BoDe(rs.getInt("id"), rs.getInt("id_GiangVien"), rs.getString("noi_dung"), rs.getDate("ngay_tao"), rs.getDate("ngay_cap_nhat"), rs.getString("mo_ta"), rs.getBoolean("trang_thai"));
                results.add(bd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BoDeImplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return results;
    }
}
