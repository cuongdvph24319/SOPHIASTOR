package poly.edu.sophiastore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "HinhThucThanhToan")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HinhThucThanhToan {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;
    @Column(name = "MaHinhThuc")
    private String maHinhThuc;
    @Column(name = "TenHinhThuc")
    private String tenHinhThuc;
    @Column(name = "SoTien")
    private Double soTien;
    @Column(name = "TrangThai")
    private Integer trangThai;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdHoaDon")
    private HoaDon hoaDon;


}