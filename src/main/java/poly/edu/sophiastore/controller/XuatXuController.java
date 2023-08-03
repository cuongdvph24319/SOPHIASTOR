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
import poly.edu.sophiastore.entity.XuatXu;
import poly.edu.sophiastore.repository.XuatXuRepository;
import poly.edu.sophiastore.request.XuatXuView;

import java.util.List;

@Controller
@RequestMapping("xuat-xu")
public class XuatXuController {
    @Autowired
    private XuatXuView xuatXuView;
    @Autowired
    private XuatXuRepository xuatXuRepository;

    @GetMapping("hien-thi")
    public String index(Model model, @RequestParam(name = "page", defaultValue = "0") Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 5);
        Page<XuatXu> xuatXuPage = this.xuatXuRepository.findAll(pageable);
        List<XuatXu> xuatXuList = xuatXuPage.getContent();
        int totalPage = xuatXuPage.getTotalPages();

        model.addAttribute("page", pageNo);
        model.addAttribute("totalPages", totalPage);
        model.addAttribute("danhSachXuatXu", xuatXuList);
        model.addAttribute("data", this.xuatXuView);
        return "xuatxu/XuatXu";
    }

    @PostMapping("store")
    public String store(@Valid @ModelAttribute("data") XuatXuView xuatXuView, Model model, BindingResult result
            , @RequestParam(name = "page", defaultValue = "0") Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 5);
        Page<XuatXu> xuatXuPage = this.xuatXuRepository.findAll(pageable);
        List<XuatXu> xuatXuList = xuatXuPage.getContent();
        int totalPage = xuatXuPage.getTotalPages();
        XuatXu xuatXu = new XuatXu();
        xuatXu.loadFormViewModel(xuatXuView);
        if (result.hasErrors()) {
            model.addAttribute("page", pageNo);
            model.addAttribute("totalPages", totalPage);
            model.addAttribute("danhSachXuatXu", xuatXuList);
            return "xuatxu/XuatXu";
        }

        this.xuatXuRepository.save(xuatXu);
        return "redirect:/xuat-xu/hien-thi";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") XuatXu xuatXu) {
        this.xuatXuRepository.delete(xuatXu);
        return "redirect:/xuat-xu/hien-thi";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") XuatXu xuatXu, Model model){
        this.xuatXuView.loadFormModel(xuatXu);
        model.addAttribute("action", "/thuong-hieu/update/" + xuatXu.getId());
        model.addAttribute("data", this.xuatXuView);

        return "xuatxu/edit";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") XuatXu oldvalue,
                         @Valid @ModelAttribute("data") XuatXuView newValue, BindingResult result, Model model){
        if(result.hasErrors()){
            return "xuatxu/edit";
        }
        oldvalue.loadFormViewModel(newValue);
        this.xuatXuRepository.save(oldvalue);
        return "redirect:/xuat-xu/hien-thi";
    }
}
