/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Mon;
import java.util.List;

public interface MonHocDAO {

    public List<Mon> getAll();

    public Mon getById(int key);

    public void insert(Mon m);

    public void update(Mon m);

    public void delete(int id);
    
    public void changerStt(Mon m);
}
