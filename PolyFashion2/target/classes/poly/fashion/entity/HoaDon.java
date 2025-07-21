package poly.fashion.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class HoaDon {
    private Integer maHD;
    private java.sql.Date ngayLap;
    private java.math.BigDecimal tongTien;
    private Integer maKH;
    private Integer maNV;
}

