package poly.edu.sophiastore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import poly.edu.sophiastore.entity.Anh;
import poly.edu.sophiastore.entity.ChiTietNuocHoa;
import poly.edu.sophiastore.repository.AnhRepository;
import poly.edu.sophiastore.repository.ChiTietNuocHoaRepository;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Controller
public class AnhController {
    @Autowired
    private AnhRepository anhRepository;
    @Autowired
    private ChiTietNuocHoaRepository chiTietNuocHoaRepository;

    @Autowired
    public AnhController(AnhRepository anhRepository, ChiTietNuocHoaRepository chiTietNuocHoaRepository) {
        this.anhRepository = anhRepository;
        this.chiTietNuocHoaRepository = chiTietNuocHoaRepository;
    }

    @PostMapping("/add-images")
    public String addImages(@RequestParam("chiTietNuocHoaId") UUID chiTietNuocHoaId,
                            @RequestParam("anh") MultipartFile[] anhFiles) {
        System.out.println("Received chiTietNuocHoaId: " + chiTietNuocHoaId);
        Optional<ChiTietNuocHoa> optionalChiTietNuocHoa = chiTietNuocHoaRepository.findById(chiTietNuocHoaId);
        if (!optionalChiTietNuocHoa.isPresent()) {
            // Xử lý lỗi nếu không tìm thấy sản phẩm với id đã cho
            // Ví dụ: trả về trang lỗi hoặc thông báo lỗi
            return "error-page"; // Ví dụ
        }

        // Lưu các ảnh vào cơ sở dữ liệu cho sản phẩm
        for (MultipartFile anhFile : anhFiles) {
            if (!anhFile.isEmpty()) {
                try {
                    // Tạo đối tượng Anh và lưu thông tin ảnh vào cơ sở dữ liệu
                    Anh anh = new Anh();
                    anh.setChiTietNuocHoa(optionalChiTietNuocHoa.get());
                    anh.setAnh(anhFile.getBytes());
                    anhRepository.save(anh);
                } catch (IOException e) {
                    e.printStackTrace();
                    // Xử lý lỗi nếu cần thiết
                }
            }
        }
        // Sau khi lưu ảnh xong, chuyển hướng hoặc trả về view tùy theo logic của bạn
        // Ví dụ: chuyển hướng về trang hiển thị chi tiết sản phẩm
        return "redirect:/nuoc-hoa/hien-thi";
    }

}
