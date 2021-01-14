/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.PhanQuyen;
import java.util.List;

public interface PhanQuyenDAO {
    public List<PhanQuyen> getAll();

    public PhanQuyen getById(int id);

    public void insert(PhanQuyen pq);

    public void update(PhanQuyen pq);

    public void delete(int id);
}
