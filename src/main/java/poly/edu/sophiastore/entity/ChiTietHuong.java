package poly.edu.sophiastore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "ChiTietHuong")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChiTietHuong {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;

    private Integer TrangThai;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idChiTietNuocHoa")
    private ChiTietNuocHoa chiTietNuocHoa;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idTangHuong")
    private TangHuong tangHuong;
}
