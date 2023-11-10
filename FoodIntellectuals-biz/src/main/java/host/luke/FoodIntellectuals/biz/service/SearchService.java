package host.luke.FoodIntellectuals.biz.service;

import host.luke.FoodIntellectuals.common.entity.Food;
import host.luke.FoodIntellectuals.common.entity.FoodTag;
import host.luke.FoodIntellectuals.common.entity.Store;
import java.util.List;

public interface SearchService {

  List<Store> searchStoreByNameInGlobal(String storeName);

  List<Store> searchStoreByNameInCanteen(String storeName, long canteenId);

  List<Food> searchFoodByNameInGlobal(String foodName);

  List<Food> searchFoodByNameInStore(String foodName, long storeId);

  List<Food> searchFoodByTagId(FoodTag tagId);
}