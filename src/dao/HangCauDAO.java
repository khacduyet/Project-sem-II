/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.HangCau;
import java.util.List;

/**
 *
 * @author Laptophaidang.com
 */
public interface HangCauDAO {
    
    public List<HangCau> getAll();

    public HangCau getById(int key);

    public void insert(HangCau m);

    public void update(HangCau m);

    public void delete(int id);
    
    public void changerStt(HangCau m);
}
