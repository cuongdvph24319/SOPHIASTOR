package poly.edu.sophiastore.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.ArrayList;
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
    @NotNull(message = "Mã khách hàng không được để trống")
    @NotEmpty
    @NotBlank
    private String maKhachHang;

    @Column(name = "tenKhachHang")
//    @NotNull(message = "Tên khách hàng không được để trống")
    private String tenKhachHang;

    @Column(name = "NgaySinh")
//    @NotNull(message = "Tên khách hàng không được để trống")
    private Date ngaySinh;

    @Column(name = "SoDienThoai")
//    @NotNull(message = "Tên khách hàng không được để trống")
    private String soDienThoai;

    @Column(name = "Email")
//    @NotNull(message = "Tên khách hàng không được để trống")
    private String email;

    @Column(name = "MatKhau")
//    @NotNull(message = "Tên khách hàng không được để trống")
    private String matKhau;

    @Column(name = "TrangThai")
//    @NotNull(message = "Tên khách hàng không được để trống")
    private Integer trangThai;

    @OneToMany(mappedBy = "khachHang", fetch = FetchType.LAZY)
    private List<DiaChi> listDiaChi = new ArrayList<>();
    @OneToMany(mappedBy = "khachHang", fetch = FetchType.LAZY)
    private List<GioHang> listGioHang = new ArrayList<>();
    @OneToMany(mappedBy = "khachHang", fetch = FetchType.LAZY)
    private List<HoaDon> listHoaDon = new ArrayList<>();


}