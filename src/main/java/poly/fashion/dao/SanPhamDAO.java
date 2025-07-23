/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package poly.fashion.dao;

import java.util.List;
import poly.fashion.entity.SanPham;

/**
 *
 * @author Admin
 */
public interface SanPhamDAO extends CrudDAO<SanPham, String> {
    

    /**
     * Truy vấn theo loại
     * 
     * @param categoryId mã loại đồ uống
     * @return kết quả truy vấn
     */
    List<SanPham> findByCategoryId(String categoryId);
}
