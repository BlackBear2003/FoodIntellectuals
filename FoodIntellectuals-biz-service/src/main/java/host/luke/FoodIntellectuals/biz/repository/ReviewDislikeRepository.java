package host.luke.FoodIntellectuals.biz.repository;

import host.luke.FoodIntellectuals.biz.entity.ReviewDislike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewDislikeRepository extends JpaRepository<ReviewDislike, Long> {

  long countByReviewId(long reviewId);

  boolean existsByUserIdAndReviewId(long userId, long reviewId);

}
