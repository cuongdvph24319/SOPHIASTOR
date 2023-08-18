package poly.edu.sophiastore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Column(name = "TenSanPham", columnDefinition = "ntext")
    private String tenSanPham;

    @Column(name = "TrangThai")
    private Integer trangThai;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdXuatXu")
    private XuatXu xuatXu;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdThuongHieu")
    private ThuongHieu thuongHieu;

}
