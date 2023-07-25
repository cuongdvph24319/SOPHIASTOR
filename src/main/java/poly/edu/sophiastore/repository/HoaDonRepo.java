package poly.edu.sophiastore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import poly.edu.sophiastore.entity.HoaDon;

import java.util.UUID;

public interface HoaDonRepo extends JpaRepository<HoaDon, UUID> {
}
