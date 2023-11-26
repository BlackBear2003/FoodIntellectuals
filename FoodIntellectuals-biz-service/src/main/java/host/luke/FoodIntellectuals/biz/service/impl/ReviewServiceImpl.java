package host.luke.FoodIntellectuals.biz.service.impl;

import host.luke.FoodIntellectuals.biz.entity.Review;
import host.luke.FoodIntellectuals.biz.entity.ReviewDislike;
import host.luke.FoodIntellectuals.biz.entity.ReviewLike;
import host.luke.FoodIntellectuals.biz.repository.ReviewDislikeRepository;
import host.luke.FoodIntellectuals.biz.repository.ReviewLikeRepository;
import host.luke.FoodIntellectuals.biz.repository.ReviewRepository;
import host.luke.FoodIntellectuals.biz.service.ImageService;
import host.luke.FoodIntellectuals.biz.service.ReviewService;
import host.luke.FoodIntellectuals.biz.util.DtoUtil;
import host.luke.FoodIntellectuals.common.dto.ReviewDto;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
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
  private final ImageService imageService;

  public ReviewServiceImpl(ReviewRepository reviewRepository,
      ReviewLikeRepository reviewLikeRepository, ReviewDislikeRepository reviewDislikeRepository,
      ImageService imageService) {
    this.reviewRepository = reviewRepository;
    this.reviewLikeRepository = reviewLikeRepository;
    this.reviewDislikeRepository = reviewDislikeRepository;
    this.imageService = imageService;
  }

  @Override
  public List<ReviewDto> findAll(int page, int size) {
    Pageable pageable = pageAndSortByTime(page, size);
    return reviewRepository.findAll(pageable).getContent().stream().map(
            review -> DtoUtil.reviewToReviewDto(review,
                imageService.findUrlListByBelongTypeAndId("Review", review.getId())))
        .collect(Collectors.toList());
  }

  @Override
  public ReviewDto findById(long id) {
    Review review = reviewRepository.findById(id).orElse(new Review());
    return DtoUtil.reviewToReviewDto(review, imageService.findUrlListByBelongTypeAndId("Review", review.getId()));
  }

  @Override
  public List<ReviewDto> findByStoreId(long storeId, int page, int size) {
    Pageable pageable = pageAndSortByTime(page, size);
    List<Review> reviewList = reviewRepository.findByStoreId(storeId, pageable);

    return reviewList.stream().map(review -> DtoUtil.reviewToReviewDto(review,
            imageService.findUrlListByBelongTypeAndId("Review", review.getId())))
        .collect(Collectors.toList());
  }

  @Override
  public ReviewDto create(Review review) {
    review.setReviewTime(new Date());
    Review save = reviewRepository.save(review);
    return DtoUtil.reviewToReviewDto(save,
        imageService.findUrlListByBelongTypeAndId("Review", review.getId()));
  }

  @Override
  public List<ReviewDto> findByFoodId(long foodId, int page, int size) {
    Pageable pageable = pageAndSortByTime(page, size);
    List<Review> reviewList = reviewRepository.findByFoodId(foodId, pageable);
    return reviewList.stream().map(review -> DtoUtil.reviewToReviewDto(review,
            imageService.findUrlListByBelongTypeAndId("Review", review.getId())))
        .collect(Collectors.toList());
  }

  @Override
  public List<ReviewDto> findByUserId(long userId, int page, int size) {
    Pageable pageable = pageAndSortByTime(page, size);
    List<Review> reviewList = reviewRepository.findByUserId(userId, pageable);
    return reviewList.stream().map(review -> DtoUtil.reviewToReviewDto(review,
            imageService.findUrlListByBelongTypeAndId("Review", review.getId())))
        .collect(Collectors.toList());
  }

  @Override
  public ReviewDto findByReviewId(long reviewId) {
    Review review = reviewRepository.findById(reviewId).orElse(new Review());
    return DtoUtil.reviewToReviewDto(review,
        imageService.findUrlListByBelongTypeAndId("Review", review.getId()));
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
