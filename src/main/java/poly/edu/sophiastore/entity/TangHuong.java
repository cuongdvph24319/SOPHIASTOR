package poly.edu.sophiastore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "TangHuong")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TangHuong {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;

    @Column(name = "MaTangHuong")
    private String maTangHuong;

    @Column(name = "TenTangHuong", columnDefinition = "ntext")
    private String tenTangHuong;

    @Column(name = "TrangThai")
    private Integer trangThai;
}
