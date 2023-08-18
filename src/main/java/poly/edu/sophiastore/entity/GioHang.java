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
@Table(name = "GioHang")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GioHang {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;

    @Column(name = "MaGioHang")
    private String maGioHang;

    @Column(name = "NgayTao")
    private Date ngayTao;

    @Column(name = "GhiChu")
    private String ghiChu;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdKhachHang")
    private KhachHang khachHang;

    @OneToMany(mappedBy = "id.gioHang", fetch = FetchType.LAZY)
    List<GioHangChiTiet> listGioHangChiTiet = new ArrayList<>();


}
