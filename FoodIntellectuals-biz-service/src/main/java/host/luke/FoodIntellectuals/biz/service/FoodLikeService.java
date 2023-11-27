package host.luke.FoodIntellectuals.biz.service;

public interface FoodLikeService {

  void clickLike(long foodId, long userId);

  long getLikeNumByFoodId(long foodId);

}
