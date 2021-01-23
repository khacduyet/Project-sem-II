/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.BoDe;
import entity.BoDeChiTiet;
import java.util.List;

/**
 *
 * @author Laptophaidang.com
 */
public interface BoDeDAO {
    
    public List<BoDe> getAll();

    public BoDe getById(int id);

    public void insert(BoDe bd);

    public void update(BoDe bd);

    public void delete(int id);
    
    public void insBoDeChiTiet(BoDeChiTiet bd);
    
    public BoDe idFitInsExam();
    
    public BoDeChiTiet getByIdChiTiet(int id_bd, int id_ch);
    
    public void updateStatusExam(BoDe bd);
    
    public List<BoDeChiTiet> getAllByIdExam(int id);
}
