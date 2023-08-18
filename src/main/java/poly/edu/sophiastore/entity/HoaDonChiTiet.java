package poly.edu.sophiastore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "HoaDonChiTiet")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HoaDonChiTiet {
    @EmbeddedId
    private IdHoaDonChiTiet id;

    @Column(name = "SoLuong")
    private Integer soLuong;

    @Column(name = "DonGia")
    private Double donGia;

    @Column(name = "LyDo", columnDefinition = "ntext")
    private String lyDo;

    @Column(name = "TrangThai")
    private Integer trangThai;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "IdHDCT")
//    private HoaDonChiTiet hoaDonChiTiet;
}
