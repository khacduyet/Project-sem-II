/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.KhieuNai;
import java.util.List;

/**
 *
 * @author duyet
 */
public interface KhieuNaiDAO {
    public List<KhieuNai> getAll();
    public KhieuNai getById(int id);
    public void insert(KhieuNai kn);
}
