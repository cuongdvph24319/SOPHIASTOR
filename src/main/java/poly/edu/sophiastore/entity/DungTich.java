package poly.edu.sophiastore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import poly.edu.sophiastore.request.DungTichView;

import java.util.UUID;

@Entity
@Table(name = "DungTich")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DungTich {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;

    @Column(name = "MaDungTich")
    private String maDungTich;

    @Column(name = "DungTich")
    private Integer dungTich;

    @Column(name = "TrangThai")
    private Integer trangThai;

    public void loadFormViewModel(DungTichView dungTich){
        this.setMaDungTich(dungTich.getMaDungTich());
        this.setDungTich(dungTich.getDungTich());
        this.setTrangThai(dungTich.getTrangThai());
    }
}
