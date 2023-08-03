package poly.edu.sophiastore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import poly.edu.sophiastore.entity.Anh;
import poly.edu.sophiastore.entity.ChiTietNuocHoa;

import java.util.List;
import java.util.UUID;
@Repository
public interface AnhRepository extends JpaRepository<Anh, UUID> {
    List<Anh> findByChiTietNuocHoa(ChiTietNuocHoa chiTietNuocHoa);

}
