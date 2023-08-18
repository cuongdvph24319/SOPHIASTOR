package poly.edu.sophiastore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "NongDo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NongDo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;

    @Column(name = "MaNongDo")
    private String maNongDo;

    @Column(name = "TenNongDo")
    private String tenNongDo;

    @Column(name = "TrangThai")
    private Integer trangThai;
}
