package poly.edu.sophiastore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import poly.edu.sophiastore.entity.SanPham;

import java.util.UUID;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, UUID> {
}
