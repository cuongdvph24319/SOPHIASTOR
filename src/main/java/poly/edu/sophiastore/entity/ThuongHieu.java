package poly.edu.sophiastore.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import poly.edu.sophiastore.request.ThuongHieuView;

import java.util.UUID;

@Entity
@Table(name = "ThuongHieu")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ThuongHieu {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;
    @Column(name = "MaThuongHieu")
    private String maThuongHieu;
    @Column(name = "TenThuongHieu")
    private String tenThuongHieu;
    @Column(name = "TrangThai")
    private Integer trangThai;

    public void loadFormViewModel(ThuongHieuView thuongHieu){
        this.setMaThuongHieu(thuongHieu.getMaThuongHieu());
        this.setTenThuongHieu(thuongHieu.getTenThuongHieu());
        this.setTrangThai(thuongHieu.getTrangThai());
    }
}

