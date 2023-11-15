package host.luke.FoodIntellectuals.biz.controller;

import host.luke.FoodIntellectuals.biz.service.ReviewService;
import host.luke.FoodIntellectuals.common.dto.ResponseDto;
import host.luke.FoodIntellectuals.common.entity.Review;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/review")
public class ReviewController {

  private final ReviewService reviewService;

  public ReviewController(ReviewService reviewService) {
    this.reviewService = reviewService;
  }

  @GetMapping("/")
  public ResponseDto<List<Review>> findAll(int page, int size) {
    return new ResponseDto<>(200, null, reviewService.findAll(page, size));
  }

  @GetMapping("/storeId")
  public ResponseDto<List<Review>> findByStoreId(long storeId, int page, int size) {
    return new ResponseDto<>(200, null, reviewService.findByStoreId(storeId, page, size));
  }

  @GetMapping("/foodId")
  public ResponseDto<List<Review>> findByFoodId(long foodId, int page, int size) {
    return new ResponseDto<>(200, null, reviewService.findByFoodId(foodId, page, size));
  }

  @GetMapping("/userId")
  public ResponseDto<List<Review>> findByUserId(long userId, int page, int size) {
    return new ResponseDto<>(200, null, reviewService.findByUserId(userId, page, size));
  }

  @GetMapping("/reviewId")
  public ResponseDto<Review> findByReviewId(long reviewId) {
    return new ResponseDto<>(200, null, reviewService.findByReviewId(reviewId));
  }

  @GetMapping("/like")
  public ResponseDto<Long> countLikeByReviewId(long reviewId) {
    return new ResponseDto<>(200, null, reviewService.countLikeByReviewId(reviewId));
  }

  @GetMapping("/dislike")
  public ResponseDto<Long> countDislikeByReviewId(long reviewId) {
    return new ResponseDto<>(200, null, reviewService.countDislikeByReviewId(reviewId));
  }

  @GetMapping("/isUserLiked")
  public ResponseDto<Boolean> isUserLikedReview(long userId, long reviewId) {
    return new ResponseDto<>(200, null, reviewService.isUserLikedReview(userId, reviewId));
  }

  @GetMapping("/isUserDisliked")
  public ResponseDto<Boolean> isUserDislikedReview(long userId, long reviewId) {
    return new ResponseDto<>(200, null, reviewService.isUserDislikedReview(userId, reviewId));
  }

  @PostMapping("/like")
  public ResponseDto<Boolean> doLike(long reviewId, long userId) {
    reviewService.doLike(reviewId, userId);
    return new ResponseDto<>(200, null, null);
  }

  @PostMapping("/dislike")
  public ResponseDto<Boolean> doDislike(long reviewId, long userId) {
    reviewService.doDislike(reviewId, userId);
    return new ResponseDto<>(200, null, null);
  }
}
