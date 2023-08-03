package poly.edu.sophiastore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Base64;
import java.util.UUID;

@Entity
@Table(name = "Anh")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Anh {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;

    @Lob
    @Column(name = "Anh")
    private byte[] anh;

    private Integer TrangThai;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idChiTietNuocHoa")
    private ChiTietNuocHoa chiTietNuocHoa;

    public String getBase64Image() {
        return Base64.getEncoder().encodeToString(this.anh);
    }
}
