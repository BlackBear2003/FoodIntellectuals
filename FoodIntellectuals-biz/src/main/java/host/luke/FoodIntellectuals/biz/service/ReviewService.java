package host.luke.FoodIntellectuals.biz.service;

import host.luke.FoodIntellectuals.common.entity.Review;
import java.util.List;

public interface ReviewService {

  List<Review> findAll(int page, int size);

  List<Review> findByStoreId(long foodId, int page, int size);

  List<Review> findByFoodId(long foodId, int page, int size);

  List<Review> findByUserId(long userId, int page, int size);

  Review findByReviewId(long reviewId);
}
