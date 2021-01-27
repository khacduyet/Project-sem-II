/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.KetQua;
import java.util.List;

/**
 *
 * @author duyet
 */
public interface KetQuaDAO {
    public List<KetQua> getAll();
    public KetQua getByIdStudAndExam(int idSv, int idExam);
    public void insert(KetQua kq);
}
