package poly.edu.sophiastore.request;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.aspectj.lang.annotation.RequiredTypes;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import poly.edu.sophiastore.entity.ChucVu;
import java.util.Date;
import java.util.UUID;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NhanVien_View {

    private UUID id;

    @NotBlank(message = "Vui lòng nhập mã nhân viên")
    private String maNhanVien;

    @NotBlank(message = "Vui lòng nhập tên nhân viên")

    private String tenNhanVien;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @NotNull(message = "Vui lòng nhập ngày sinh")
    private Date NgaySinh;


    @NotBlank(message = "Vui lòng nhập số điện thoại")
    private String soDienThoai;


    @NotBlank(message = "Vui lòng nhập địa chỉ")
    private String diaChi;


    @NotBlank(message = "Vui lòng nhập email")
    private String email;

    private String matKhau;


    private Integer trangThai;


    private ChucVu chucVu;


}
