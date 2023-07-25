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
import poly.edu.sophiastore.entity.DiaChi;
import poly.edu.sophiastore.entity.PhieuGiaoHang;
import poly.edu.sophiastore.repository.HoaDonRepo;
import poly.edu.sophiastore.service.DiaChiService;
import poly.edu.sophiastore.service.KhachHangService;
import poly.edu.sophiastore.service.PhieuGiaoHangService;

import java.util.UUID;

@Controller
@RequestMapping("/phieu-giao-hang")
public class PhieuGiaoHangController {
    @Autowired
    DiaChiService diaChiService;
    @Autowired
    KhachHangService khachHangService;
    @Autowired
    PhieuGiaoHangService phieuGiaoHangService;
    @Autowired
    HoaDonRepo hoaDonRepo;
    @GetMapping("/hien-thi")
    public String index(Model model, @RequestParam(value = "pageNo", defaultValue = "0") int pageNo) {

        Pageable pageable = PageRequest.of(pageNo, 5);

        Page page = phieuGiaoHangService.findAll(pageable);;

        model.addAttribute("phieuGiaoHang", page);
        model.addAttribute("tongNV", page.getTotalElements());
        model.addAttribute("pageNo", pageNo);
        return "phieuGiaoHang/phieuGiaoHang";
    }
    @GetMapping("/view")
    public String viewAdd(Model model){
        model.addAttribute("phieuGiaoHang", new PhieuGiaoHang());
        model.addAttribute("hoaDon",hoaDonRepo.findAll());
        model.addAttribute("diaChi",diaChiService.findAll());
        return "phieuGiaoHang/viewPhieuGiaoHang";
    }
    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("phieuGiaoHang") PhieuGiaoHang phieuGiaoHang, BindingResult result, Model model){
        phieuGiaoHangService.add(phieuGiaoHang);
        return "redirect:/phieu-giao-hang/hien-thi";
    }

    @GetMapping("/edit/{id}")
    public String viewUpdate(@PathVariable("id") UUID id, Model model){
        model.addAttribute("phieuGiaoHang",phieuGiaoHangService.getbyID(id));
        model.addAttribute("hoaDon",hoaDonRepo.findAll());
        model.addAttribute("diaChi",diaChiService.findAll());
        return "phieuGiaoHang/viewPhieuGiaoHang";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") UUID id,Model model){
        model.addAttribute("phieuGiaoHang",phieuGiaoHangService.delete(id));
        return "redirect:/phieu-giao-hang/hien-thi";
    }
}
