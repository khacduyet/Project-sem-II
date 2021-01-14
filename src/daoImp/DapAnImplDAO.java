/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOimpl;

import dao.DapAnDAO;
import entity.DapAn;
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
 * @author Laptophaidang.com
 */
public class DapAnImplDAO implements DapAnDAO {

    private Connection con;

    public DapAnImplDAO() {
    }

    public DapAnImplDAO(Connection con) {
        this.con = con;
    }

    @Override
    public List<DapAn> getAll() {
        List<DapAn> results = new ArrayList<>();
        try {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM tbl_DapAn");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                DapAn da = new DapAn(rs.getInt("id"), rs.getInt("id_cauhoi"), rs.getString("noi_dung"), rs.getBoolean("dap_an"));
                results.add(da);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DapAnImplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return results;
    }

    @Override
    public DapAn getById(int id) {
        DapAn da = null;
        try {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM tbl_DapAn WHERE id = ?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                da = new DapAn(rs.getInt("id"), rs.getInt("id_cauhoi"), rs.getString("noi_dung"), rs.getBoolean("dap_an"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DapAnImplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return da;
    }

    @Override
    public void insert(DapAn da) {
        PreparedStatement pst;
        try {
            pst = con.prepareStatement("INSERT INTO tbl_DapAn VALUES (?,?,?)");
            pst.setInt(1, da.getId_cauhoi());
            pst.setString(2, da.getNoi_dung());
            pst.setBoolean(3, da.isDap_an());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DapAnImplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(DapAn da) {
        PreparedStatement pst;
        try {
            pst = con.prepareStatement("UPDATE tbl_DapAn SET id_cauhoi = ?, noi_dung = ?,dap_an= ? WHERE id = ? ");
            pst.setInt(1, da.getId_cauhoi());
            pst.setString(2, da.getNoi_dung());
            pst.setBoolean(3, da.isDap_an());
            pst.setInt(4, da.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DapAnImplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement pst = con.prepareStatement("DELETE FROM tbl_DapAn WHERE id = ?");
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DapAnImplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
