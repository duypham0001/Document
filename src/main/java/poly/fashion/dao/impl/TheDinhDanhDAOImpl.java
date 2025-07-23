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
import poly.fashion.dao.TheDinhDanhDAO;
import poly.fashion.entity.TheDinhDanh;
import poly.fashion.util.XJdbc;
import poly.fashion.util.XQuery;

public class TheDinhDanhDAOImpl implements TheDinhDanhDAO {

    private final String createSql = "INSERT INTO TheDinhDanh(Id, Status) VALUES(?, ?)";
    private final String updateSql = "UPDATE TheDinhDanh SET Status=? WHERE Id=?";
    private final String deleteByIdSql = "DELETE FROM TheDinhDanh WHERE Id=?";
    
    private final String findAllSql = "SELECT * FROM TheDinhDanh";
    private final String findByIdSql = findAllSql + " WHERE Id=?";

    @Override
    public TheDinhDanh create(TheDinhDanh entity) {
        Object[] values = {
            entity.getId(),
            entity.getStatus()
        };
        XJdbc.executeUpdate(createSql, values);
        return entity;
    }

    @Override
    public void update(TheDinhDanh entity) {
        Object[] values = {
            entity.getStatus(),
            entity.getId()
        };
        XJdbc.executeUpdate(updateSql, values);
    }

    @Override
    public void deleteById(Integer id) {
        XJdbc.executeUpdate(deleteByIdSql, id);
    }

    @Override
    public List<TheDinhDanh> findAll() {
        return XQuery.getBeanList(TheDinhDanh.class, findAllSql);
    }

    @Override
    public TheDinhDanh findById(Integer id) {
        return XQuery.getSingleBean(TheDinhDanh.class,findByIdSql, id);
    }
}
