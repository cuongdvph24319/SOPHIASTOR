package poly.edu.sophiastore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import poly.edu.sophiastore.entity.DiaChi;

import java.util.UUID;

public interface DiaChiRepo extends JpaRepository<DiaChi, UUID> {
}
