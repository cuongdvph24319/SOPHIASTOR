package poly.edu.sophiastore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import poly.edu.sophiastore.entity.HoaDonChiTiet;

import java.util.List;
import java.util.UUID;

public interface HDCTRepository extends JpaRepository<HoaDonChiTiet, Object> {
    @Query(value = "select hd from HoaDonChiTiet hd where hd.id.hoaDon.id = ?1")
    List<HoaDonChiTiet> findByIdHD(UUID idhd);
}
