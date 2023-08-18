package poly.edu.sophiastore.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import poly.edu.sophiastore.entity.DiaChi;
import poly.edu.sophiastore.service.DiaChiService;
import poly.edu.sophiastore.service.KhachHangService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/dia-chi")
public class DiaChiController {
    @Autowired
    DiaChiService diaChiService;
    @Autowired
    KhachHangService khachHangService;
    @GetMapping("/hien-thi")
    public String index(Model model, @RequestParam(value = "pageNo", defaultValue = "0") int pageNo) {

        Pageable pageable = PageRequest.of(pageNo, 10);

        Page page = diaChiService.findAll(pageable);;

        model.addAttribute("diaChi", page);
        model.addAttribute("tongNV", page.getTotalElements());
        model.addAttribute("pageNo", pageNo);
        return "khachHang/diaChi";
    }
    @GetMapping("/view")
    public String viewAdd(Model model){
        model.addAttribute("diaChi", new DiaChi());
        model.addAttribute("khachHang",khachHangService.findAll());
        return "KhachHang/viewDiaChi";
    }
    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("diaChi") DiaChi diaChi, BindingResult result, Model model){
        if(result.hasErrors()){
            return "KhachHang/viewDiaChi";
        }
        diaChiService.add(diaChi);
        return "redirect:/dia-chi/hien-thi";
    }

    @GetMapping("/edit/{id}")
    public String viewUpdate(@PathVariable("id") UUID id, Model model){
        model.addAttribute("diaChi",diaChiService.getbyID(id));
        model.addAttribute("khachHang",khachHangService.findAll());
        return "KhachHang/viewDiaChi";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") UUID id,Model model){
        model.addAttribute("diaChi",diaChiService.delete(id));
        return "redirect:/dia-chi/hien-thi";
    }
}
