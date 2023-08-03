package poly.edu.sophiastore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import poly.edu.sophiastore.entity.ChiTietNuocHoa;
import poly.edu.sophiastore.request.ChiTietNuocHoaView;

import java.util.List;
import java.util.UUID;

@Repository
public interface ChiTietNuocHoaRepository extends JpaRepository<ChiTietNuocHoa, UUID> {
    @Query("SELECT p FROM ChiTietNuocHoa p WHERE " +
            "(:thuongHieu IS NULL OR p.sanPham.thuongHieu.id = :thuongHieu) AND " +
            "(:xuatXu IS NULL OR p.sanPham.xuatXu.id = :xuatXu) AND " +
            "(:sanPham IS NULL OR p.sanPham.id = :sanPham) AND " +
            "(:nongDo IS NULL OR p.nongDo.id = :nongDo) AND " +
            "(:dungTich IS NULL OR p.dungTich.id = :dungTich) AND " +
            "(:doToaHuong IS NULL OR p.doToaHuong.id = :doToaHuong) AND " +
            "(:doLuuHuong IS NULL OR p.doLuuHuong.id = :doLuuHuong) AND " +
            "(:ketCau IS NULL OR p.ketCau.id = :ketCau)")
    List<ChiTietNuocHoa> filterProducts(@Param("thuongHieu") UUID thuongHieu,
                                            @Param("xuatXu") UUID xuatXu,
                                            @Param("sanPham") UUID sanPham,
                                            @Param("nongDo") UUID nongDo,
                                            @Param("dungTich") UUID dungTich,
                                            @Param("doToaHuong") UUID doToaHuong,
                                            @Param("doLuuHuong") UUID doLuuHuong,
                                            @Param("ketCau") UUID ketCau);
}
