package poly.edu.sophiastore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import poly.edu.sophiastore.entity.GioHang;

import java.util.UUID;

public interface GioHangRepo extends JpaRepository<GioHang, UUID> {
}
