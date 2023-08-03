package poly.edu.sophiastore.request;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import poly.edu.sophiastore.entity.XuatXu;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class XuatXuView {
    private UUID id;
    @NotBlank(message = "Vui lòng nhập mã xuất xứ")
    private String maXuatXu;
    @NotBlank(message = "Vui lòng nhập tên xuất xứ")
    private String tenXuatXu;
    @NotNull(message = "Vui lòng chọn trạng thái")
    private Integer trangThai;

    public void loadFormModel(XuatXu xuatXu){
        this.setMaXuatXu(xuatXu.getMaXuatXu());
        this.setTenXuatXu(xuatXu.getTenXuatXu());
        this.setTrangThai(xuatXu.getTrangThai());
    }
}
