package host.luke.FoodIntellectuals.biz.service;

import host.luke.FoodIntellectuals.common.entity.Food;
import java.util.List;

public interface FoodService {

  List<Food> findAll(int page, int size);

  List<Food> findByStoreId(long storeId, int page, int size);

  Food findByFoodId(long foodId);

  List<Food> searchFoodByTagId(long tagId, int page, int size);

}
