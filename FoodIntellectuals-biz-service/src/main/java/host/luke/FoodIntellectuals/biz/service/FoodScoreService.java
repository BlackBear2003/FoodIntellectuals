package host.luke.FoodIntellectuals.biz.service;

import host.luke.FoodIntellectuals.biz.entity.FoodScore;

public interface FoodScoreService {

  FoodScore save(FoodScore foodScore);

  double calculateFoodScore(long foodId);

}
