package poly.edu.sophiastore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import poly.edu.sophiastore.entity.KhachHang;

import java.util.UUID;

public interface KhachHangRepo  extends JpaRepository<KhachHang, UUID> {
}
