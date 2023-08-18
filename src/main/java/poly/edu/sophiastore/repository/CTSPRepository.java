package poly.edu.sophiastore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import poly.edu.sophiastore.entity.ChiTietNuocHoa;

import java.util.UUID;

public interface CTSPRepository extends JpaRepository<ChiTietNuocHoa, UUID> {
}
