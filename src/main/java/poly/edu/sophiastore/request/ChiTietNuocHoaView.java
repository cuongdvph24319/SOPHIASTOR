package poly.edu.sophiastore.request;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import poly.edu.sophiastore.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ChiTietNuocHoaView {
    private UUID id;
    @NotBlank(message = "Vui lòng nhập mã nước hoa")
    private String maNuocHoa;
    @NotBlank(message = "Vui lòng nhập tên nước hoa")
    private String tenNuocHoa;
    @NotNull(message = "Vui lòng nhập số lượng")
    private Integer soLuong;
    @NotNull(message = "Vui lòng nhập đơn giá")
    private Integer donGia;
    @NotNull(message = "Vui lòng nhập năm phát hành")
    private Integer namPhatHanh;
    @NotBlank(message = "Vui lòng nhập mô tả")
    private String moTa;
    private Integer trangThai;
    private ChiTietNuocHoa chiTietNuocHoa;
    @NotNull(message = "Vui lòng chọn sản phẩm")
    private SanPham sanPham;
    @NotNull(message = "Vui lòng chọn nồng độ")
    private NongDo nongDo;
    @NotNull(message = "Vui lòng chọn dung tích")
    private DungTich dungTich;
    @NotNull(message = "Vui lòng chọn độ tỏa hương")
    private DoToaHuong doToaHuong;
    @NotNull(message = "Vui lòng chọn độ lưu hương")
    private DoLuuHuong doLuuHuong;
    @NotNull(message = "Vui lòng chọn kết cấu")
    private KetCau ketCau;

    private List<ChiTietNuocHoaView> chiTietNuocHoaViews = new ArrayList<>(); // Initialize the list here

    public List<ChiTietNuocHoaView> getChiTietNuocHoaViews() {
        return chiTietNuocHoaViews;
    }

    public void setChiTietNuocHoaViews(List<ChiTietNuocHoaView> chiTietNuocHoaViews) {
        this.chiTietNuocHoaViews = chiTietNuocHoaViews;
    }

    public void loadFormModel(ChiTietNuocHoa chiTietNuocHoa){
        this.setMaNuocHoa(chiTietNuocHoa.getMaNuocHoa());
        this.setTenNuocHoa(chiTietNuocHoa.getTenNuocHoa());
        this.setSoLuong(chiTietNuocHoa.getSoLuong());
        this.setDonGia(chiTietNuocHoa.getDonGia());
        this.setNamPhatHanh(chiTietNuocHoa.getNamPhatHanh());
        this.setMoTa(chiTietNuocHoa.getMoTa());
        this.setTrangThai(chiTietNuocHoa.getTrangThai());
        this.setChiTietNuocHoa(chiTietNuocHoa.getChiTietNuocHoa());
        this.setSanPham(chiTietNuocHoa.getSanPham());
        this.setNongDo(chiTietNuocHoa.getNongDo());
        this.setDungTich(chiTietNuocHoa.getDungTich());
        this.setDoToaHuong(chiTietNuocHoa.getDoToaHuong());
        this.setDoLuuHuong(chiTietNuocHoa.getDoLuuHuong());
        this.setKetCau(chiTietNuocHoa.getKetCau());
    }
}
