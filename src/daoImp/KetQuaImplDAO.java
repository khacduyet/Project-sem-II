/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImp;

import dao.KetQuaDAO;
import entity.KetQua;
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
public class KetQuaImplDAO implements KetQuaDAO {

    Connection con;

    public KetQuaImplDAO(Connection con) {
        this.con = con;
    }

    @Override
    public List<KetQua> getAll() {
        List<KetQua> kq = new ArrayList<>();
        try {
            CallableStatement cs = con.prepareCall("{call getAllKetQua}");
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                KetQua k = new KetQua(rs.getInt("id_SinhVien"), rs.getInt("id_BoDe"), rs.getDate("ngay_thi"), rs.getFloat("tong_diem"));
                kq.add(k);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KetQuaImplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }

    @Override
    public KetQua getByIdStudAndExam(int idSv, int idExam) {
        KetQua kq = null;
        try {
            CallableStatement cs = con.prepareCall("{call getByIdStudAndIdExam(?,?)}");
            cs.setInt(1, idSv);
            cs.setInt(2, idExam);
            ResultSet rs = cs.executeQuery();
            while (rs.next()){
                kq = new KetQua(rs.getInt("id_SinhVien"), rs.getInt("id_BoDe"), rs.getDate("ngay_thi"), rs.getFloat("tong_diem"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(KetQuaImplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }

    @Override
    public void insert(KetQua kq) {
        try {
            CallableStatement cs = con.prepareCall("{call insertKetQua(?,?,?,?)}");
            cs.setInt(1, kq.getId_sv());
            cs.setInt(2, kq.getId_bode());
            cs.setDate(3, (Date) kq.getNgay_thi());
            cs.setFloat(4, kq.getTong_diem());
            cs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KetQuaImplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
