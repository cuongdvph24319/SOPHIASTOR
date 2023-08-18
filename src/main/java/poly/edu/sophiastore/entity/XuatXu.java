package poly.edu.sophiastore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "XuatXu")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class XuatXu {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;

    @Column(name = "MaXuatXu")
    private String maXuatXu;

    @Column(name = "TenXuatXu", columnDefinition = "ntext")
    private String tenXuatXu;

    @Column(name = "TrangThai")
    private Integer trangThai;
}
