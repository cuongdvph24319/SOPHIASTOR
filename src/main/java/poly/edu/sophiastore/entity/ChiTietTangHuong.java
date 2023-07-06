package poly.edu.sophiastore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ChiTietTangHuong")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChiTietTangHuong {
    @EmbeddedId
    @Column(name = "Id")
    private IdChiTietTangHuong id;

    @Column(name = "TrangThai")
    private Integer trangThai;

}
