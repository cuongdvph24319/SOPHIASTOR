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
@Table(name = "ChiTietNuocHoa")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChiTietNuocHoa {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;

    @Column(name = "MaNuocHoa")
    private String maNuocHoa;

    @Column(name = "TenNuocHoa")
    private String tenNuocHoa;

    @Column(name = "SoLuong")
    private Integer soLuong;

    @Column(name = "NamPhatHanh")
    private Integer namPhatHanh;

    @Column(name = "MoTa")
    private String moTa;

    @Column(name = "TrangThai")
    private Integer trangThai;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idChiTietNuocHoa")
    private ChiTietNuocHoa chiTietNuocHoa;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idSanPham")
    private SanPham sanPham;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idNongDo")
    private NongDo nongDo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idDungTich")
    private DungTich dungTich;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idDoToaHuong")
    private DoToaHuong doToaHuong;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idDoLuuHuong")
    private DoLuuHuong doLuuHuong;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idKetCau")
    private KetCau ketCau;

    @OneToMany(mappedBy = "chiTietNuocHoa", fetch = FetchType.LAZY)
    List<ChiTietHuong> chiTietHuongList = new ArrayList<>();
}
