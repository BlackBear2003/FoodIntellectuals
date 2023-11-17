package host.luke.FoodIntellectuals.biz.controller;

import host.luke.FoodIntellectuals.biz.service.ReviewService;
import host.luke.FoodIntellectuals.common.dto.ResponseDto;
import host.luke.FoodIntellectuals.common.entity.Review;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
@Api(tags = "评论相关接口", description = "提供评论相关操作的接口")
public class ReviewController {

  private final ReviewService reviewService;

  public ReviewController(ReviewService reviewService) {
    this.reviewService = reviewService;
  }

  @GetMapping("/")
  @ApiOperation(value = "获取所有评论", notes = "分页获取所有评论信息")
  public ResponseDto<List<Review>> findAll(@RequestParam int page, @RequestParam int size) {
    return new ResponseDto<>(200, null, reviewService.findAll(page, size));
  }

  @GetMapping("/storeId")
  @ApiOperation(value = "根据店铺ID获取评论列表", notes = "分页获取指定店铺的评论列表")
  public ResponseDto<List<Review>> findByStoreId(@RequestParam long storeId,
      @RequestParam int page,
      @RequestParam int size) {
    return new ResponseDto<>(200, null, reviewService.findByStoreId(storeId, page, size));
  }

  @GetMapping("/foodId")
  @ApiOperation(value = "根据食品ID获取评论列表", notes = "分页获取指定食品的评论列表")
  public ResponseDto<List<Review>> findByFoodId(@RequestParam long foodId,
      @RequestParam int page,
      @RequestParam int size) {
    return new ResponseDto<>(200, null, reviewService.findByFoodId(foodId, page, size));
  }

  @GetMapping("/userId")
  @ApiOperation(value = "根据用户ID获取评论列表", notes = "分页获取指定用户的评论列表")
  public ResponseDto<List<Review>> findByUserId(@RequestParam long userId,
      @RequestParam int page,
      @RequestParam int size) {
    return new ResponseDto<>(200, null, reviewService.findByUserId(userId, page, size));
  }

  @GetMapping("/reviewId")
  @ApiOperation(value = "根据评论ID获取评论信息", notes = "根据评论ID获取指定评论的详细信息")
  public ResponseDto<Review> findByReviewId(@RequestParam long reviewId) {
    return new ResponseDto<>(200, null, reviewService.findByReviewId(reviewId));
  }

  @GetMapping("/like")
  @ApiOperation(value = "根据评论ID统计点赞数量", notes = "根据评论ID统计点赞的数量")
  public ResponseDto<Long> countLikeByReviewId(@RequestParam long reviewId) {
    return new ResponseDto<>(200, null, reviewService.countLikeByReviewId(reviewId));
  }

  @GetMapping("/dislike")
  @ApiOperation(value = "根据评论ID统计踩数量", notes = "根据评论ID统计踩的数量")
  public ResponseDto<Long> countDislikeByReviewId(@RequestParam long reviewId) {
    return new ResponseDto<>(200, null, reviewService.countDislikeByReviewId(reviewId));
  }

  @GetMapping("/isUserLiked")
  @ApiOperation(value = "判断用户是否点赞了评论", notes = "判断用户是否点赞了指定评论")
  public ResponseDto<Boolean> isUserLikedReview(@RequestParam long userId,
      @RequestParam long reviewId) {
    return new ResponseDto<>(200, null, reviewService.isUserLikedReview(userId, reviewId));
  }

  @GetMapping("/isUserDisliked")
  @ApiOperation(value = "判断用户是否踩了评论", notes = "判断用户是否踩了指定评论")
  public ResponseDto<Boolean> isUserDislikedReview(@RequestParam long userId,
      @RequestParam long reviewId) {
    return new ResponseDto<>(200, null, reviewService.isUserDislikedReview(userId, reviewId));
  }

  @PostMapping("/like")
  @ApiOperation(value = "用户点赞评论", notes = "用户点赞指定评论")
  public ResponseDto<Boolean> doLike(@RequestParam long reviewId,
      @RequestParam long userId) {
    reviewService.doLike(reviewId, userId);
    return new ResponseDto<>(200, null, null);
  }

  @PostMapping("/dislike")
  @ApiOperation(value = "用户踩评论", notes = "用户踩指定评论")
  public ResponseDto<Boolean> doDislike(@RequestParam long reviewId,
      @RequestParam long userId) {
    reviewService.doDislike(reviewId, userId);
    return new ResponseDto<>(200, null, null);
  }
}
