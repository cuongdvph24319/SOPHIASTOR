package poly.edu.sophiastore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "DoLuuHuong")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DoLuuHuong {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;

    @Column(name = "MaDoLuuHUong")
    private String maDoLuuHUong;

    @Column(name = "KhoangCachToiThieu")
    private Integer kcToiThieu;

    @Column(name = "KhoangCachToiDa")
    private Integer KCToiDa;

    @Column(name = "TrangThai")
    private Integer trangThai;

}
