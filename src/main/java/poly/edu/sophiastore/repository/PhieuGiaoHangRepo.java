package poly.edu.sophiastore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import poly.edu.sophiastore.entity.PhieuGiaoHang;

import java.util.UUID;

public interface PhieuGiaoHangRepo extends JpaRepository<PhieuGiaoHang, UUID> {
}
