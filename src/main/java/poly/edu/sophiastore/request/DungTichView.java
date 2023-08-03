package poly.edu.sophiastore.request;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import poly.edu.sophiastore.entity.DungTich;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class DungTichView {
    private UUID id;
    private String maDungTich;
    private Integer dungTich;
    private Integer trangThai;

    public void loadFormModel(DungTich dungTich){
        this.setMaDungTich(dungTich.getMaDungTich());
        this.setDungTich(dungTich.getDungTich());
        this.setTrangThai(dungTich.getTrangThai());
    }

}
