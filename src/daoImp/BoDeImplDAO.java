/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImp;

import dao.BoDeDAO;
import entity.BoDe;
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
}
