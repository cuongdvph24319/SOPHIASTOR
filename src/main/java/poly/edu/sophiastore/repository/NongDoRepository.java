package poly.edu.sophiastore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import poly.edu.sophiastore.entity.NongDo;

import java.util.UUID;

@Repository
public interface NongDoRepository extends JpaRepository<NongDo, UUID> {
}
