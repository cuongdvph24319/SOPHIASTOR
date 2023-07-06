package poly.edu.sophiastore.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
@Entity
@Table(name = "Voucher")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;
    @Column(name = "MaGiamGia")
    private String maGiamGia;
    @Column(name = "SoLuong")
    private Integer soLuong;
    @Column(name = "NgayBatDau")
    private Date ngayBatDau;
    @Column(name = "NgayKetThuc")
    private Date ngayKetThuc;
    @Column(name = "TrangThai")
    private Integer trangThai;
    @Column(name = "DieuKienGiamGia")
    private String dieuKienGiamGia;
    @Column(name = "PhanTramGiamGia")
    private String phanTramGiamGia;

    @OneToMany(mappedBy = "id.voucher", fetch = FetchType.LAZY)
    private List<VouCherChiTiet> listVoucher = new ArrayList<>();

}
