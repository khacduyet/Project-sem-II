/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImp;

import dao.KhieuNaiDAO;
import entity.KhieuNai;
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
 * @author duyet
 */
public class KhieuNaiImplDAO implements KhieuNaiDAO {

    Connection con;

    public KhieuNaiImplDAO(Connection con) {
        this.con = con;
    }

    @Override
    public List<KhieuNai> getAll() {
        List<KhieuNai> kn = new ArrayList<>();
        try {
            CallableStatement cs = con.prepareCall("{call getAllKhieuNai}");
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                KhieuNai k = new KhieuNai(rs.getInt("id"), rs.getInt("id_SinhVien"), rs.getString("tieu_de"), rs.getString("noi_dung"), rs.getDate("ngay_tao"), rs.getDate("Ngay_cap_nhat"));
                kn.add(k);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhieuNaiImplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kn;
    }

    @Override
    public KhieuNai getById(int id) {
        KhieuNai rp = null;
        try {
            CallableStatement cs = con.prepareCall("{call getAllByIdKhieuNai(?)}");
            cs.setInt(1, id);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                rp = new KhieuNai(rs.getInt("id"), rs.getInt("id_SinhVien"), rs.getString("tieu_de"), rs.getString("noi_dung"), rs.getDate("ngay_tao"), rs.getDate("Ngay_cap_nhat"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhieuNaiImplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rp;
    }

    @Override
    public void insert(KhieuNai kn) {
        try {
            CallableStatement cs = con.prepareCall("{call InsKhieuNai(?,?,?,?,?)}");
            cs.setInt(1, kn.getId_sinhvien());
            cs.setString(2, kn.getTieu_de());
            cs.setString(3, kn.getNoi_dung());
            cs.setDate(4, (Date) kn.getNgay_tao());
            cs.setDate(5, (Date) kn.getNgay_cap_nhat());
            cs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KhieuNaiImplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
