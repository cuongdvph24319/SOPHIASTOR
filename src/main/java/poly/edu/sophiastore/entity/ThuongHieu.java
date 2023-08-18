package poly.edu.sophiastore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "ThuongHieu")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ThuongHieu {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;

    @Column(name = "MaThuongHieu")
    private String maThuongHieu;

    @Column(name = "TenThuongHieu", columnDefinition = "ntext")
    private String tenThuongHieu;

    @Column(name = "TrangThai")
    private Integer trangThai;
}
