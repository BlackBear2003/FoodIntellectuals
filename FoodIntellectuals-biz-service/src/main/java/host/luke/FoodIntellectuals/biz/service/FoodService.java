package host.luke.FoodIntellectuals.biz.service;

import host.luke.FoodIntellectuals.biz.entity.Food;
import java.util.List;

public interface FoodService {

  List<Food> findAll(int page, int size);

  List<Food> findByStoreId(long storeId, int page, int size);

  Food findByFoodId(long foodId);

}
