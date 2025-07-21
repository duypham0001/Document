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

    // Thêm các trường dưới đây để phù hợp với XAuth.java
    private String username;
    private String password;
    private Boolean enabled;
    private Boolean manager;
    private String fullname;
    private String photo;
}
