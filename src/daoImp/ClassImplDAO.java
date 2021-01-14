/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImp;

import dao.ClassDAO;
import entity.LopHoc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Laptophaidang.com
 */
public class ClassImplDAO implements ClassDAO {

    private Connection con;

    public ClassImplDAO() {
    }

    public ClassImplDAO(Connection con) {
        this.con = con;
    }

    @Override
    public List<LopHoc> getAll() {
        List<LopHoc> listLopHoc = new ArrayList<>();
        try {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM tbl_LopHoc");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {                
                LopHoc lh = new LopHoc(rs.getInt("id"),rs.getString("ten_lop"),rs.getString("khoa_hoc"),rs.getInt("nien_khoa"),rs.getBoolean("trang_thai"));
                listLopHoc.add(lh);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ClassImplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listLopHoc;
    }

    @Override
    public LopHoc getById(int key) {
        LopHoc lh = null;
        try {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM tbl_LopHoc WHERE id = ?");
            pst.setInt(1, key);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {                
                lh = new LopHoc(rs.getInt("id"),rs.getString("ten_lop"),rs.getString("khoa_hoc"),rs.getInt("nien_khoa"),rs.getBoolean("trang_thai"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassImplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lh;
    }

    @Override
    public void insert(LopHoc lp) {
        PreparedStatement pst;
        try {
            pst = con.prepareStatement("INSERT INTO tbl_LopHoc VALUES(?,?,?,?)");
            pst.setString(1, lp.getTen_lop());
            pst.setString(2,lp.getKhoa_hoc());
            pst.setInt(3,lp.getNien_khoa());
            pst.setBoolean(4,lp.isTrang_thai());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClassImplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update(LopHoc lp) {
        try {
            PreparedStatement pst = con.prepareStatement("UPDATE tbl_LopHoc SET ten_lop = ?,khoa_hoc = ?,nien_khoa= ? , trang_thai =? WHERE id = ?");
            pst.setString(1, lp.getTen_lop());
            pst.setString(2,lp.getKhoa_hoc());
            pst.setInt(3,lp.getNien_khoa());
            pst.setBoolean(4,lp.isTrang_thai());
            pst.setInt(5,lp.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClassImplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
