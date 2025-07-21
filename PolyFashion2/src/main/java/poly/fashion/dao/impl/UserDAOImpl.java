/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.fashion.dao.impl;

import java.util.List;
import poly.fashion.entity.User;
import poly.fashion.util.XJdbc;
import poly.fashion.util.XQuery;
import poly.fashion.dao.UserDAO;

public class UserDAOImpl implements UserDAO {

    String createSql = "INSERT INTO User(Username,Password,Fullname,Photo,Enable,Manager) VALUES(?, ?)";
    String updateSql = "UPDATE User SET Password=? WHERE Username=? ";
    String deleteByIdSql = "DELETE FROM User WHERE Username=?";
    String findAllSql = "SELECT * FROM User";
    String findByIdSql = "SELECT * FROM User WHERE Username=?";

    @Override
    public User create(User entity) {
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
    public void update(User entity) {
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
    public List<User> findAll() {
        return XQuery.getBeanList(User.class, findAllSql);
    }

    @Override
    public User findById(String id) {
        return XQuery.getSingleBean(User.class, findByIdSql, id);
    }
}