package poly.fashion.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Users {
    private String username;
    private String password;
    private boolean enabled;
    private String fullname;
    @Builder.Default
    private String photo = "photo.png";
    private boolean manager;
}