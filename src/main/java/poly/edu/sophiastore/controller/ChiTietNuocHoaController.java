package poly.edu.sophiastore.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import poly.edu.sophiastore.entity.Anh;
import poly.edu.sophiastore.entity.ChiTietNuocHoa;
import poly.edu.sophiastore.entity.DoLuuHuong;
import poly.edu.sophiastore.repository.*;
import poly.edu.sophiastore.request.ChiTietNuocHoaView;
import poly.edu.sophiastore.service.ChiTietNuocHoaService;

import java.util.*;

@Controller
@RequestMapping("nuoc-hoa")
public class ChiTietNuocHoaController {
    @Autowired
    private AnhRepository anhRepo;
    @Autowired
    private ChiTietNuocHoaService chiTietNuocHoaService;
    @Autowired
    private XuatXuRepository xuatXuRepo;
    @Autowired
    private ThuongHieuRepository thuongHieuRepo;
    @Autowired
    private DoLuuHuongRepository doLuuHuongRepo;
    @Autowired
    private DungTichRepository dungTichRepo;
    @Autowired
    private KetCauRepository ketCauRepo;
    @Autowired
    private DoToaHuongRepository doToaHuongRepo;
    @Autowired
    private SanPhamRepository sanPhamRepo;
    @Autowired
    private NongDoRepository nongDoRepo;
    @Autowired
    private ChiTietNuocHoaRepository chiTietNuocHoaRepo;
    @Autowired
    private ChiTietNuocHoaView chiTietNuocHoaView;

