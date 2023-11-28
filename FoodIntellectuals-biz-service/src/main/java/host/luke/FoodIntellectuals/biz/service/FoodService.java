package host.luke.FoodIntellectuals.biz.service;

import host.luke.FoodIntellectuals.biz.entity.Food;
import host.luke.FoodIntellectuals.common.dto.FoodDto;
import java.util.List;

public interface FoodService {

  List<FoodDto> findAll(int page, int size);

  List<FoodDto> findByStoreId(long storeId, int page, int size);

  FoodDto findByFoodId(long foodId);

  void updateLikeNumByFoodId(long foodId, int likeNum);

}
