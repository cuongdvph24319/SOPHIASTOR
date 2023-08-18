package poly.edu.sophiastore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "NhanVien")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
@Builder

@ToString
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;
    @Column(name = "MaNhanVien")
    private String maNhanVien;
    @Column(name = "TenNhanVien")
    private String tenNhanVien;
    @Column(name = "NgaySinh")

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date NgaySinh;
    @Column(name = "SoDienThoai")
    private String soDienThoai;
    @Column(name = "DiaChi")
    private String diaChi;
    @Column(name = "Email")
    private String email;
    @Column(name = "MatKhau")
    private String matKhau;
    @Column(name = "TrangThai")
    private Integer trangThai;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdChucVu")
    private ChucVu chucVu;

    @JsonIgnore
    @OneToMany(mappedBy = "nhanVien", fetch = FetchType.LAZY)
    private List<LichSuHoaDon> listLichSuHoaDon = new ArrayList<>();


}
