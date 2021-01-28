/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.SinhVien;
import java.util.List;

/**
 *
 * @author Laptophaidang.com
 */
public interface StudentDAO {
    public List<SinhVien> getAll();
    public SinhVien getById(int id);
    public void insert(SinhVien sv);
    public void update(SinhVien sv);
    public void delete(int id);
    
    // duyệt thêm phương thức
    public SinhVien getAccountSinhVien(String username, String password);
    public SinhVien getIdIns();
    public void updateStatus(SinhVien sv);
    public List<SinhVien> getAllSeacher(String name);
}
