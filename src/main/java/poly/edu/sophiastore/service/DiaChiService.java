package poly.edu.sophiastore.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import poly.edu.sophiastore.entity.DiaChi;
import poly.edu.sophiastore.entity.KhachHang;

import java.util.List;
import java.util.UUID;

@Service
public interface DiaChiService {
    Page<DiaChi> findAll(Pageable pageable);
    List<DiaChi> findAll();
    boolean add(DiaChi diaChi);
    String delete(UUID id);
    boolean update(DiaChi diaChi);
    DiaChi getbyID(UUID id);
}
