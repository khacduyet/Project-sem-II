/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.CauHoi;
import java.util.List;

/**
 *
 * @author Laptophaidang.com
 */
public interface CauHoiDAO {

    public List<CauHoi> getAll();

    public CauHoi getById(int key);

    public void insert(CauHoi lp);

    public void update(CauHoi lp);

    public void delete(int id);
    
    public CauHoi getIdInsert();
    
    public List<CauHoi> getAllBySubject(int id_cauhoi);
}
