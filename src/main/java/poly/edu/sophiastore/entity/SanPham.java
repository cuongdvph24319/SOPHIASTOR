package poly.edu.sophiastore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import poly.edu.sophiastore.request.SanPhamView;

import java.util.UUID;

@Entity
@Table(name = "SanPham")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;

    @Column(name = "MaSanPham")
    private String maSanPham;

    @Column(name = "TenSanPham")
    private String tenSanPham;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdXuatXu")
    private XuatXu xuatXu;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdThuongHieu")
    private ThuongHieu thuongHieu;

    public void loadFormViewModel(SanPhamView sanPham){
        this.setMaSanPham(sanPham.getMaSanPham());
        this.setTenSanPham(sanPham.getTenSanPham());
        this.setXuatXu(sanPham.getXuatXu());
        this.setThuongHieu(sanPham.getThuongHieu());
    }
}
