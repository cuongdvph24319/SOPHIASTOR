package poly.edu.sophiastore.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import poly.edu.sophiastore.entity.SanPham;
import poly.edu.sophiastore.entity.ThuongHieu;
import poly.edu.sophiastore.entity.XuatXu;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class SanPhamView {
    private UUID id;
    private String maSanPham;
    private String tenSanPham;
    private XuatXu xuatXu;
    private ThuongHieu thuongHieu;

    public void loadFormModel(SanPham sanPham){
        this.setMaSanPham(sanPham.getMaSanPham());
        this.setTenSanPham(sanPham.getTenSanPham());
        this.setXuatXu(sanPham.getXuatXu());
        this.setThuongHieu(sanPham.getThuongHieu());
    }

}
