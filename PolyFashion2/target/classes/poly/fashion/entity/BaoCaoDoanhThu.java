package poly.fashion.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BaoCaoDoanhThu {
    private Integer maBC;
    private Integer thang;
    private Integer nam;
    private java.math.BigDecimal tongDoanhThu;
}
