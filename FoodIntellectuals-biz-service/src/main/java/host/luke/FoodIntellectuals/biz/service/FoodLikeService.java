package host.luke.FoodIntellectuals.biz.service;


import host.luke.FoodIntellectuals.common.dto.FoodDto;
import java.util.List;

public interface FoodLikeService {

  void clickLike(long foodId, long userId);

  boolean isLiked(long foodId, long userId);

  int getLikeNumByFoodId(long foodId);

  List<FoodDto> getTop10RankByLikeNum();

}
