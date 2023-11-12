package host.luke.FoodIntellectuals.biz.service;

public interface ScoreService {

  double calculateStoreAttitudeScore(long storeId);

  double calculateStoreScore(long storeId);

  double calculateFoodScore(long foodId);

  double calculateFoodWaitTimeScore(long foodId);

  double calculateFoodFlavorScore(long foodId);

}
