/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package poly.fashion.dao;

import java.util.List;
import poly.fashion.entity.PhieuBanHangDeTai;

public interface PhieuBanHangDeTaiDAO extends CrudDAO<PhieuBanHangDeTai, Long>{
    /**
     * Truy vấn theo phiếu bán hàng
     * 
     * @param PhieuBanId mã bill
     * @return kết quả truy vấn
     */
    public List<PhieuBanHangDeTai> findByPhieuBanHangId(Long billId);
    /**
     * Truy vấn theo đồ uống
     * 
     * @param sanphamId mã đồ uống
     * @return kết quả truy vấn
     */
    public List<PhieuBanHangDeTai> findBySanPhamId(String sanphamId);
}
