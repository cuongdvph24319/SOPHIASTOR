package poly.edu.sophiastore.controller;

import jakarta.servlet.ServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import poly.edu.sophiastore.entity.ChucVu;
import poly.edu.sophiastore.entity.NhanVien;
import poly.edu.sophiastore.repository.ChucVuRepository;
import poly.edu.sophiastore.repository.NhanVienRepository;
import poly.edu.sophiastore.request.NhanVien_View;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/admin/nhanvien")
public class NhanVienController {

    @Autowired
    private NhanVienRepository nhanVienRepository;

    @Autowired
    private NhanVien nv_entity;

    @Autowired
    private ChucVuRepository chucVuRepository;

    @Autowired
    private NhanVien_View nv_view;

    @Autowired
    private ServletRequest request;

    private static String trangThais;
    private static String textSearchs;

    @GetMapping("/hienthi")
    public String index(Model model, @RequestParam(value = "pageNo", defaultValue = "0") int pageNo) {
        List<NhanVien> listNv = new ArrayList<>();
        Pageable pageable = PageRequest.of(pageNo, 5);
        Page page = locVaTimKiem(pageable,model);
        model.addAttribute("listNV", page);
        model.addAttribute("tongNV", page.getTotalElements());
        model.addAttribute("pageNo", pageNo);
        return "nhanVien/index";
    }


    public Page locVaTimKiem(Pageable pageable, Model model) {
        String trangThaiRq = request.getParameter("trangThai");
        String trangThai = trangThaiRq == null || (trangThaiRq.equals("0")==false && trangThaiRq.equals("1")==false) ? "-1" : trangThaiRq;
        String textSearch = request.getParameter("textSearch");
        model.addAttribute("trangThai",trangThai);
        model.addAttribute("textSearch",textSearch);


        Page page = null;
//        phải phân biệt có search hay không
        if (textSearch == null || textSearch.trim().equals("")) {
            if (trangThai.equals("-1")){
                return nhanVienRepository.findAll(pageable);
            }
            NhanVien example = NhanVien
                    .builder()
                    .trangThai(Integer.parseInt(trangThai))
                    .build();
            page = nhanVienRepository.findAll(Example.of(example), pageable);
        } else {
            if (trangThai.equals("-1")){
                System.out.println(1);
                return nhanVienRepository.searchAndFilter(textSearch,null, pageable);
            }
            page = nhanVienRepository.searchAndFilter(textSearch,trangThai, pageable);
        }

        return page;
    }

//    public Page locVaTimKiem(Pageable pageable, Model model) {
//        String trangThai = request.getParameter("trangThai");
//        String textSearch = request.getParameter("textSearch");
//        System.out.println(trangThai + ", " + textSearch);
//        Page page = null;
//        if ((textSearch == null && trangThai == null) || (trangThai.equals("0") == false && trangThai.equals("1") == false)) {
//            System.out.println(1);
//            page = nhanVienRepository.findAll(pageable);
//        } else if ((trangThai != null && textSearch == null) || textSearch.equals("")) {
//            model.addAttribute("trangThai", trangThai);
//            Integer tt = Integer.parseInt(trangThai);
//            page = nhanVienRepository.findByTrangThai(tt, pageable);
//            System.out.println(2);
//        } else if ((trangThai == null && textSearch != null) || trangThai.equals("")) {
//            model.addAttribute("textSearch", textSearch);
//            page = nhanVienRepository.fullTextSearch(textSearch, pageable);
//            System.out.println(3);
//        } else {
//            Integer tt = Integer.parseInt(trangThai);
//            page = nhanVienRepository.fullTextSearchAndFilter(textSearch, tt, pageable);
//            System.out.println(page.getTotalPages());
//            System.out.println(4);
//        }
//        return page;
//    }


    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("nhanvien", new NhanVien_View());
        model.addAttribute("listCV", chucVuRepository.findAll());
        return "nhanvien/create";
    }


    @PostMapping("/store")
    public String create(@Valid @ModelAttribute(value = "nhanvien") NhanVien_View nv_v,
                         BindingResult result, Model model, RedirectAttributes atts) {
        System.out.println(nv_v.getNgaySinh());
        if (result.hasErrors()) {
            model.addAttribute("listCV", chucVuRepository.findAll());
            return "nhanVien/create";
        }
        BeanUtils.copyProperties(nv_v, nv_entity);
        nv_entity.setId(null);
        nhanVienRepository.save(nv_entity);
        return "redirect:/admin/nhanvien/hienthi";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") UUID id) {
        nv_entity = nhanVienRepository.findById(id).orElse(null);
        BeanUtils.copyProperties(nv_entity, nv_view);
        model.addAttribute("nhanvien", nv_view);
        model.addAttribute("listCV", chucVuRepository.findAll());
        return "nhanVien/edit";
    }

    @PostMapping("/update")
    public String update(Model model, @Valid @ModelAttribute("nhanvien") NhanVien_View nv_view,
                         BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("listCV", chucVuRepository.findAll());
            return "nhanvien/edit";
        }

        nv_view.setId(nv_entity.getId());
        BeanUtils.copyProperties(nv_view, nv_entity);
        nhanVienRepository.save(nv_entity);
        return "redirect:/admin/nhanvien/hienthi";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") UUID id) {
        nhanVienRepository.deleteById(id);
        return "redirect:/admin/nhanvien/hienthi";

    }
}
