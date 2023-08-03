package poly.edu.sophiastore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import poly.edu.sophiastore.entity.ThuongHieu;

import java.util.UUID;

@Repository
public interface ThuongHieuRepository extends JpaRepository<ThuongHieu, UUID> {
}
