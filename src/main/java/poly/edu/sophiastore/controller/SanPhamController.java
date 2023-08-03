package poly.edu.sophiastore.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import poly.edu.sophiastore.entity.SanPham;
import poly.edu.sophiastore.entity.XuatXu;
import poly.edu.sophiastore.repository.SanPhamRepository;
import poly.edu.sophiastore.repository.ThuongHieuRepository;
import poly.edu.sophiastore.repository.XuatXuRepository;
import poly.edu.sophiastore.request.SanPhamView;
import poly.edu.sophiastore.request.XuatXuView;

import java.util.List;

@Controller
@RequestMapping("san-pham")
public class SanPhamController {
    @Autowired
    private ThuongHieuRepository thuongHieuRepo;
    @Autowired
    private SanPhamRepository sanPhamRepo;
    @Autowired
    private XuatXuRepository xuatXuRepo;
    @Autowired
    private SanPhamView sanPhamView;
    @Autowired
    private XuatXuView xuatXuView;

    @GetMapping("/hien-thi")
    public String indexXuatXu(Model model, @RequestParam(name = "page", defaultValue = "0") Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 5);
        Page<SanPham> sanPhamPage = this.sanPhamRepo.findAll(pageable);
        List<SanPham> sanPhamList = sanPhamPage.getContent();
        int totalPage = sanPhamPage.getTotalPages();


        model.addAttribute("page", pageNo);
        model.addAttribute("totalPages", totalPage);
        model.addAttribute("danhSachXuatXu", this.xuatXuRepo.findAll());
        model.addAttribute("danhSachThuongHieu", this.thuongHieuRepo.findAll());
        model.addAttribute("danhSachSanPham", sanPhamList);
        model.addAttribute("xuatXuView", this.xuatXuView);
        model.addAttribute("data", this.sanPhamView);

        return "sanpham/sanPham";
    }

    @PostMapping("/store")
    public String saveXuatXu(@Valid @ModelAttribute SanPhamView sanPhamView, BindingResult result, Model model,
                             @RequestParam(name = "page", defaultValue = "0") Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 5);
        Page<SanPham> sanPhamPage = this.sanPhamRepo.findAll(pageable);
        List<SanPham> sanPhamList = sanPhamPage.getContent();
        int totalPage = sanPhamPage.getTotalPages();
        if (result.hasErrors()) {
            model.addAttribute("page", pageNo);
            model.addAttribute("totalPages", totalPage);
            model.addAttribute("danhSachXuatXu", this.xuatXuRepo.findAll());
            model.addAttribute("danhSachThuongHieu", this.thuongHieuRepo.findAll());
            model.addAttribute("danhSachSanPham", sanPhamList);
            model.addAttribute("xuatXuView", this.xuatXuView);
            model.addAttribute("data", this.sanPhamView);
            return "sanpham/sanPham";
        }
        SanPham sanPham = new SanPham();
        sanPham.loadFormViewModel(sanPhamView);
        this.sanPhamRepo.save(sanPham);
        return "redirect:/san-pham/hien-thi";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") SanPham sanPham) {
        this.sanPhamRepo.delete(sanPham);
        return "redirect:/san-pham/hien-thi";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") SanPham sanPham, Model model) {
        this.sanPhamView.loadFormModel(sanPham);
        model.addAttribute("danhSachXuatXu", this.xuatXuRepo.findAll());
        model.addAttribute("danhSachThuongHieu", this.thuongHieuRepo.findAll());
        model.addAttribute("data", this.sanPhamView);
        model.addAttribute("action", "/san-pham/update/" + sanPham.getId());
        return "sanpham/create";
    }

    @PostMapping("update/{id}")
    public String update(Model model, @PathVariable("id") SanPham oldValue,
                         @Valid @ModelAttribute("data") SanPhamView newValue, BindingResult result) {
        if (result.hasErrors()) {
            return "sanpham/create";
        }
        oldValue.loadFormViewModel(newValue);
        this.sanPhamRepo.save(oldValue);
        return "redirect:/san-pham/hien-thi";
    }

}
