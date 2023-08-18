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
@Table(name = "KhachHang")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;
    @Column(name = "MaKhachHang")
    private String maKhachHang;
    @Column(name = "tenKhachHang", columnDefinition = "ntext")
    private String tenKhachHang;
    @Column(name = "NgaySinh")
    private Date ngaySinh;
    @Column(name = "SoDienThoai")
    private String soDienThoai;
    @Column(name = "Email")
    private String email;
    @Column(name = "MatKhau")
    private String matKhau;
    @Column(name = "TrangThai")
    private Integer trangThai;
    @OneToMany(mappedBy = "khachHang", fetch = FetchType.LAZY)
    private List<DiaChi> listDiaChi = new ArrayList<>();
    @OneToMany(mappedBy = "khachHang", fetch = FetchType.LAZY)
    private List<GioHang> listGioHang = new ArrayList<>();
    @OneToMany(mappedBy = "khachHang", fetch = FetchType.LAZY)
    private List<HoaDon> listHoaDon = new ArrayList<>();


}