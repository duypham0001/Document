/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package poly.fashion.ui;

import poly.fashion.entity.PhieuBanHang;
import poly.fashion.ui.manager.CrudController;

/**
 *
 * @author Admin
 */
public interface PhieuBanHangController extends CrudController<PhieuBanHang>{

    void fillBillDetails();
    void selectTimeRange();
}    

