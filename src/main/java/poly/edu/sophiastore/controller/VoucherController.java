package poly.edu.sophiastore.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import poly.edu.sophiastore.entity.Voucher;
import poly.edu.sophiastore.repository.VoucherRepository;
import poly.edu.sophiastore.request.VoucherView;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("voucher")
public class VoucherController {
    @Autowired
    private VoucherRepository voucherRepo;

    @Autowired
    private VoucherView voucherView;

    @GetMapping("hien-thi")
    public String hienThi(Model model, @RequestParam(name = "page", defaultValue = "0") Integer page) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<Voucher> voucherPage = this.voucherRepo.findAll(pageable);
        List<Voucher> voucherList = voucherPage.getContent();
        int totalPages = voucherPage.getTotalPages();

        model.addAttribute("danhSachVoucher", voucherList);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("data", voucherView);
        model.addAttribute("action", "/voucher/store");
        model.addAttribute("button", "create");
        return "voucher/voucher";
    }

//    @PostMapping("store")
//    public String store(Model model, @Valid @ModelAttribute("data") VoucherView voucherView, BindingResult result,
//                        @RequestParam(name = "page", defaultValue = "0") Integer page,
//                        @ModelAttribute("isNew") boolean isNew) {
//        Pageable pageable = PageRequest.of(page, 10);
//        Page<Voucher> voucherPage = this.voucherRepo.findAll(pageable);
//        List<Voucher> voucherList = voucherPage.getContent();
//        int totalPages = voucherPage.getTotalPages();
//
//        if (result.hasErrors()) {
//            model.addAttribute("danhSachVoucher", voucherList);
//            model.addAttribute("totalPages", totalPages);
//            return "voucher/voucher";
//        } else {
//            Voucher voucher;
//            if (isNew) {
//                voucher = new Voucher(); // Tạo instance mới cho hành động "create"
//            } else {
//                voucher = voucherRepo.findById(voucherView.getId()).orElse(null); // Tìm và cập nhật instance hiện có
//                if (voucher == null) {
//                    // Xử lý khi không tìm thấy voucher
//                    return "voucher/voucher";
//                }
//            }
//            voucher.loadFormViewModel(voucherView);
//            this.voucherRepo.save(voucher);
//        }
//        return "redirect:/voucher/hien-thi";
//    }


    @PostMapping("store")
    public String store(Model model, @Valid @ModelAttribute("data") VoucherView voucherView, BindingResult result,
                        @RequestParam(name = "page", defaultValue = "0") Integer page) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<Voucher> voucherPage = this.voucherRepo.findAll(pageable);
        List<Voucher> voucherList = voucherPage.getContent();
        int totalPages = voucherPage.getTotalPages();
        voucherView.checkMinMax();
        Voucher voucher = new Voucher();
        voucher.loadFormViewModel(voucherView);
        if(this.voucherRepo.existsByMaGiamGia(voucherView.getMaGiamGia())){
            voucherView.setDuplicate(true);
        }

        if (result.hasErrors()) {
            model.addAttribute("danhSachVoucher", voucherList);
            model.addAttribute("totalPages", totalPages);
            model.addAttribute("button", "create");
            return "voucher/voucher";
        }

        if (!voucherView.isValidDates()) {
            result.rejectValue("NgayKetThuc", "voucherView", "Ngày bắt đầu phải nhỏ hơn ngày kết thúc");
            model.addAttribute("danhSachVoucher", voucherList);
            model.addAttribute("totalPages", totalPages);
            model.addAttribute("button", "create");
            return "voucher/voucher";
        }

        this.voucherRepo.save(voucher);
        return "redirect:/voucher/hien-thi";
    }


    @PostMapping("stop")
    public String stopVoucher(@RequestParam(value = "selectedVouchers", required = false) List<UUID> select, RedirectAttributes attributes) {
        if (select == null || select.isEmpty()) {
            attributes.addFlashAttribute("errorMessage", "Không thành công!");
            return "redirect:/voucher/hien-thi";
        }
        for (UUID voucherId : select) {
            Voucher voucher = voucherRepo.findById(voucherId).orElse(null);
            if (voucher != null) {
                voucher.setTrangThai(2);
                this.voucherRepo.save(voucher);
            }
        }
        attributes.addFlashAttribute("successMessage", "Thành công!");
        return "redirect:/voucher/hien-thi";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") Voucher oldValue,
                         @Valid @ModelAttribute("data") VoucherView newValue,

                         BindingResult result, @RequestParam(name = "page", defaultValue = "0") Integer page, Model model
    ) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<Voucher> voucherPage = this.voucherRepo.findAll(pageable);
        List<Voucher> voucherList = voucherPage.getContent();
        int totalPages = voucherPage.getTotalPages();
        if (result.hasErrors()) {
            model.addAttribute("danhSachVoucher", voucherList);
            model.addAttribute("totalPages", totalPages);
            model.addAttribute("button", "update");
            return "voucher/voucher";
        }else if(!newValue.isValidDates()){
            result.rejectValue("ngayKetThuc", "Ngày kết thúc phải lớn hơn ngày bắt đầu");
            model.addAttribute("danhSachVoucher", voucherList);
            model.addAttribute("totalPages", totalPages);
            model.addAttribute("button", "update");
            return "voucher/voucher";
        }
        oldValue.loadFormViewModel(newValue);
        this.voucherRepo.save(oldValue);
        return "redirect:/voucher/hien-thi";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") Voucher voucher, Model model,
                       @RequestParam(name = "page", defaultValue = "0") Integer page
    ) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<Voucher> voucherPage = this.voucherRepo.findAll(pageable);
        List<Voucher> voucherList = voucherPage.getContent();
        int totalPages = voucherPage.getTotalPages();

        model.addAttribute("danhSachVoucher", voucherList);
        model.addAttribute("totalPages", totalPages);
        voucherView.loadFormModel(voucher);
        model.addAttribute("data", voucherView);
        model.addAttribute("action", "/voucher/update/" + voucher.getId());
        model.addAttribute("button", "update");

        return "voucher/voucher";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Voucher voucher){
        this.voucherRepo.delete(voucher);
        return "redirect:/voucher/hien-thi";
    }

}
