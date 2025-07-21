/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package poly.fashion.dao;

import poly.fashion.entity.HoaDon;

/**
 *
 * @author Admin
 */
import java.util.Date;
import java.util.List;
import poly.fashion.entity.HoaDon;

public interface HoaDonDAO extends CrudDAO<HoaDon, Long>{
    /**
     * Truy vấn theo nhân viên
     * 
     * @param username tên đăng nhập của nhân viên
     * @return kết quả truy vấn
     */
    public List<HoaDon> findByUsername(String username);
    /**
     * Truy vấn theo thẻ định danh
     * 
     * @param cardId mã thẻ định danh
     * @return kết quả truy vấn
     */
    public List<HoaDon> findByCardId(Integer cardId);
    /**
     * Truy vấn đang phục vụ của thẻ
     * 
     * @param cardId mã thẻ định danh
     * @return kết quả truy vấn
     */
    public HoaDon findServicingByCardId(Integer cardId);
    /**
     * Truy vấn theo khoảng thời gian
     * 
     * @param from thời gian bắt đầu truy vấn
     * @param to  thời gian kết thúc truy vấn
     * @return kết quả truy vấn
     */
    public List<HoaDon> findByTimeRange(Date from, Date to);
    /**
     * Truy vấn theo khoảng thời gian
     * 
     * @param username tên đăng nhập của nhân viên
     * @param from thời gian bắt đầu truy vấn
     * @param to  thời gian kết thúc truy vấn
     * @return kết quả truy vấn
     */
    public List<HoaDon> findByUserAndTimeRange(String username, Date from, Date to);
}
