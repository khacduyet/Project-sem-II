/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.DapAn;
import java.util.List;

public interface DapAnDAO {

    public List<DapAn> getAll();

    public DapAn getById(int id);

    public void insert(DapAn da);

    public void update(DapAn da);

    public void delete(int id);
    
    public DapAn getByIdQuestion(int id);
    public List<DapAn> getAllAnsert(int id);
}
