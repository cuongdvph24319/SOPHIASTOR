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

    @Column(name = "MaDoLuuHuong")
    private String maDoLuuHuong;

    @Column(name = "ThoiGianToiThieu")
    private Integer thoiGianToiThieu;

    @Column(name = "ThoiGianToiDa")
    private Integer thoiGianToiDa;

    @Column(name = "TrangThai")
    private Integer trangThai;

}
