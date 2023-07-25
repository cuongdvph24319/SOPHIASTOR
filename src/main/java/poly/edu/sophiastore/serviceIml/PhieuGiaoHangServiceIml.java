package poly.edu.sophiastore.serviceIml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import poly.edu.sophiastore.repository.PhieuGiaoHangRepo;
import poly.edu.sophiastore.service.PhieuGiaoHangService;

import java.util.List;
import java.util.UUID;

@Service
public class PhieuGiaoHangServiceIml implements PhieuGiaoHangService {
    @Autowired
    PhieuGiaoHangRepo phieuGiaoHangRepo;
    @Override
    public Page<poly.edu.sophiastore.entity.PhieuGiaoHang> findAll(Pageable pageable) {
        return phieuGiaoHangRepo.findAll(pageable);
    }

    @Override
    public List<poly.edu.sophiastore.entity.PhieuGiaoHang> findAll() {
        return phieuGiaoHangRepo.findAll();
    }

    @Override
    public boolean add(poly.edu.sophiastore.entity.PhieuGiaoHang diaChi) {
        phieuGiaoHangRepo.save(diaChi);
        return true;
    }

    @Override
    public String delete(UUID id) {
        phieuGiaoHangRepo.deleteById(id);
        return null;
    }

    @Override
    public boolean update(poly.edu.sophiastore.entity.PhieuGiaoHang diaChi) {
        phieuGiaoHangRepo.save(diaChi);
        return true;
    }
    @Override
    public poly.edu.sophiastore.entity.PhieuGiaoHang getbyID(UUID id) {
        return phieuGiaoHangRepo.getOne(id);
    }
}
