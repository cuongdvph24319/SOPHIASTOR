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

    private String MaSanPham;

    private String TenSanPham;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdXuatXu")
    private XuatXu xuatXu;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdThuongHieu")
    private ThuongHieu thuongHieu;

}
