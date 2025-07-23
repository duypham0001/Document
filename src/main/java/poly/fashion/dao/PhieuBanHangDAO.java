/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package poly.fashion.dao;

import java.util.List;
import poly.fashion.entity.PhieuBanHang;

public interface PhieuBanHangDAO extends CrudDAO<PhieuBanHang, Long>{
    /**
     * Truy vấn theo phiếu bán hàng
     * 
     * @param billId mã bill
     * @return kết quả truy vấn
     */
    public List<PhieuBanHang> findByBillId(Long billId);
    /**
     * Truy vấn theo đồ uống
     * 
     * @param drinkId mã đồ uống
     * @return kết quả truy vấn
     */
    public List<PhieuBanHang> findByDrinkId(String drinkId);
}
