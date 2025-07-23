/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.fashion.ui;

/**
 *
 * @author THIS PC
 */
import javax.swing.JDialog;
import javax.swing.JFrame;
import poly.fashion.ui.manager.BaoCaoDoanhThuManagerJDialog;
import poly.fashion.ui.manager.SanPhamManagerJDialog;
import poly.fashion.ui.manager.UserManagerJDialog;
import poly.fashion.util.XDialog;

public interface PolyFashionController {
    /**
     * Hiển thị cửa sổ chào
     * Hiển thị cửa sổ đăng nhập
     * Hiển thị thông tin user đăng nhập
     * Disable/Enable các thành phần tùy thuộc vào vai trò đăng nhập
     */
    void init();
    
    default void exit(){
        if(XDialog.confirm("Bạn muốn kết thúc?")){
            System.exit(0);
        }
    }
    default void showJDialog(JDialog dialog){
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
    default void showWelcomeJDialog(JFrame frame){
        this.showJDialog(new WelcomeJDialog(frame, true));
    }
    default void showLoginJDialog(JFrame frame){
        this.showJDialog(new LoginJDialog(frame, true));
    }
    default void showChangePasswordJDialog(JFrame frame){
        this.showJDialog(new ChangePasswordJDialog(frame, true));
    }
//    default void showSalesJDialog(JFrame frame){
//        this.showJDialog(new SalesJDialog(frame, true));
//    }
    default void showLichSuJDialog(JFrame frame){
        this.showJDialog(new LichSuJDialog(frame, true));
    }
    
//    default void showDrinkManagerJDialog(JFrame frame){
//        this.showJDialog(new DrinkManagerJDialog(frame, true));
//    }
    default void showSanPhamManagerJDialog(JFrame frame){
        this.showJDialog(new SanPhamManagerJDialog(frame, true));
    }
//    default void showCardManagerJDialog(JFrame frame){
//        this.showJDialog(new CardManagerJDialog(frame, true));
//    }
    default void showPhieuBanHangJDialog(JFrame frame){
        this.showJDialog(new PhieuBanHangJDialog(frame, true));
    }
    default void showUserManagerJDialog(JFrame frame){
        this.showJDialog(new UserManagerJDialog(frame, true));
    }
    default void showBaoCaoDoanhThuManagerJDialog(JFrame frame){
        this.showJDialog(new BaoCaoDoanhThuManagerJDialog(frame, true));
    }
}