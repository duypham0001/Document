/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.fashion.dao.impl;

import java.util.List;
import poly.fashion.dao.LoaiSanPhamDAO;
import poly.fashion.entity.LoaiSanPham;
import poly.fashion.util.XJdbc;
import poly.fashion.util.XQuery;

public class LoaiSanPhamDAOImpl implements LoaiSanPhamDAO {

    private final String createSql = "INSERT INTO LoaiSanPham(Id, Name) VALUES(?, ?)";
    private final String updateSql = "UPDATE LoaiSanPham SET Name=? WHERE Id=?";
    private final String deleteByIdSql = "DELETE FROM LoaiSanPham WHERE Id=?";
    
    private final String findAllSql = "SELECT * FROM LoaiSanPham";
    private final String findByIdSql = findAllSql + " WHERE Id=?";

    @Override
    public LoaiSanPham create(LoaiSanPham entity) {
        Object[] values = {
            entity.getId(),
            entity.getName()
        };
        XJdbc.executeUpdate(createSql, values);
        return entity;
    }

    @Override
    public void update(LoaiSanPham entity) {
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
    public List<LoaiSanPham> findAll() {
        return XQuery.getBeanList(LoaiSanPham.class, findAllSql);
    }

    @Override
    public LoaiSanPham findById(String id) {
        return XQuery.getSingleBean(LoaiSanPham.class, findByIdSql, id);
    }
}