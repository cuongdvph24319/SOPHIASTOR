package poly.edu.sophiastore.request;


import jakarta.persistence.PostLoad;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import poly.edu.sophiastore.entity.Voucher;

import java.util.Date;
import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class VoucherView {
    private UUID id;
    @NotBlank(message = "Vui lòng nhập mã giảm giá")
    private String maGiamGia;
    @NotBlank(message = "Vui lòng nhập tên giảm giá")
    private String tenGiamGia;
    @Min(value = 0, message = "Số lượng phải lớn hơn hoặc bằng 0")
    @Max(value = 50, message = "Số lượng không được vượt quá 50")
    @NotNull(message = "Vui lòng nhập số lượng")
    private Integer soLuong;
    @NotNull(message = "Vui lòng nhập ngày bắt đầu")
    @FutureOrPresent(message = "Ngày bắt đầu phải là ngày hiện tại hoặc tương lai")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayBatDau;
    @NotNull(message = "Vui lòng nhập ngày kết thúc")
    @FutureOrPresent(message = "Ngày bắt đầu phải là ngày hiện tại hoặc tương lai")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayKetThuc;
    @NotNull(message = "Vui lòng chọn trạng thái")
    private Integer trangThai;
    @NotBlank(message = "Vui lòng nhập điều kiện giảm giá")
    private String dieuKienGiamGia;
    @NotBlank(message = "Vui lòng nhập phần trăm giảm giá")
    private String phanTramGiamGia;
    @AssertTrue(message = "Ngày kết thúc phải  hơn ngày lớn hơn ngày bắt đầu")
    private boolean duplicate;
    public boolean isValidDates() {
        return ngayBatDau == null || ngayKetThuc == null || ngayBatDau.before(ngayKetThuc);
    }
    @PostLoad
    public void checkMinMax() {
        if (soLuong == null || soLuong < 0) {
            setSoLuong(0);
        } else if (soLuong > 50) {
            setSoLuong(50);
        }
    }


    public void loadFormModel(Voucher voucher){
        this.setMaGiamGia(voucher.getMaGiamGia());
        this.setTenGiamGia(voucher.getTenGiamGia());
        this.setSoLuong(voucher.getSoLuong());
        this.setNgayBatDau(voucher.getNgayBatDau());
        this.setNgayKetThuc(voucher.getNgayKetThuc());
        this.setTrangThai(voucher.getTrangThai());
        this.setDieuKienGiamGia(voucher.getDieuKienGiamGia());
        this.setPhanTramGiamGia(voucher.getPhanTramGiamGia());
    }

}
