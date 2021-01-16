/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImp;

import dao.TeacherDAO;
import entity.GiaoVien;
import java.sql.Connection;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(GiaoVien gv) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

}
