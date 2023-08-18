package poly.edu.sophiastore.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import poly.edu.sophiastore.entity.ChucVu;
import poly.edu.sophiastore.entity.NhanVien;

import java.util.UUID;

@Repository
public interface ChucVuRepository extends JpaRepository<ChucVu, UUID> {
}
