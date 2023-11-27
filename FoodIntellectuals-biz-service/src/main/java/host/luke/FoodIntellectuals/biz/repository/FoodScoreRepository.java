package host.luke.FoodIntellectuals.biz.repository;

import host.luke.FoodIntellectuals.biz.entity.FoodScore;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FoodScoreRepository extends JpaRepository<FoodScore, Long> {

  @Query("SELECT AVG(fs.foodScore) FROM FoodScore fs WHERE fs.foodId = :foodId")
  Optional<Double> calculateFoodScore(@Param("foodId") Long foodId);

}
