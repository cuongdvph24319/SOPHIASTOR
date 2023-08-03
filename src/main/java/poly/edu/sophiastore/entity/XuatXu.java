package poly.edu.sophiastore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import poly.edu.sophiastore.request.XuatXuView;

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

    @Column(name = "TenXuatXu")
    private String tenXuatXu;

    @Column(name = "TrangThai")
    private Integer trangThai;

    public void loadFormViewModel(XuatXuView xuatXu){
        this.setMaXuatXu(xuatXu.getMaXuatXu());
        this.setTenXuatXu(xuatXu.getTenXuatXu());
        this.setTrangThai(xuatXu.getTrangThai());
    }
}
