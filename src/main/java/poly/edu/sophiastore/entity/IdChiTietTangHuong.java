package poly.edu.sophiastore.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
public class IdChiTietTangHuong implements Serializable {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdTangHuong")
    private TangHuong tangHuong;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdHuong")
    private Huong huong;
}
