package poly.edu.sophiastore.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import poly.edu.sophiastore.entity.HoaDon;
import poly.edu.sophiastore.repository.HDCTRepository;
import poly.edu.sophiastore.repository.HoaDonRepository;

import java.sql.Date;
import java.time.LocalTime;
import java.util.Collections;
import java.util.UUID;

@CrossOrigin("*")
@Controller
public class HoaDonController {
    @Autowired
    HoaDonRepository hoaDonRepository;

    @Autowired
    HDCTRepository hdctRepository;

    @Autowired
    HttpSession session;

    @GetMapping("/ban-hang")
    public String getAll(Model model
            , @RequestParam(value = "pageNo", defaultValue = "0") int pageNo
    ) {
        Pageable pageable = PageRequest.of(pageNo, 5);
        Page page  = hoaDonRepository.findAll(pageable);
        model.addAttribute("listhd", page);
        model.addAttribute("pageNo", pageNo);
        return "banhang/hoadon";

    }

    @GetMapping("/hoa-don/delete/{id}")
    public String delete(@PathVariable("id") HoaDon hoaDon) {
        hoaDonRepository.delete(hoaDon);
        return "redirect:/ban-hang";
    }

    @GetMapping("/hoa-don/edit/{id}")
    public String edit(@PathVariable("id") HoaDon hoaDon, Model model) {
        model.addAttribute("listdhct", hdctRepository.findByIdHD(hoaDon.getId()));
        session.setAttribute("idhd", hoaDon.getId());
        return "banhang/createhd";
    }

    @RequestMapping("/hoa-don/createhd")
    public String create() {
        System.out.println("a");
        HoaDon hoaDon = new HoaDon();
        int sodh = hoaDonRepository.soHD() + 1;
        hoaDon.setMaHoaDon("HD" + sodh);
        hoaDon.setTongTien(0.0);
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        System.out.println(date);
        hoaDon.setNgayTao(date);
        hoaDon.setTrangThai(2);
        hoaDonRepository.save(hoaDon);
        return "banhang/createhd";
    }

}
