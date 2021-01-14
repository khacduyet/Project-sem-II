/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.GiaoVien;
import java.util.List;

/**
 *
 * @author Laptophaidang.com
 */
public interface GiaoVienDAO {

    public List<GiaoVien> getAll();

    public GiaoVien getById(int id);

    public void insert(GiaoVien gv);

    public void update(GiaoVien gv);

    public void delete(int id);
}
