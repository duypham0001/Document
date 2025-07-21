package poly.fashion.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class KhachHang {
    private Integer maKH;
    private String tenKH;
    private String soDienThoai;
    private String email;
    private String diaChi;
    private java.sql.Date ngayDangKy;
}
