package host.luke.FoodIntellectuals.biz.repository;

import host.luke.FoodIntellectuals.common.entity.Food;
import java.util.Collection;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {

  List<Food> findByStoreId(long storeId, Pageable pageable);

  List<Food> searchFoodsByFoodNameContainingIgnoreCase(String foodName, Pageable pageable);

  List<Food> searchFoodsByFoodNameContainingIgnoreCaseAndStoreId(String foodName, long storeId, Pageable pageable);

  List<Food> searchFoodsByFoodNameContainingIgnoreCaseAndStoreIdIn(String foodName,
      Collection<Long> storeId, Pageable pageable);
}
