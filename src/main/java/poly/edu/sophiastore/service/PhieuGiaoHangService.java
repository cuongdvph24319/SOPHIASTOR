package poly.edu.sophiastore.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import poly.edu.sophiastore.entity.PhieuGiaoHang;

import java.util.List;
import java.util.UUID;

@Service
public interface PhieuGiaoHangService {
    Page<PhieuGiaoHang> findAll(Pageable pageable);
    List<PhieuGiaoHang> findAll();
    boolean add(PhieuGiaoHang diaChi);
    String delete(UUID id);
    boolean update(PhieuGiaoHang diaChi);
    PhieuGiaoHang getbyID(UUID id);

}
