/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImp;

import dao.StudentDAO;
import entity.SinhVien;
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
public class StudentImplDAO implements StudentDAO {

    private Connection con;

    public StudentImplDAO(Connection con) {
        this.con = con;
    }

    @Override
    public List<SinhVien> getAll() {
        List<SinhVien> listSV = new ArrayList<>();
        try {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM tbl_SinhVien");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                SinhVien sv = new SinhVien(rs.getInt("id"), rs.getString("ma_sv"), rs.getInt("id_lop"), rs.getString("ho_ten"),
                        rs.getBoolean("gioi_tinh"), rs.getDate("ngay_sinh"), rs.getDate("ngay_nhap_hoc"), rs.getDate("ngay_cap_nhat"), rs.getString("di_dong"),
                        rs.getString("dt_gia_dinh"), rs.getString("email"), rs.getString("dia_chi"), rs.getString("avatar"), rs.getString("username"),
                        rs.getString("password"), rs.getString("ghi_chu"), rs.getBoolean("trang_thai"));

                listSV.add(sv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentImplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listSV;
    }

//    @Override
//    public SinhVien getById(int id) {
//        
//    }
    @Override
    public void insert(SinhVien sv) {
        try {
            PreparedStatement pst = con.prepareStatement("INSERT INTO tbl_SinhVien VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, sv.getMa_sv());
            pst.setInt(2, sv.getId());
            pst.setString(3, sv.getHo_ten());
            pst.setBoolean(4, sv.isGioi_Tinh());
            pst.setDate(5, (Date) sv.getNgay_sinh());
            pst.setDate(6, (Date) sv.getNgay_nhap_hoc());
            pst.setDate(7, (Date) sv.getNgay_cap_nhat());
            pst.setString(8, sv.getDi_dong());
            pst.setString(9, sv.getDt_gia_dinh());
            pst.setString(10, sv.getEmail());
            pst.setString(11, sv.getDia_chi());
            pst.setString(12, sv.getAvatar());
            pst.setString(13, sv.getUsername());
            pst.setString(14, sv.getPassword());
            pst.setString(15, sv.getGhi_chu());
            pst.setBoolean(16, sv.isTrang_thai());
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(StudentImplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(SinhVien sv) {

    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SinhVien getAccount(String username, String password) {
        SinhVien sv = null;
        try {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM tbl_SinhVien where username = ? AND password = ?");
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                sv = new SinhVien(rs.getInt("id"), rs.getString("ma_sv"), rs.getInt("id_lop"), rs.getString("ho_ten"),
                        rs.getBoolean("gioi_tinh"), rs.getDate("ngay_sinh"), rs.getDate("ngay_nhap_hoc"), rs.getDate("ngay_cap_nhat"), rs.getString("di_dong"),
                        rs.getString("dt_gia_dinh"), rs.getString("email"), rs.getString("dia_chi"), rs.getString("avatar"), rs.getString("username"),
                        rs.getString("password"), rs.getString("ghi_chu"), rs.getBoolean("trang_thai"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentImplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sv;
    }

}
