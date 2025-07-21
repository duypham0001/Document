package poly.fashion.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class NhanVien {
    private Integer maNV;
    private String tenNV;
    private Boolean gioiTinh;
    private java.sql.Date ngaySinh;
    private String soDienThoai;
    private String diaChi;
    private String email;
    private Integer maTK;
}
    