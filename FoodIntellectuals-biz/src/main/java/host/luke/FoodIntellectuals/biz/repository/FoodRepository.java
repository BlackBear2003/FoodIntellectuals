package host.luke.FoodIntellectuals.biz.repository;

import host.luke.FoodIntellectuals.common.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Long> {
    List<Food> findByStoreId(long storeId, Pageable pageable);
}
