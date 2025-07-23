package poly.fashion.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class SanPham {
    private String id;
    private String name;
    @Builder.Default
    private String image = "product.png";
    private double unitPrice;
    private double discount;
    private boolean available;
    private String categoryId;
}