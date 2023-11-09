package host.luke.FoodIntellectuals.biz.service.impl;

import host.luke.FoodIntellectuals.biz.repository.ReviewDislikeRepository;
import host.luke.FoodIntellectuals.biz.repository.ReviewLikeRepository;
import host.luke.FoodIntellectuals.biz.repository.ReviewRepository;
import host.luke.FoodIntellectuals.biz.service.ReviewService;
import host.luke.FoodIntellectuals.common.entity.Review;
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
    return null;
  }

  @Override
  public List<Review> findByStoreId(long foodId, int page, int size) {
    return null;
  }

  @Override
  public List<Review> findByFoodId(long foodId, int page, int size) {
    return null;
  }

  @Override
  public List<Review> findByUserId(long userId, int page, int size) {
    return null;
  }

  @Override
  public Review findByReviewId(long reviewId) {
    return null;
  }

  @Override
  public long countLikeByReviewId(long reviewId) {
    return 0;
  }

  @Override
  public long countDislikeByReviewId(long reviewId) {
    return 0;
  }

  Pageable pageSortByTime(int page, int size) {
    return PageRequest.of(page, size, Sort.by(new Order(Direction.DESC, "DataChangeCreatedTime")));
  }
}
