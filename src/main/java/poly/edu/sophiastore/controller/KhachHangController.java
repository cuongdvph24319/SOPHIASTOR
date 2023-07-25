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
import poly.edu.sophiastore.entity.KhachHang;
import poly.edu.sophiastore.service.KhachHangService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Controller
@RequestMapping("/khach-hang")
public class KhachHangController {
    @Autowired
    KhachHangService khachHangService;
    @GetMapping("/hien-thi")
    public String hienThi(Model model){
        model.addAttribute("khach", new KhachHang());
        Pageable pageable =  PageRequest.of(0,5);
        Page<KhachHang> page = khachHangService.findAll(pageable);
        model.addAttribute("khachHang",khachHangService.findAll());
//        int totalPage = page.getTotalPages();
//        List<Integer> integerList = new ArrayList<>();
//        for (int i = 0; i < totalPage; i++) {
//            integerList.add(i);
//        }
//        model.addAttribute("pagination",integerList);
        return "KhachHang/khachHang";
    }
    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("khach") KhachHang khachHang, BindingResult result,Model model){
        if(result.hasErrors()){
            model.addAttribute("showModal", true);
            return "KhachHang/khachHang";
        }
        khachHangService.add(khachHang);
        return "redirect:/khach-hang/hien-thi";
    }

    @GetMapping("/edit/{id}")
    public String viewUpdate(@PathVariable("id") UUID id,Model model){
        model.addAttribute("khach",khachHangService.getbyID(id));
        return "KhachHang/ViewKhachHang";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") UUID id,Model model){
        model.addAttribute("khach",khachHangService.delete(id));
        return "redirect:/khach-hang/hien-thi";
    }
}
