package poly.edu.sophiastore.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import poly.edu.sophiastore.entity.ChiTietNuocHoa;
import poly.edu.sophiastore.entity.HoaDonChiTiet;
import poly.edu.sophiastore.repository.HDCTRepository;

import java.util.List;
import java.util.UUID;

@Controller
public class HDCTController {
    @Autowired
    HDCTRepository hdctRepository;

    @Autowired
    HttpSession session;

    @RequestMapping("/hoa-don-chi-tiet/update-up/{id}")
    public String updateUp(@PathVariable("id") UUID idhdct) {
//        hoaDonChiTiet.setSoLuong(hoaDonChiTiet.getSoLuong() + 1);
//        System.out.println(hoaDonChiTiet.getSoLuong() + 1);
//        hdctRepository.save(hoaDonChiTiet);
        List<HoaDonChiTiet> hoaDonChiTietList = hdctRepository.findAll();
        for (HoaDonChiTiet hdct : hoaDonChiTietList
        ) {
            if (hdct.getId().getChiTietNuocHoa().getId().equals(idhdct)) {
                hdct.setSoLuong(hdct.getSoLuong() + 1);
                hdctRepository.save(hdct);
            }
        }
        UUID idhd = (UUID) session.getAttribute("idhd");
        return "redirect:/hoa-don/edit/" + idhd;
    }

    @RequestMapping("/hoa-don-chi-tiet/update-down/{id}")
    public String updateDown(@PathVariable("id") UUID idhdct) {
        List<HoaDonChiTiet> hoaDonChiTietList = hdctRepository.findAll();
        for (HoaDonChiTiet hdct : hoaDonChiTietList
        ) {
            if (hdct.getId().getChiTietNuocHoa().getId().equals(idhdct)) {
                hdct.setSoLuong(hdct.getSoLuong() - 1);
                hdctRepository.save(hdct);
            }
        }
        UUID idhd = (UUID) session.getAttribute("idhd");
        return "redirect:/hoa-don/edit/" + idhd;
    }

    @RequestMapping("/hoa-don-chi-tiet/delete/{id}")
    public String delete(
            @PathVariable("id") UUID idctsp
    ) {
        List<HoaDonChiTiet> hoaDonChiTietList = hdctRepository.findAll();
        for (HoaDonChiTiet hdct : hoaDonChiTietList
        ) {
            if (hdct.getId().getChiTietNuocHoa().getId().equals(idctsp)) {
                hdct.setSoLuong(hdct.getSoLuong() - 1);
                hdctRepository.delete(hdct);
            }
        }
        UUID idhd = (UUID) session.getAttribute("idhd");
        return "redirect:/hoa-don/edit/" + idhd;
    }
}