    @GetMapping("hien-thi")
    public String hienThi(Model model,
                          @RequestParam(name = "page", defaultValue = "0") Integer pageNo,
                          @RequestParam(value = "thuongHieu", required = false) UUID thuongHieuId,
                          @RequestParam(value = "xuatXu", required = false) UUID xuatXuId,
                          @RequestParam(value = "sanPham", required = false) UUID sanPhamId,
                          @RequestParam(value = "nongDo", required = false) UUID nongDoId,
                          @RequestParam(value = "dungTich", required = false) UUID dungTichId,
                          @RequestParam(value = "doToaHuong", required = false) UUID doToaHuongId,
                          @RequestParam(value = "doLuuHuong", required = false) UUID doLuuHuongId,
                          @RequestParam(value = "ketCau", required = false) UUID ketCauId) {

        int pageSize = 5;

        List<ChiTietNuocHoa> filteredChiTietNuocHoaList = chiTietNuocHoaRepo.filterProducts(thuongHieuId, xuatXuId, sanPhamId,
                nongDoId, dungTichId, doToaHuongId, doLuuHuongId, ketCauId);

        int totalPages = (int) Math.ceil((double) filteredChiTietNuocHoaList.size() / pageSize);

        int startIndex = pageNo * pageSize;
        int endIndex = Math.min(startIndex + pageSize, filteredChiTietNuocHoaList.size());

        List<ChiTietNuocHoa> paginatedList = filteredChiTietNuocHoaList.subList(startIndex, endIndex);

        model.addAttribute("page", pageNo);
        model.addAttribute("danhSachXuatXu", this.xuatXuRepo.findAll());
        model.addAttribute("danhSachThuongHieu", this.thuongHieuRepo.findAll());
        model.addAttribute("danhSachNuocHoa", paginatedList);
        model.addAttribute("danhSachDoLuuHuong", this.doLuuHuongRepo.findAll());
        model.addAttribute("danhSachDungTich", this.dungTichRepo.findAll());
        model.addAttribute("danhSachSanPham", this.sanPhamRepo.findAll());
        model.addAttribute("danhSachKetCau", this.ketCauRepo.findAll());
        model.addAttribute("danhSachDoToaHuong", this.doToaHuongRepo.findAll());
        model.addAttribute("danhSachNongDo", this.nongDoRepo.findAll());
        model.addAttribute("totalPages", totalPages);

        return "chitietsanpham/NuocHoa";
    }


    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("danhSachDoLuuHuong", this.doLuuHuongRepo.findAll());
        model.addAttribute("danhSachDungTich", this.dungTichRepo.findAll());
        model.addAttribute("danhSachSanPham", this.sanPhamRepo.findAll());
        model.addAttribute("danhSachKetCau", this.ketCauRepo.findAll());
        model.addAttribute("danhSachDoToaHuong", this.doToaHuongRepo.findAll());
        model.addAttribute("danhSachNongDo", this.nongDoRepo.findAll());
        model.addAttribute("data", this.chiTietNuocHoaView);
        model.addAttribute("button", "create");
        model.addAttribute("action", "/nuoc-hoa/store");
        return "chitietsanpham/create";
    }

    @PostMapping("store")
    public String store(@Valid @ModelAttribute("data") ChiTietNuocHoaView chiTietNuocHoaView,
                        Model model, BindingResult result) {
        model.addAttribute("button", "create");

        if (result.hasErrors()) {
            model.addAttribute("button", "create");
            model.addAttribute("data", this.chiTietNuocHoaView);
            return "chitietnuochoa/create";
        }

        ChiTietNuocHoa chiTietNuocHoa = new ChiTietNuocHoa();
        chiTietNuocHoa.loadFormViewModel(chiTietNuocHoaView);
        chiTietNuocHoa.setTrangThai(1);
        this.chiTietNuocHoaRepo.save(chiTietNuocHoa);
        model.addAttribute("productId", chiTietNuocHoa.getId());
        return "chitietsanpham/create";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") ChiTietNuocHoa chiTietNuocHoa) {
        this.chiTietNuocHoaRepo.delete(chiTietNuocHoa);
        return "redirect:/nuoc-hoa/hien-thi";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") UUID chiTietNuocHoaId, Model model) {
        Optional<ChiTietNuocHoa> optionalChiTietNuocHoa = chiTietNuocHoaRepo.findById(chiTietNuocHoaId);
        if (optionalChiTietNuocHoa.isPresent()) {
            ChiTietNuocHoa chiTietNuocHoa = optionalChiTietNuocHoa.get();
            model.addAttribute("chiTietNuocHoa", chiTietNuocHoa);
            model.addAttribute("productId", chiTietNuocHoa.getId());
            // Retrieve the list of images associated with the product
            List<Anh> danhSachAnh = anhRepo.findByChiTietNuocHoa(chiTietNuocHoa);
            model.addAttribute("danhSachAnh", danhSachAnh);

            // Convert byte array images to Base64 strings
            List<String> danhSachAnhBase64 = new ArrayList<>();
            for (Anh anh : danhSachAnh) {
                String base64Image = Base64.getEncoder().encodeToString(anh.getAnh());
                danhSachAnhBase64.add(base64Image);
            }
            model.addAttribute("danhSachAnhBase64", danhSachAnhBase64);

            this.chiTietNuocHoaView.loadFormModel(chiTietNuocHoa);
            model.addAttribute("danhSachDoLuuHuong", this.doLuuHuongRepo.findAll());
            model.addAttribute("danhSachDungTich", this.dungTichRepo.findAll());
            model.addAttribute("danhSachSanPham", this.sanPhamRepo.findAll());
            model.addAttribute("danhSachKetCau", this.ketCauRepo.findAll());
            model.addAttribute("danhSachDoToaHuong", this.doToaHuongRepo.findAll());
            model.addAttribute("danhSachNongDo", this.nongDoRepo.findAll());
            model.addAttribute("data", this.chiTietNuocHoaView);
            model.addAttribute("button", "update");
            model.addAttribute("action", "/nuoc-hoa/update/" + chiTietNuocHoa.getId());

            return "chitietsanpham/create";
        } else {
            // Trả về trang lỗi hoặc điều hướng đến trang khác
            model.addAttribute("errorMessage", "Không tìm thấy sản phẩm với id đã cho.");
            return "error-page"; // Thay thế "error-page" bằng đường dẫn tới trang lỗi thực tế của bạn
        }
    }


    @GetMapping("/image/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable("id") UUID imageId) {
        // Truy vấn cơ sở dữ liệu để lấy dữ liệu ảnh theo imageId
        Optional<Anh> optionalAnh = anhRepo.findById(imageId);
        if (optionalAnh.isPresent()) {
            Anh anh = optionalAnh.get();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG); // Hoặc MediaType.IMAGE_PNG nếu là ảnh PNG
            return new ResponseEntity<>(anh.getAnh(), headers, HttpStatus.OK);
        } else {
            // Trả về mã lỗi 404 (Not Found) nếu không tìm thấy ảnh
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("update/{id}")
    public String update(@PathVariable("id") ChiTietNuocHoa oldValue,
                         @ModelAttribute("data") ChiTietNuocHoaView newValue, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("danhSachDoLuuHuong", this.doLuuHuongRepo.findAll());
            model.addAttribute("danhSachDungTich", this.dungTichRepo.findAll());
            model.addAttribute("danhSachSanPham", this.sanPhamRepo.findAll());
            model.addAttribute("danhSachKetCau", this.ketCauRepo.findAll());
            model.addAttribute("danhSachDoToaHuong", this.doToaHuongRepo.findAll());
            model.addAttribute("danhSachNongDo", this.nongDoRepo.findAll());
            model.addAttribute("data", this.chiTietNuocHoaView);
            return "chitietsanpham/create";
        }
        oldValue.loadFormViewModel(newValue);
        this.chiTietNuocHoaRepo.save(oldValue);
        model.addAttribute("productId", oldValue.getId());
        return "redirect:/nuoc-hoa/hien-thi";
    }

}
