/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.fashion.dao.impl;

/**
 *
 * @author Admin
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import poly.fashion.entity.SanPham;
import poly.fashion.util.XJdbc;
import poly.fashion.util.XStr;
import poly.fashion.dao.SanPhamDAO;
import poly.fashion.util.XQuery;

public class SanPhamDAOImpl implements SanPhamDAO {

    private final String createSql = "INSERT INTO SanPham(Id, Name, Image, UnitPrice, Discount, Available, CategoryId) VALUES(?, ?, ?, ?, ?, ?, ?)";
    private final String updateSql = "UPDATE SanPham SET Name=?, Image=?, UnitPrice=?, Discount=?, Available=?, CategoryId=? WHERE Id=?";
    private final String deleteByIdSql = "DELETE FROM SanPham WHERE Id=?";
    
    private final String findAllSql = "SELECT * FROM SanPham";
    private final String findByIdSql = findAllSql + " WHERE Id=?";
    private final String findByCategoryIdSql = findAllSql + " WHERE CategoryId=?";

    @Override
    public SanPham create(SanPham entity) {
        entity.setId(XStr.getKey());
        Object[] values = {
            entity.getId(),
            entity.getName(),
            entity.getImage(),
            entity.getUnitPrice(),
            entity.getDiscount(),
            entity.isAvailable(),
            entity.getCategoryId()
        };
        XJdbc.executeUpdate(createSql, values);
        return entity;
    }

    @Override
    public void update(SanPham entity) {
        Object[] values = {
            entity.getName(),
            entity.getImage(),
            entity.getUnitPrice(),
            entity.getDiscount(),
            entity.isAvailable(),
            entity.getCategoryId(),
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

    @Override
    public List<SanPham> findByCategoryId(String categoryId) {
        return XQuery.getBeanList(SanPham.class, findByCategoryIdSql, categoryId);
    }    
}
