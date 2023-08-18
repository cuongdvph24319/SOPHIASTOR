package poly.edu.sophiastore.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import poly.edu.sophiastore.entity.KhachHang;

import java.util.List;
import java.util.UUID;

@Service
public interface KhachHangService {
    Page<KhachHang> findAll(Pageable pageable);
    List<KhachHang> findAll();
    boolean add(KhachHang diaChi);
    String delete(UUID id);
    boolean update(KhachHang diaChi);
    KhachHang getbyID(UUID id);
    List<KhachHang> findByKeyword(String keyword);
    List<KhachHang> findByTrangThai(String trangThai);
}
