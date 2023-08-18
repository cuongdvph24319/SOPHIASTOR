package poly.edu.sophiastore.serviceIml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import poly.edu.sophiastore.entity.DiaChi;
import poly.edu.sophiastore.entity.KhachHang;
import poly.edu.sophiastore.repository.KhachHangRepo;
import poly.edu.sophiastore.service.DiaChiService;
import poly.edu.sophiastore.service.KhachHangService;

import java.util.List;
import java.util.UUID;

@Service
public class KhachHangServiceIml implements KhachHangService {
    @Autowired
    KhachHangRepo khachHangRepo;
    @Override
    public Page<KhachHang> findAll(Pageable pageable) {

        return khachHangRepo.findAll(pageable);
    }

    @Override
    public List<KhachHang> findAll() {
        return khachHangRepo.findAll();
    }

    @Override
    public boolean add(KhachHang KhachHang) {
        khachHangRepo.save(KhachHang);
        return true;
    }

    @Override
    public String delete(UUID id) {
        khachHangRepo.deleteById(id);
        return null;
    }

    @Override
    public boolean update(KhachHang KhachHang) {
        khachHangRepo.save(KhachHang);
        return false;
    }

    @Override
    public KhachHang getbyID(UUID id) {
        return khachHangRepo.getOne(id);
    }

    @Override
    public List<KhachHang> findByKeyword(String keyword) {
        return khachHangRepo.findByKeyWord(keyword);
    }

    @Override
    public List<KhachHang> findByTrangThai(String trangThai) {
        return khachHangRepo.findByTrangThai(trangThai);
    }
}
