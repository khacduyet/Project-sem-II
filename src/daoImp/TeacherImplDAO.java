/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImp;

import dao.TeacherDAO;
import entity.GiaoVien;
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
 * @author duyet
 */
public class TeacherImplDAO implements TeacherDAO {

    private Connection con;

    public TeacherImplDAO(Connection con) {
        this.con = con;
    }

    @Override
    public List<GiaoVien> getAll() {
        List<GiaoVien> data = new ArrayList<>();
        try {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM Tbl_GiaoVien");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                GiaoVien gv = new GiaoVien(rs.getInt("id"), rs.getString("ma_gv"), rs.getString("ho_ten"), rs.getBoolean("gioi_tinh"),
                        rs.getDate("ngay_sinh"), rs.getString("dien_thoai"), rs.getString("dia_chi"), rs.getString("email"), rs.getDate("ngay_tao"),
                        rs.getDate("ngay_cap_nhat"), rs.getBoolean("trang_thai"), rs.getString("username"), rs.getString("password"));
                data.add(gv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TeacherImplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    @Override
    public void insert(GiaoVien gv) {
        CallableStatement cs;
        try {
            cs = con.prepareCall("{CALL insertGv(?,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setString(1, gv.getMa_gv());
            cs.setString(2, gv.getHo_ten());
            cs.setBoolean(3, gv.isGioi_tinh());
            cs.setDate(4, (Date) gv.getNgay_sinh());
            cs.setString(5, gv.getDien_thoai());
            cs.setString(6, gv.getDia_chi());
            cs.setString(7, gv.getEmail());
            cs.setDate(8, (Date) gv.getNgay_tao());
            cs.setDate(9, (Date) gv.getNgay_cap_nhat());
            cs.setBoolean(10, gv.isTrang_thai());
            cs.setString(11, gv.getUsername());
            cs.setString(12, gv.getPassword());
            cs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TeacherImplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(GiaoVien gv) {
        CallableStatement cs;
        try {
            cs = con.prepareCall("{CALL updateGiaoVien(?,?,?,?,?,?,?,?,?)}");
            cs.setString(1, gv.getHo_ten());
            cs.setBoolean(2, gv.isGioi_tinh());
            cs.setDate(3, (Date) gv.getNgay_sinh());
            cs.setString(4, gv.getDien_thoai());
            cs.setString(5, gv.getDia_chi());
            cs.setString(6, gv.getEmail());
            cs.setDate(7, (Date) gv.getNgay_cap_nhat());
            cs.setBoolean(8, gv.isTrang_thai());
            cs.setInt(9, gv.getId());
            cs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TeacherImplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int id) {
        try {
            CallableStatement cs = con.prepareCall("{CALL deleteGiaoVien(?)}");
            cs.setInt(1, id);
            cs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TeacherImplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public GiaoVien getAccountGiaoVien(String username, String password) {
        GiaoVien gv = null;
        try {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM Tbl_GiaoVien where username = ? AND password = ?");
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                gv = new GiaoVien(rs.getInt("id"), rs.getString("ma_gv"), rs.getString("ho_ten"), rs.getBoolean("gioi_tinh"),
                        rs.getDate("ngay_sinh"), rs.getString("dien_thoai"), rs.getString("dia_chi"), rs.getString("email"), rs.getDate("ngay_tao"),
                        rs.getDate("ngay_cap_nhat"), rs.getBoolean("trang_thai"), rs.getString("username"), rs.getString("password"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TeacherImplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return gv;
    }

    @Override
    public GiaoVien getById(int id) {
        GiaoVien gv = null;
        try {
            CallableStatement cs = con.prepareCall("{CALL getByIdGV(?)}");
            cs.setInt(1, id);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                gv = new GiaoVien(rs.getInt("id"), rs.getString("ma_gv"), rs.getString("ho_ten"), rs.getBoolean("gioi_tinh"),
                        rs.getDate("ngay_sinh"), rs.getString("dien_thoai"), rs.getString("dia_chi"), rs.getString("email"), rs.getDate("ngay_tao"),
                        rs.getDate("ngay_cap_nhat"), rs.getBoolean("trang_thai"), rs.getString("username"), rs.getString("password"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TeacherImplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return gv;
    }

    @Override
    public GiaoVien getIdIns() {
        GiaoVien gv = null;
        try {
            PreparedStatement pst = con.prepareStatement("SELECT TOP 1 * FROM Tbl_GiaoVien ORDER BY id DESC");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                gv = new GiaoVien(rs.getInt("id"), rs.getString("ma_gv"), rs.getString("ho_ten"), rs.getBoolean("gioi_tinh"),
                        rs.getDate("ngay_sinh"), rs.getString("dien_thoai"), rs.getString("dia_chi"), rs.getString("email"), rs.getDate("ngay_tao"),
                        rs.getDate("ngay_cap_nhat"), rs.getBoolean("trang_thai"), rs.getString("username"), rs.getString("password"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentImplDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return gv;
    }

    @Override
    public void upadateStatus(GiaoVien gv) {
        try {
            PreparedStatement pst = con.prepareStatement("Update tbl_GiaoVien set trang_thai = ? where id = ?");
            pst.setBoolean(1, gv.isTrang_thai());
            pst.setInt(2, gv.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TeacherImplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
