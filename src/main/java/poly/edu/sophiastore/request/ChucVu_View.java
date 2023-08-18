package poly.edu.sophiastore.request;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import poly.edu.sophiastore.entity.NhanVien;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class ChucVu_View {

    private UUID id;

    private String maChucVu;

    private String tenChucVu;

    private Integer trangThai;


}
