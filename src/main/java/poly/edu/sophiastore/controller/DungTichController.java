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
import poly.edu.sophiastore.entity.DungTich;
import poly.edu.sophiastore.entity.XuatXu;
import poly.edu.sophiastore.repository.DungTichRepository;
import poly.edu.sophiastore.request.DungTichView;
import poly.edu.sophiastore.request.XuatXuView;

import java.util.List;

@Controller
@RequestMapping("dung-tich")
public class DungTichController {
    @Autowired
    private DungTichView dungTichView;
    @Autowired
    private DungTichRepository dungTichRepository;

    @GetMapping("hien-thi")
    public String index(Model model, @RequestParam(name = "page", defaultValue = "0") Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 5);
        Page<DungTich> dungTichPage = this.dungTichRepository.findAll(pageable);
        List<DungTich> dungTichList = dungTichPage.getContent();
        int totalPage = dungTichPage.getTotalPages();

        model.addAttribute("page", pageNo);
        model.addAttribute("totalPages", totalPage);
        model.addAttribute("danhSachDungTich", dungTichList);
        model.addAttribute("data", this.dungTichView);
        return "dungtich/DungTich";
    }

    @PostMapping("store")
    public String store(@Valid @ModelAttribute("data") DungTichView dungTichView, Model model, BindingResult result
            , @RequestParam(name = "page", defaultValue = "0") Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 5);
        Page<DungTich> dungTichPage = this.dungTichRepository.findAll(pageable);
        List<DungTich> dungTichList = dungTichPage.getContent();
        int totalPage = dungTichPage.getTotalPages();
        DungTich dungTich = new DungTich();
        dungTich.loadFormViewModel(dungTichView);
        if (result.hasErrors()) {
            model.addAttribute("page", pageNo);
            model.addAttribute("totalPages", totalPage);
            model.addAttribute("danhSachDungTich", dungTichList);
            return "dungtich/DungTich";
        }

        this.dungTichRepository.save(dungTich);
        return "redirect:/dung-tich/hien-thi";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") DungTich dungTich) {
        this.dungTichRepository.delete(dungTich);
        return "redirect:/dung-tich/hien-thi";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") DungTich dungTich, Model model){
        this.dungTichView.loadFormModel(dungTich);
        model.addAttribute("action", "/dung-tich/update/" + dungTich.getId());
        model.addAttribute("data", this.dungTichView);

        return "dungtich/edit";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") DungTich oldvalue,
                         @Valid @ModelAttribute("data") DungTichView newValue, BindingResult result, Model model){
        if(result.hasErrors()){
            return "dungtich/edit";
        }
        oldvalue.loadFormViewModel(newValue);
        this.dungTichRepository.save(oldvalue);
        return "redirect:/dung-tich/hien-thi";
    }
}
