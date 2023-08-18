package poly.edu.sophiastore.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import poly.edu.sophiastore.entity.NhanVien;

import java.util.List;
import java.util.UUID;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, UUID> {
    Page<NhanVien> findByTrangThai(int tt, Pageable pageable);
    @Query(value = "select * from NhanVien  where (?1 is null or FREETEXT ((tenNhanVien,maNhanVien,diaChi),?1))" +
                   "and (?2 is null or trangthai =?2)"
                   ,nativeQuery = true)
    Page<NhanVien> searchAndFilter(String ten,String trangthai,Pageable pageable);

//    @Query(value = "SELECT * FROM NhanVien  WHERE FREETEXT(TenNhanVien,?1)",nativeQuery = true)
//    Page<NhanVien> fullTextSearch(String text,Pageable pageable);
//
//    @Query(value = "SELECT * FROM NhanVien  WHERE FREETEXT(TenNhanVien,?1) and TrangThai=?2",nativeQuery = true)
//    Page<NhanVien> fullTextSearchAndFilter(String text,int trangThai,Pageable pageable);

//Chia ra 2 hàm để áp dụng
}
