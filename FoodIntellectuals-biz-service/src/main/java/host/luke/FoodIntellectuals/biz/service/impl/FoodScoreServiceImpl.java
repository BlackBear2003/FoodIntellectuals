package host.luke.FoodIntellectuals.biz.service.impl;

import host.luke.FoodIntellectuals.biz.entity.FoodScore;
import host.luke.FoodIntellectuals.biz.repository.FoodScoreRepository;
import host.luke.FoodIntellectuals.biz.service.FoodScoreService;
import org.springframework.stereotype.Service;

@Service
public class FoodScoreServiceImpl implements FoodScoreService {

  private final FoodScoreRepository foodScoreRepository;

  public FoodScoreServiceImpl(FoodScoreRepository foodScoreRepository) {
    this.foodScoreRepository = foodScoreRepository;
  }

  @Override
  public FoodScore save(FoodScore foodScore) {
    return foodScoreRepository.save(foodScore);
  }

  @Override
  public double calculateFoodScore(long foodId) {
    return foodScoreRepository.calculateFoodScore(foodId).orElse(0.0);
  }

}
