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
import poly.fashion.util.XJdbc;
import poly.fashion.dao.PhieuBanHangDAO;
import poly.fashion.entity.PhieuBanHang;
import poly.fashion.util.XQuery;

public class PhieuBanHangDAOImpl implements PhieuBanHangDAO {

    private final String createSql = "INSERT INTO BillDetails(BillId, DrinkId, UnitPrice, Discount, Quantity) VALUES(?, ?, ?, ?, ?)";
    private final String updateSql = "UPDATE BillDetails SET BillId=?, DrinkId=?, UnitPrice=?, Discount=?, Quantity=? WHERE Id=?";
    private final String deleteByIdSql = "DELETE FROM BillDetails WHERE Id=?";

    private final String findAllSql = "SELECT bd.*, d.name AS drinkName FROM BillDetails bd JOIN Drinks d ON d.Id=bd.DrinkId";
    private final String findByIdSql = findAllSql + " WHERE bd.Id=?";
    private final String findLastSql = findAllSql + " WHERE bd.Id IN(SELECT max(Id) FROM BillDetails)";
    private final String findByBillIdSql = findAllSql + " WHERE bd.BillId=?";
    private final String findByDrinkIdSql = findAllSql + " WHERE bd.DrinkId=?";

    @Override
    public PhieuBanHang create(PhieuBanHang entity) {
        Object[] values = {
            entity.getBillId(),
            entity.getDrinkId(),
            entity.getUnitPrice(),
            entity.getDiscount(),
            entity.getQuantity()
        };
        XJdbc.executeUpdate(createSql, values);
        return XQuery.getSingleBean(PhieuBanHang.class, findLastSql);
    }

    @Override
    public void update(PhieuBanHang entity) {
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
    public List<PhieuBanHang> findAll() {
        return XQuery.getBeanList(PhieuBanHang.class,findAllSql);
    }

    @Override
    public PhieuBanHang findById(Long id) {
        return XQuery.getSingleBean(PhieuBanHang.class,findByIdSql, id);
    }

    @Override
    public List<PhieuBanHang> findByBillId(Long billId) {
        return XQuery.getBeanList(PhieuBanHang.class, findByBillIdSql, billId);
    }

    @Override
    public List<PhieuBanHang> findByDrinkId(String drinkId) {
        return XQuery.getBeanList(PhieuBanHang.class, findByDrinkIdSql, drinkId);
    }
}