package poly.fashion.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ChiTietHoaDon {
    private Integer maCT;
    private Integer maHD;
    private Integer maSP;
    private Integer soLuong;
    private java.math.BigDecimal donGia;
}
