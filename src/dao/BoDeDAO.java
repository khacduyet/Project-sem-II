/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.BoDe;
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
}
