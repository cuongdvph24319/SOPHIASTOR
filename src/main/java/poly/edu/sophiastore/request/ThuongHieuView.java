package poly.edu.sophiastore.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import poly.edu.sophiastore.entity.ThuongHieu;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ThuongHieuView {
    private UUID id;
    @NotBlank(message = "Vui lòng nhập mã thương hiệu")
    private String maThuongHieu;
    @NotBlank(message = "Vui lòng nhập tên thương hiệu")
    private String tenThuongHieu;
    @NotNull(message = "Vui lòng chọn trạng thái của thương hiệu")
    private Integer trangThai;

    public void loadFormModel(ThuongHieu thuongHieu){
        this.setMaThuongHieu(thuongHieu.getMaThuongHieu());
        this.setTenThuongHieu(thuongHieu.getTenThuongHieu());
        this.setTrangThai(thuongHieu.getTrangThai());
    }
}
