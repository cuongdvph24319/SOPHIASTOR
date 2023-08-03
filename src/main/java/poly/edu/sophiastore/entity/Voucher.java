package poly.edu.sophiastore.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import poly.edu.sophiastore.request.VoucherView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
@Entity
@Table(name = "Voucher")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;
    @Column(name = "MaGiamGia")
    private String maGiamGia;
    @Column(name = "TenGiamGia")
    private String tenGiamGia;
    @Column(name = "SoLuong")
    private Integer soLuong;
    @NotNull
    @FutureOrPresent(message = "Ngày bắt đầu phải là ngày hiện tại hoặc tương lai")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "NgayBatDau")
    private Date ngayBatDau;
    @NotNull
    @FutureOrPresent(message = "Ngày bắt đầu phải là ngày hiện tại hoặc tương lai")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "NgayKetThuc")
    private Date ngayKetThuc;
    @Column(name = "TrangThai")
    private Integer trangThai;
    @Column(name = "DieuKienGiamGia")
    private String dieuKienGiamGia;
    @Column(name = "PhanTramGiamGia")
    private String phanTramGiamGia;

    @OneToMany(mappedBy = "id.voucher", fetch = FetchType.LAZY)
    private List<VouCherChiTiet> listVoucher = new ArrayList<>();

    public void loadFormViewModel(VoucherView voucher){
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
