package host.luke.FoodIntellectuals.biz.repository;

import host.luke.FoodIntellectuals.common.entity.Review;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReviewRepository extends JpaRepository<Review, Long> {

  List<Review> findByStoreId(long storeId, Pageable page);

  List<Review> findByFoodId(long storeId, Pageable page);

  List<Review> findByUserId(long userId, Pageable page);

  @Query("SELECT AVG(r.attitudeScore) FROM Review r WHERE r.storeId = :storeId")
  Optional<Double> calculateStoreAttitudeScore(@Param("storeId") Long storeId);

  @Query("SELECT AVG(r.storeScore) FROM Review r WHERE r.storeId = :storeId")
  Optional<Double> calculateStoreScore(@Param("storeId") Long storeId);

  @Query("SELECT AVG(r.foodScore) FROM Review r WHERE r.foodId = :foodId")
  Optional<Double> calculateFoodScore(@Param("foodId") Long foodId);

  @Query("SELECT AVG(r.waitTimeScore) FROM Review r WHERE r.foodId = :foodId")
  Optional<Double> calculateFoodWaitTimeScore(@Param("foodId") Long foodId);

  @Query("SELECT AVG(r.flavorScore) FROM Review r WHERE r.foodId = :foodId")
  Optional<Double> calculateFoodFlavorScore(@Param("foodId") Long foodId);

  List<Review> findReviewsByUserIdAndReviewTimeIsGreaterThanEqualAndReviewTimeLessThanEqual(
      Long userId, Date startTime, Date endTime);

}
