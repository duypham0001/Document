package poly.fashion.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class User {
    private Integer maUser;
    private String hoTen;
    private String email;
    private String soDienThoai;
    private String diaChi;
    private Integer maTK;
}
