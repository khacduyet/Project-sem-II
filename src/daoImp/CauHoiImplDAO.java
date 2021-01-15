/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImp;

import dao.CauHoiDAO;
import entity.CauHoi;
import java.sql.CallableStatement;
import java.sql.Connection;
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
public class CauHoiImplDAO implements CauHoiDAO{
    private Connection con;

    public CauHoiImplDAO() {
    }

    public CauHoiImplDAO(Connection con) {
        this.con = con;
    }
    
    @Override
    public List<CauHoi> getAll() {
        List<CauHoi> results = new ArrayList<>();
        try {
            CallableStatement cs = con.prepareCall("{CALL getAllCauHoi}");
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {                
                CauHoi ch = new CauHoi();
            }
        } catch (SQLException ex) {
            Logger.getLogger(CauHoiImplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return results;
    }

    @Override
    public CauHoi getById(int key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(CauHoi lp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(CauHoi lp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
