package host.luke.FoodIntellectuals.biz.repository;

import host.luke.FoodIntellectuals.biz.entity.Food;
import host.luke.FoodIntellectuals.biz.entity.UserFoodCollect;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CollectRepository extends JpaRepository<UserFoodCollect, Long> {
  List<UserFoodCollect> findByUserIdAndTypeAndFoodId(Long userId, Integer type, Long foodId);
}
