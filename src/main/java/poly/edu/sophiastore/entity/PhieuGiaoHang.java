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
@Table(name = "PhieuGiaoHang")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PhieuGiaoHang {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;
    @Column(name = "MaPhieuGiaoHang")
    private String maPhieuGiaoHang;
    @Column(name = "TenNguoiNhan")
    private String tenNguoiNhan;
    @Column(name = "SoDienThoaiNguoiNhan")
    private String soDienThoaiNguoiNhan;
    @Column(name = "NguoiGiao")
    private String nguoiGiao;
    @Column(name = "SoDienThoaiNguoiGiao")
    private String soDienThoaiNguoiGiao;
    @Column(name = "NgayGiao")
    private Date ngayGiao;
    @Column(name = "NgayNhan")
    private Date ngayNhan;
    @Column(name = "NguoiTao")
    private String nguoiTao;
    @Column(name = "PhiGiaoHang")
    private Double phiGiaoHang;
    @Column(name = "GhiChu")
    private String ghiChu;
    @Column(name = "TrangThai")
    private Integer trangThai;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdHoaDon")
    private HoaDon hoaDon;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdDiaChi")
    private DiaChi diaChi;



}