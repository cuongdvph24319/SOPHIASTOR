package poly.edu.sophiastore.service;

import org.springframework.stereotype.Service;
import poly.edu.sophiastore.entity.ChiTietNuocHoa;
import poly.edu.sophiastore.repository.ChiTietNuocHoaRepository;

import java.util.List;
import java.util.UUID;

@Service
public class ChiTietNuocHoaService {
    private ChiTietNuocHoaRepository chiTietNuocHoaRepo = null;
    public List<ChiTietNuocHoa> filterProducts(UUID thuongHieu, UUID xuatXu, UUID sanPham,
                                               UUID nongDo, UUID dungTich, UUID doToaHuong,
                                               UUID doLuuHuong, UUID ketCau) {
        // Triển khai logic filter dữ liệu dựa trên các tham số đã nhận từ controller
        // Sử dụng các phương thức tương ứng trong repository để truy vấn dữ liệu
        // Ví dụ:
        return chiTietNuocHoaRepo.filterProducts(thuongHieu, xuatXu, sanPham, nongDo, dungTich, doToaHuong, doLuuHuong, ketCau);
    }

}
