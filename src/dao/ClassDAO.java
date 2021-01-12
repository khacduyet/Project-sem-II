/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.LopHoc;
import java.util.List;

/**
 *
 * @author Laptophaidang.com
 */
public interface ClassDAO {
    public List<LopHoc> getAll();
    public LopHoc getById(int key);
    public void insert(LopHoc lp);
    public void update(LopHoc lp);
    public void delete(int id);
}
