/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.fashion.ui;

/**
 *
 * @author THIS PC
 */
import poly.fashion.util.XDialog;

import javax.swing.JDialog;
import javax.swing.JFrame;
import poly.fashion.ui.manager.BaoCaoDoanhThuManagerJDialog;
import poly.fashion.ui.manager.SanPhamManagerJDialog;
import poly.fashion.ui.manager.UserManagerJDialog;

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
default void showBaoCaoDoanhThuManagerJDialog(JFrame frame){
this.showJDialog(new BaoCaoDoanhThuManagerJDialog(frame, true));
}
default void showLichSuJDialog(JFrame frame){
this.showJDialog(new LichSuJDialog(frame, true));
}
default void showUserManagerJDialog(JFrame frame){
this.showJDialog(new UserManagerJDialog(frame, true));
}
default void showSanPhamManagerJDialog(JFrame frame){
this.showJDialog(new SanPhamManagerJDialog(frame, true));
}
}