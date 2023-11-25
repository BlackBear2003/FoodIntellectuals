package host.luke.FoodIntellectuals.biz.service.impl;

import host.luke.FoodIntellectuals.biz.repository.ReviewRepository;
import host.luke.FoodIntellectuals.biz.service.ScoreService;
import host.luke.FoodIntellectuals.redis.api.RedisQueryApi;
import org.springframework.stereotype.Service;

@Service
public class ScoreServiceImpl implements ScoreService {

  private final ReviewRepository reviewRepository;
  private final RedisQueryApi redisQueryApi;

  public ScoreServiceImpl(ReviewRepository reviewRepository, RedisQueryApi redisQueryApi) {
    this.reviewRepository = reviewRepository;
    this.redisQueryApi = redisQueryApi;
  }

  @Override
  public double calculateStoreAttitudeScore(long storeId) {
    return reviewRepository.calculateStoreAttitudeScore(storeId).get();
  }

  @Override
  public double calculateStoreScore(long storeId) {
    return reviewRepository.calculateStoreScore(storeId).get();
  }

  @Override
  public double calculateFoodScore(long foodId) {
    return reviewRepository.calculateFoodScore(foodId).get();
  }

  @Override
  public double calculateFoodWaitTimeScore(long foodId) {
    return reviewRepository.calculateFoodWaitTimeScore(foodId).get();
  }

  @Override
  public double calculateFoodFlavorScore(long foodId) {
    return reviewRepository.calculateFoodFlavorScore(foodId).get();
  }
}
