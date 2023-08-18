package poly.edu.sophiastore.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "LichSuHoaDon")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LichSuHoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;
    @Column(name = "TrangThai")
    private String trangThai;
    @Column(name = "ThoiGian")
    private Date thoiGian;
    @Column(name = "ThaoTac")
    private String thaoTac;
    @Column(name = "GhiChu")
    private String ghiChu;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdHoaDon")
    private HoaDon hoaDon;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdNhanVien")
    private NhanVien nhanVien;



}