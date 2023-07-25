package poly.edu.sophiastore.serviceIml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import poly.edu.sophiastore.entity.DiaChi;
import poly.edu.sophiastore.repository.DiaChiRepo;
import poly.edu.sophiastore.service.DiaChiService;

import java.util.List;
import java.util.UUID;

@Service
public class DiaChiServiceIml implements DiaChiService {
    @Autowired
    DiaChiRepo diaChiRepo;
    @Override
    public Page<DiaChi> findAll(Pageable pageable) {
        return diaChiRepo.findAll(pageable);
    }

    @Override
    public List<DiaChi> findAll() {
        return diaChiRepo.findAll();
    }

    @Override
    public boolean add(DiaChi diaChi) {
        diaChiRepo.save(diaChi);
        return true;
    }

    @Override
    public String delete(UUID id) {
        diaChiRepo.deleteById(id);
        return null;
    }

    @Override
    public boolean update(DiaChi diaChi) {
        diaChiRepo.save(diaChi);
        return true;
    }

    @Override
    public DiaChi getbyID(UUID id) {
        return diaChiRepo.getOne(id);
    }
}
