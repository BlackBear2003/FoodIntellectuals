package host.luke.FoodIntellectuals.biz.repository;

import host.luke.FoodIntellectuals.biz.entity.Store;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StoreRepository extends JpaRepository<Store, Long> {

  List<Store> findByCanteenId(long canteenId, Pageable pageable);

  List<Store> searchStoresByStoreNameContainingIgnoreCase(String storeName, Pageable pageable);

  List<Store> searchStoresByStoreNameContainingIgnoreCaseAndCanteenId(String storeName, long canteenId, Pageable pageable);

  @Query("SELECT s.id FROM Store s WHERE s.canteenId = :canteenId")
  List<Long> findIdsByCanteenId(@Param("canteenId") Long canteenId);

}
