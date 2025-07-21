/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.fashion.dao.impl;

/**
 *
 * @author Admin
 */
import java.util.Date;
import java.util.List;
import poly.fashion.dao.HoaDonDAO;
import poly.fashion.entity.HoaDon;
import poly.fashion.util.XJdbc;
import poly.fashion.util.XAuth;
import poly.fashion.util.XQuery;

public class HoaDonDAOImpl implements HoaDonDAO {

    private final String createSql = "INSERT INTO HoaDon(Username, CardId, Checkin, Status) VALUES(?, ?, ?, ?)";
    private final String updateSql = "UPDATE HoaDon SET Username=?, CardId=?, Checkin=?, Checkout=?, Status=? WHERE Id=?";
    private final String deleteByIdSql = "DELETE FROM HoaDon WHERE Id=?";

    private final String findAllSql = "SELECT * FROM HoaDon";
    private final String findByIdSql = findAllSql + " WHERE Id=?";
    private final String findLastSql = findAllSql + " WHERE Id IN(SELECT max(Id) FROM Bills)";
    private final String findByUsernameSql = findAllSql + " WHERE Username=?";
    private final String findByCardIdSql = findAllSql + " WHERE CardId=?";
    private final String findServicingByCardIdSql = findAllSql + " WHERE CardId=? AND Status=0";
    private final String findByUsernameAndTimeRangeSql = findAllSql + " WHERE Username=? AND Checkin BETWEEN ? AND ? ORDER BY Checkin DESC";
    private final String findByTimeRangeSql = findAllSql + " WHERE Checkin BETWEEN ? AND ? ORDER BY Checkin DESC";

    @Override
    public HoaDon create(HoaDon entity) {
        Object[] values = {
            entity.getUsername(),
            entity.getCardId(),
            entity.getCheckin(),
            entity.getStatus()
        };
        XJdbc.executeUpdate(createSql, values);
        return XQuery.getSingleBean(HoaDon.class, findLastSql);
    }

    @Override
    public void update(HoaDon entity) {
        Object[] values = {
            entity.getUsername(),
            entity.getCardId(),
            entity.getCheckin(),
            entity.getCheckout(),
            entity.getStatus(),
            entity.getId()
        };
        XJdbc.executeUpdate(updateSql, values);
    }

    @Override
    public void deleteById(Long id) {
        XJdbc.executeUpdate(deleteByIdSql, id);
    }

    @Override
    public List<HoaDon> findAll() {
        return XQuery.getBeanList(HoaDon.class, findAllSql);
    }

    @Override
    public HoaDon findById(Long id) {
        return XQuery.getSingleBean(HoaDon.class, findByIdSql, id);
    }
    
    @Override
    public List<HoaDon> findByUsername(String username) {
        return XQuery.getBeanList(HoaDon.class, findByUsernameSql, username);
    }

    @Override
    public List<HoaDon> findByCardId(Integer cardId) {
        return XQuery.getBeanList(HoaDon.class, findByCardIdSql, cardId);
    }

    @Override
    public HoaDon findServicingByCardId(Integer cardId) {
        HoaDon bill = XQuery.getSingleBean(HoaDon.class, findServicingByCardIdSql, cardId);
        if (bill == null) {
            HoaDon newBill = new HoaDon();
            newBill.setCardId(cardId);
            newBill.setCheckin(new Date());
            newBill.setStatus(0);
            newBill.setUsername(XAuth.user.getUsername());
            bill = this.create(newBill);
        }
        return bill;
    }

    @Override
    public List<HoaDon> findByUserAndTimeRange(String username, Date begin, Date end) {
        return XQuery.getBeanList(HoaDon.class, findByUsernameAndTimeRangeSql, username, begin, end);
    }

    @Override
    public List<HoaDon> findByTimeRange(Date begin, Date end) {
        return XQuery.getBeanList(HoaDon.class, findByTimeRangeSql, begin, end);
    }
}