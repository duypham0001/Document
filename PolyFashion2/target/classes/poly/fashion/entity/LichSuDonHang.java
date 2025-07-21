package poly.fashion.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class LichSuDonHang {
    private Integer maLS;
    private Integer maHD;
    private java.sql.Date ngayCapNhat;
    private String trangThai;
    private String ghiChu;
}
