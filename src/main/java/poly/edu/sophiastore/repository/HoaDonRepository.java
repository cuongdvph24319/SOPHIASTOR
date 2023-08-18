package poly.edu.sophiastore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import poly.edu.sophiastore.entity.HoaDon;

import java.util.UUID;

public interface HoaDonRepository extends JpaRepository<HoaDon, UUID> {
    @Query(value = "  Select COUNT(MaHoaDon) from HoaDon", nativeQuery = true)
    Integer soHD();
}
