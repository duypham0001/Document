package poly.fashion.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SanPham {
    private Integer maSP;
    private String tenSP;
    private String moTa;
    private java.math.BigDecimal gia;
    private Integer soLuong;
}
