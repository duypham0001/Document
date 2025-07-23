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
import poly.fashion.dao.DoanhThuDAO;
import poly.fashion.entity.DoanhThu.BySanPham;
import poly.fashion.entity.DoanhThu.ByUser;
import poly.fashion.util.XQuery;

public class DoanhThuDAOImpl implements DoanhThuDAO {

    @Override
    public List<BySanPham> getBySanPham(Date begin, Date end) {
        String revenueByCategorySql
                = "SELECT sanpham.Name AS SanPham, "
                + "   sum(detail.UnitPrice*detail.Quantity*(1-detail.Discount)) AS Revenue,"
                + "   sum(detail.Quantity) AS Quantity,"
                + "   min(detail.UnitPrice) AS MinPrice,"
                + "   max(detail.UnitPrice) AS MaxPrice,"
                + "   avg(detail.UnitPrice) AS AvgPrice "
                + "FROM BillDetails detail "
                + "   JOIN Drinks drink ON drink.Id=detail.DrinkId"
                + "   JOIN Categories category ON category.Id=drink.CategoryId"
                + "   JOIN Bills bill ON bill.Id=detail.BillId "
                + "WHERE bill.Status=1 "
                + "   AND bill.Checkout IS NOT NULL "
                + "   AND bill.Checkout BETWEEN ? AND ? "
                + "GROUP BY category.Name "
                + "ORDER BY Revenue DESC";
        return XQuery.getBeanList(BySanPham.class, revenueByCategorySql, begin, end);
    }

    @Override
    public List<ByUser> getByUser(Date begin, Date end) {
        String revenueByUserSql
                = "SELECT bill.Username AS [User], "
                + "   sum(detail.UnitPrice*detail.Quantity*(1-detail.Discount)) AS Revenue,"
                + "   count(DISTINCT detail.BillId) AS Quantity,"
                + "   min(bill.Checkin) AS FirstTime,"
                + "   max(bill.Checkin) AS LastTime "
                + "FROM BillDetails detail "
                + "   JOIN Bills bill ON bill.Id=detail.BillId "
                + "WHERE bill.Status=1 "
                + "   AND bill.Checkout IS NOT NULL "
                + "   AND bill.Checkout BETWEEN ? AND ? "
                + "GROUP BY bill.Username "
                + "ORDER BY Revenue DESC";
        return XQuery.getBeanList(ByUser.class, revenueByUserSql, begin, end);
    }
}
