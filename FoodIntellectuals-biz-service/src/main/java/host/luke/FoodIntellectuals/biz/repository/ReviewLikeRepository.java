package host.luke.FoodIntellectuals.biz.repository;

import host.luke.FoodIntellectuals.biz.entity.ReviewLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewLikeRepository extends JpaRepository<ReviewLike, Long> {

  long countByReviewId(long reviewId);

  boolean existsByUserIdAndReviewId(long userId, long reviewId);

}
