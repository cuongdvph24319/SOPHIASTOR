package poly.edu.sophiastore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "DiaChi")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DiaChi {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;

    @Column(name = "MaDiaChi")
    private String maDiaChi;

    @Column(name = "MoTaChiTiet", columnDefinition = "ntext")
    private String moTaChiTiet;

    @Column(name = "QuanHuyen", columnDefinition = "ntext")
    private String quanHuyen;

    @Column(name = "ThanhPho", columnDefinition = "ntext")
    private String thanhPho;

    @Column(name = "Tinh", columnDefinition = "ntext")
    private String tinh;

    @Column(name = "QuocGia", columnDefinition = "ntext")
    private String quocGia;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdKhachHang")
    private KhachHang khachHang;

    @OneToMany(mappedBy = "diaChi", fetch = FetchType.LAZY)
    private List<PhieuGiaoHang> listPhieuGiaoHang = new ArrayList<>();
}
