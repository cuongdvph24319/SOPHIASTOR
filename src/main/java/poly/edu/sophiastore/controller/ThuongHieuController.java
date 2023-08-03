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
import poly.edu.sophiastore.entity.ThuongHieu;
import poly.edu.sophiastore.repository.ThuongHieuRepository;
import poly.edu.sophiastore.request.ThuongHieuView;
import poly.edu.sophiastore.request.XuatXuView;

import java.util.List;

@Controller
@RequestMapping("thuong-hieu")
public class ThuongHieuController {
    @Autowired
    private ThuongHieuView thuongHieuView;
    @Autowired
    private ThuongHieuRepository thuongHieuRepo;

    @GetMapping("hien-thi")
    public String index(Model model, @RequestParam(name = "page", defaultValue = "0") Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 5);
        Page<ThuongHieu> thuongHieuPage = this.thuongHieuRepo.findAll(pageable);
        List<ThuongHieu> thuongHieuList = thuongHieuPage.getContent();
        int totalPage = thuongHieuPage.getTotalPages();

        model.addAttribute("page", pageNo);
        model.addAttribute("totalPages", totalPage);
        model.addAttribute("danhSachThuongHieu", thuongHieuList);
        model.addAttribute("data", this.thuongHieuView);
        return "thuonghieu/ThuongHieu";
    }

    @PostMapping("store")
    public String store(@Valid @ModelAttribute("data") ThuongHieuView thuongHieuView, Model model, BindingResult result
            , @RequestParam(name = "page", defaultValue = "0") Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 5);
        Page<ThuongHieu> thuongHieuPage = this.thuongHieuRepo.findAll(pageable);
        List<ThuongHieu> thuongHieuList = thuongHieuPage.getContent();
        int totalPage = thuongHieuPage.getTotalPages();
        ThuongHieu thuongHieu = new ThuongHieu();
        thuongHieu.loadFormViewModel(thuongHieuView);
        if (result.hasErrors()) {
            model.addAttribute("page", pageNo);
            model.addAttribute("totalPages", totalPage);
            model.addAttribute("danhSachThuongHieu", thuongHieuList);
            return "/thuonghieu/ThuongHieu";
        }

        this.thuongHieuRepo.save(thuongHieu);
        return "redirect:/thuong-hieu/hien-thi";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") ThuongHieu thuongHieu) {
        this.thuongHieuRepo.delete(thuongHieu);
        return "redirect:/thuong-hieu/hien-thi";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") ThuongHieu thuongHieu, Model model){
        this.thuongHieuView.loadFormModel(thuongHieu);
        model.addAttribute("action", "/thuong-hieu/update/" + thuongHieu.getId());
        model.addAttribute("data", this.thuongHieuView);

        return "thuonghieu/edit";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") ThuongHieu oldvalue,
                         @Valid @ModelAttribute("data") ThuongHieuView newValue, BindingResult result, Model model){
        if(result.hasErrors()){
            return "thuonghieu/edit";
        }
        oldvalue.loadFormViewModel(newValue);
        this.thuongHieuRepo.save(oldvalue);
        return "redirect:/thuong-hieu/hien-thi";
    }

}
