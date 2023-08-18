package poly.edu.sophiastore.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.ArrayList;

import java.util.List;
import java.util.UUID;
@Entity
@Table(name = "HoaDon")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;
    @Column(name = "MaHoaDon")
    private String maHoaDon;

    @Column(name = "NgayTao")
    private Date ngayTao;

    @Column(name = "NgayThanhToan")
    private Date ngayThanhToan;

    @Column(name = "NgayGiaoHang")
    private Date ngayGiaoHang;

    @Column(name = "NgayNhan")
    private Date ngayNhan;

    @Column(name = "NgayMongMuonNhan")
    private Date ngayMongMuonNhan;

    @Column(name = "MaGiaoDich")
    private String maGiaoDich;

    @Column(name = "PhanTramGiam")
    private String phanTramGiam;

    @Column(name = "TongTien")
    private Double tongTien;

    @Column(name = "TongTienSauKhiGiam")
    private Double tongTienSauKhiGiam;

    @Column(name = "LoaiHoaDon")
    private String loaiHoaDon;

    @Column(name = "TrangThai")
    private Integer trangThai;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdKhachHang")
    private KhachHang khachHang;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdNhanVien")
    private NhanVien nhanVien;

    @OneToMany(mappedBy = "hoaDon", fetch = FetchType.LAZY)
    private List<PhieuGiaoHang> listPhieuGiaoHang = new ArrayList<>();

    @OneToMany(mappedBy = "id.hoaDon", fetch = FetchType.LAZY)
    private List<VouCherChiTiet> listVoucherChiTiet = new ArrayList<>();

    @OneToMany(mappedBy = "hoaDon", fetch = FetchType.LAZY)
    private List<HinhThucThanhToan> listHinhThucThanhToan = new ArrayList<>();

    @OneToMany(mappedBy = "hoaDon", fetch = FetchType.LAZY)
    private List<LichSuHoaDon> listLichSuHoaDon = new ArrayList<>();

    @OneToMany(mappedBy = "id.hoaDon", fetch = FetchType.LAZY)
    private List<HoaDonChiTiet> listHoaDonChiTiet = new ArrayList<>();
}
