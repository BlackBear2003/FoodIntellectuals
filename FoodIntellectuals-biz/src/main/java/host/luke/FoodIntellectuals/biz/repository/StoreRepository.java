package host.luke.FoodIntellectuals.biz.repository;

import host.luke.FoodIntellectuals.common.entity.Store;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {

  List<Store> findByCanteenId(long canteenId, Pageable pageable);

  List<Store> searchStoresByStoreNameContainingIgnoreCase(String storeName, Pageable pageable);

  List<Store> searchStoresByStoreNameContainingIgnoreCaseAndCanteenId(String storeName, long canteenId, Pageable pageable);

  List<Long> findIdsByCanteenId(Long canteenId);
}
