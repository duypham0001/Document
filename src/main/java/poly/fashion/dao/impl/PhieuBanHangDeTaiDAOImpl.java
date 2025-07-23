/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.fashion.dao.impl;

import java.util.List;
import poly.fashion.entity.PhieuBanHangDeTai;
import poly.fashion.util.XJdbc;
import poly.fashion.dao.PhieuBanHangDeTaiDAO;
import poly.fashion.util.XQuery;

public class PhieuBanHangDeTaiDAOImpl implements PhieuBanHangDeTaiDAO {

    private final String createSql = "INSERT INTO PhieuBanHangDeTaiDAO(BillId, DrinkId, UnitPrice, Discount, Quantity) VALUES(?, ?, ?, ?, ?)";
    private final String updateSql = "UPDATE PhieuBanHangDeTaiDAO SET BillId=?, DrinkId=?, UnitPrice=?, Discount=?, Quantity=? WHERE Id=?";
    private final String deleteByIdSql = "DELETE FROM PhieuBanHangDeTaiDAO WHERE Id=?";

    private final String findAllSql = "SELECT bd.*, d.name AS drinkName FROM PhieuBanHangDeTaiDAO bd JOIN Drinks d ON d.Id=bd.DrinkId";
    private final String findByIdSql = findAllSql + " WHERE bd.Id=?";
    private final String findLastSql = findAllSql + " WHERE bd.Id IN(SELECT max(Id) FROM PhieuBanHangDeTaiDAO)";
    private final String findByBillIdSql = findAllSql + " WHERE bd.BillId=?";
    private final String findByDrinkIdSql = findAllSql + " WHERE bd.DrinkId=?";

    @Override
    public PhieuBanHangDeTai create(PhieuBanHangDeTai entity) {
        Object[] values = {
            entity.getBillId(),
            entity.getDrinkId(),
            entity.getUnitPrice(),
            entity.getDiscount(),
            entity.getQuantity()
        };
        XJdbc.executeUpdate(createSql, values);
        return XQuery.getSingleBean(PhieuBanHangDeTai.class, findLastSql);
    }

    @Override
    public void update(PhieuBanHangDeTai entity) {
        Object[] values = {
            entity.getBillId(),
            entity.getDrinkId(),
            entity.getUnitPrice(),
            entity.getDiscount(),
            entity.getQuantity(),
            entity.getId()
        };
        XJdbc.executeUpdate(updateSql, values);
    }

    @Override
    public void deleteById(Long id) {
        XJdbc.executeUpdate(deleteByIdSql, id);
    }

    @Override
    public List<PhieuBanHangDeTai> findAll() {
        return XQuery.getBeanList(PhieuBanHangDeTai.class,findAllSql);
    }

    @Override
    public PhieuBanHangDeTai findById(Long id) {
        return XQuery.getSingleBean(PhieuBanHangDeTai.class,findByIdSql, id);
    }

    @Override
    public List<PhieuBanHangDeTai> findByPhieuBanHangId(Long billId) {
        return XQuery.getBeanList(PhieuBanHangDeTai.class, findByBillIdSql, billId);
    }

    @Override
    public List<PhieuBanHangDeTai> findBySanPhamId(String drinkId) {
        return XQuery.getBeanList(PhieuBanHangDeTai.class, findByDrinkIdSql, drinkId);
    }
}
