package poly.edu.sophiastore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "KetCau")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KetCau {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;

    @Column(name = "MaKetCau")
    private String maKetCau;

    @Column(name = "TenKetCau", columnDefinition = "ntext")
    private String tenKetCau;

    @Column(name = "TrangThai")
    private Integer trangThai;
}
