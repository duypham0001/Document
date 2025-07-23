/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.fashion.dao.impl;

import java.util.List;
import poly.fashion.entity.Users;
import poly.fashion.util.XJdbc;
import poly.fashion.util.XQuery;
import poly.fashion.dao.UsersDAO;

public class UsersDAOImpl implements UsersDAO {

    String createSql = "INSERT INTO Users(Username,Password,Fullname,Photo,Enable,Manager) VALUES(?, ?)";
    String updateSql = "UPDATE Users SET Password=? WHERE Username=? ";
    String deleteByIdSql = "DELETE FROM Users WHERE Username=?";
    String findAllSql = "SELECT * FROM Users";
    String findByIdSql = "SELECT * FROM Users WHERE Username=?";

    @Override
    public Users create(Users entity) {
        Object[] values = {
            entity.getUsername(),
            entity.getPassword(),
            entity.isEnabled(),
            entity.getFullname(),
            entity.getPhoto(),
            entity.isManager()
        };
        XJdbc.executeUpdate(createSql, values);
        return entity;
    }

    @Override
    public void update(Users entity) {
        Object[] values = {
            entity.getPassword(),
            entity.isEnabled(),
            entity.getFullname(),
            entity.getPhoto(),
            entity.isManager(),
            entity.getUsername()
        };
        XJdbc.executeUpdate(updateSql, values);
    }

    @Override
    public void deleteById(String id) {
        XJdbc.executeUpdate(deleteByIdSql, id);
    }

    @Override
    public List<Users> findAll() {
        return XQuery.getBeanList(Users.class, findAllSql);
    }

    @Override
    public Users findById(String id) {
        return XQuery.getSingleBean(Users.class, findByIdSql, id);
    }
}