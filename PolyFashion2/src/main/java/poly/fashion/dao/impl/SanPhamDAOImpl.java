/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.fashion.dao.impl;

/**
 *
 * @author Admin
 */
import java.util.List;
import poly.fashion.dao.SanPhamDAO;
import poly.fashion.entity.SanPham;
import poly.fashion.util.XJdbc;
import poly.fashion.util.XQuery;

public class SanPhamDAOImpl implements SanPhamDAO {

    private final String createSql = "INSERT INTO SanPham(Id, Name) VALUES(?, ?)";
    private final String updateSql = "UPDATE SanPham SET Name=? WHERE Id=?";
    private final String deleteByIdSql = "DELETE FROM SanPham WHERE Id=?";
    
    private final String findAllSql = "SELECT * FROM SanPham";
    private final String findByIdSql = findAllSql + " WHERE Id=?";

    @Override
    public SanPham create(SanPham entity) {
        Object[] values = {
            entity.getId(),
            entity.getName()
        };
        XJdbc.executeUpdate(createSql, values);
        return entity;
    }

    @Override
    public void update(SanPham entity) {
        Object[] values = {
            entity.getName(),
            entity.getId()
        };
        XJdbc.executeUpdate(updateSql, values);
    }

    @Override
    public void deleteById(String id) {
        XJdbc.executeUpdate(deleteByIdSql, id);
    }

    @Override
    public List<SanPham> findAll() {
        return XQuery.getBeanList(SanPham.class, findAllSql);
    }

    @Override
    public SanPham findById(String id) {
        return XQuery.getSingleBean(SanPham.class, findByIdSql, id);
    }
}