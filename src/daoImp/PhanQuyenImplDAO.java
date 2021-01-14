/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImp;

import dao.PhanQuyenDAO;
import entity.PhanQuyen;
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
public class PhanQuyenImplDAO implements PhanQuyenDAO {

    private Connection con;

    public PhanQuyenImplDAO() {
    }

    public PhanQuyenImplDAO(Connection con) {
        this.con = con;
    }

    @Override
    public List<PhanQuyen> getAll() {
        List<PhanQuyen> results = new ArrayList<>();
        try {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM tbl_PhanQuyen");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                PhanQuyen p = new PhanQuyen(rs.getInt("id_quyen"), rs.getString("ma_quyen"), rs.getString("mo_ta"));
                results.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhanQuyenImplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return results;
    }

    @Override
    public PhanQuyen getById(int id) {
        PhanQuyen p = null;
        try {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM tbl_PhanQuyen WHERE id = ?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                p = new PhanQuyen(rs.getInt("id_quyen"), rs.getString("ma_quyen"), rs.getString("mo_ta"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhanQuyenImplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    @Override
    public void insert(PhanQuyen pq) {
        try {
            PreparedStatement pst = con.prepareStatement("INSERT INTO tbl_PhanQuyen VALUES(?,?)");
            pst.setString(1, pq.getMa_quyen());
            pst.setString(2, pq.getMo_ta());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PhanQuyenImplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(PhanQuyen pq) {
        try {
            PreparedStatement pst = con.prepareStatement("UPDATE tbl_PhanQuyen SET ma_quyen = ? ,mo_ta = ? WHERE id_quyen = ?");
            pst.setString(1, pq.getMa_quyen());
            pst.setString(2, pq.getMo_ta());
            pst.setInt(3, pq.getId_quyen());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PhanQuyenImplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement pst = con.prepareStatement("DELETE FROM tbl_PhanQuyen WHERE id_quyen = ?");
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PhanQuyenImplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}