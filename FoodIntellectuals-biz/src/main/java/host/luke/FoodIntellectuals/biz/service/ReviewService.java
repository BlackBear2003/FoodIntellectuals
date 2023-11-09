package host.luke.FoodIntellectuals.biz.service;

import host.luke.FoodIntellectuals.common.entity.Review;
import java.util.List;

public interface ReviewService {

  /**
   * Returns all reviews based on the page number and size.
   *
   * @param page the page number to retrieve.
   * @param size the number of items per page.
   * @return a list of reviews.
   */
  List<Review> findAll(int page, int size);

  /**
   * Returns all reviews from a specific store based on the page number and size.
   *
   * @param storeId the ID of the store.
   * @param page    the page number to retrieve.
   * @param size    the number of items per page.
   * @return a list of reviews from the specified store.
   */

  List<Review> findByStoreId(long storeId, int page, int size);

  /**
   * Returns all reviews for a specific food item based on the page number and size.
   *
   * @param foodId the ID of the food.
   * @param page   the page number to retrieve.
   * @param size   the number of items per page.
   * @return a list of reviews for the specified food.
   */

  List<Review> findByFoodId(long foodId, int page, int size);

  /**
   * Returns all reviews by a specific user based on the page number and size.
   *
   * @param userId the ID of the user.
   * @param page   the page number to retrieve.
   * @param size   the number of items per page.
   * @return a list of reviews by the specified user.
   */

  List<Review> findByUserId(long userId, int page, int size);

  /**
   * Returns a specific review based on the reviewId.
   *
   * @param reviewId the ID of the review.
   * @return a review with the specified ID.
   */

  Review findByReviewId(long reviewId);

  /**
   * Returns the count of likes for a specific review.
   *
   * @param reviewId the ID of the review.
   * @return the count of likes for the review.
   */
  long countLikeByReviewId(long reviewId);

  /**
   * Returns the count of dislikes for a specific review.
   *
   * @param reviewId the ID of the review.
   * @return the count of dislikes for the review.
   */
  long countDislikeByReviewId(long reviewId);

  /**
   * Checks if a user liked a specific review.
   *
   * @param userId   the ID of the user.
   * @param reviewId the ID of the review.
   * @return true if the user liked the review, false otherwise.
   */
  boolean isUserLikedReview(long userId, long reviewId);

  /**
   * Checks if a user disliked a specific review.
   *
   * @param userId   the ID of the user.
   * @param reviewId the ID of the review.
   * @return true if the user disliked the review, false otherwise.
   */
  boolean isUserDislikedReview(long userId, long reviewId);

  /**
   * Adds a 'like' to a specific review from a user.
   *
   * @param reviewId the ID of the review.
   * @param userId   the ID of the user.
   */
  void doLike(long reviewId, long userId);

  /**
   * Adds a 'dislike' to a specific review from a user.
   *
   * @param reviewId the ID of the review.
   * @param userId   the ID of the user.
   */
  void doDislike(long reviewId, long userId);
}
