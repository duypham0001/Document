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

    @Override
    public String toString() {
        return this.name;
    }
}