package poly.edu.sophiastore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import poly.edu.sophiastore.entity.KhachHang;

import java.util.List;
import java.util.UUID;

public interface KhachHangRepo  extends JpaRepository<KhachHang, UUID> {
    @Query(value = "select * from khachHang e where e.maKhachHang like %:keyword% or e.tenKhachHang " +
            "like %:keyword% or e.soDienThoai like %:keyword% or e.email like %:keyword%", nativeQuery = true)
    List<KhachHang> findByKeyWord(@Param("keyword") String keyword);
    @Query(value = "select * from khachHang e where e.trangThai like :trangThai",nativeQuery = true)
    List<KhachHang> findByTrangThai(@Param("trangThai") String trangThai);
}
