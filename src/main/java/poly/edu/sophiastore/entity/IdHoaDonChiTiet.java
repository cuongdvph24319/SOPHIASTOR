package poly.edu.sophiastore.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class IdHoaDonChiTiet implements Serializable {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdChiTietNuocHoa")
    private ChiTietNuocHoa chiTietNuocHoa;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdHoaDon")
    private HoaDon hoaDon;

}
