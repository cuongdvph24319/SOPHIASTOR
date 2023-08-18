package poly.edu.sophiastore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "Huong")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Huong {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;

    @Column(name = "MaHuong")
    private String maHuong;

    @Column(name = "TenHuong", columnDefinition = "ntext")
    private String tenHuong;

    @Column(name = "TrangThai")
    private Integer trangThai;
}
