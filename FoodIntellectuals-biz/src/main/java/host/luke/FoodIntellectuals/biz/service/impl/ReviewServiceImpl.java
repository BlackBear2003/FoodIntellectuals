package host.luke.FoodIntellectuals.biz.service.impl;

import host.luke.FoodIntellectuals.biz.repository.ReviewDislikeRepository;
import host.luke.FoodIntellectuals.biz.repository.ReviewLikeRepository;
import host.luke.FoodIntellectuals.biz.repository.ReviewRepository;
import host.luke.FoodIntellectuals.biz.service.ReviewService;
import host.luke.FoodIntellectuals.common.entity.Review;
import host.luke.FoodIntellectuals.common.entity.ReviewDislike;
import host.luke.FoodIntellectuals.common.entity.ReviewLike;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {

  private final ReviewRepository reviewRepository;
  private final ReviewLikeRepository reviewLikeRepository;
  private final ReviewDislikeRepository reviewDislikeRepository;

  public ReviewServiceImpl(ReviewRepository reviewRepository,
      ReviewLikeRepository reviewLikeRepository, ReviewDislikeRepository reviewDislikeRepository) {
    this.reviewRepository = reviewRepository;
    this.reviewLikeRepository = reviewLikeRepository;
    this.reviewDislikeRepository = reviewDislikeRepository;
  }

  @Override
  public List<Review> findAll(int page, int size) {
    Pageable pageable = pageAndSortByTime(page, size);
    return reviewRepository.findAll(pageable).getContent();
  }

  @Override
  public List<Review> findByStoreId(long storeId, int page, int size) {
    Pageable pageable = pageAndSortByTime(page, size);
    return reviewRepository.findByStoreId(storeId, pageable);
  }

  @Override
  public List<Review> findByFoodId(long foodId, int page, int size) {
    Pageable pageable = pageAndSortByTime(page, size);
    return reviewRepository.findByFoodId(foodId, pageable);
  }

  @Override
  public List<Review> findByUserId(long userId, int page, int size) {
    Pageable pageable = pageAndSortByTime(page, size);
    return reviewRepository.findByUserId(userId, pageable);
  }

  @Override
  public Review findByReviewId(long reviewId) {
    return reviewRepository.getById(reviewId);
  }

  @Override
  public long countLikeByReviewId(long reviewId) {
    return reviewLikeRepository.countByReviewId(reviewId);
  }

  @Override
  public long countDislikeByReviewId(long reviewId) {
    return reviewDislikeRepository.countByReviewId(reviewId);
  }

  @Override
  public boolean isUserLikedReview(long userId, long reviewId) {
    return reviewLikeRepository.existsByUserIdAndReviewId(userId, reviewId);
  }

  @Override
  public boolean isUserDislikedReview(long userId, long reviewId) {
    return reviewDislikeRepository.existsByUserIdAndReviewId(userId, reviewId);
  }

  @Override
  public void doLike(long reviewId, long userId) {
    if (reviewLikeRepository.existsByUserIdAndReviewId(userId, reviewId)) {
      return;
    }
    ReviewLike reviewLike = new ReviewLike();
    reviewLike.setReviewId(reviewId);
    reviewLike.setUserId(userId);
    reviewLikeRepository.save(reviewLike);
  }

  @Override
  public void doDislike(long reviewId, long userId) {
    if (reviewDislikeRepository.existsByUserIdAndReviewId(userId, reviewId)) {
      return;
    }
    ReviewDislike reviewDislike = new ReviewDislike();
    reviewDislike.setReviewId(reviewId);
    reviewDislike.setUserId(userId);
    reviewDislikeRepository.save(reviewDislike);
  }

  Pageable pageAndSortByTime(int page, int size) {
    return PageRequest.of(page, size, Sort.by(new Order(Direction.DESC, "ReviewTime")));
  }
}
