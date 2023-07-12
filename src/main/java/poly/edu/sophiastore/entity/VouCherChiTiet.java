package poly.edu.sophiastore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "VoucherChiTiet")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VouCherChiTiet {
    @EmbeddedId
    private IdVoucherChiTiet id;

    @Column(name = "SoTienConLai")
    private Double soTienConLai;

    @Column(name = "PhamTramGiam")
    private Double phamTramGiam;

    @Column(name = "TrangThai")
    private Integer trangThai;


}