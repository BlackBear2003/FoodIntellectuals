package host.luke.FoodIntellectuals.biz.service;

import host.luke.FoodIntellectuals.common.entity.Food;
import host.luke.FoodIntellectuals.common.entity.FoodTag;
import host.luke.FoodIntellectuals.common.entity.Store;
import java.util.List;

public interface SearchService {

  List<Store> searchStoreByNameInGlobal(String storeName, int page, int size);

  List<Store> searchStoreByNameInCanteen(String storeName, long canteenId, int page, int size);

  List<Food> searchFoodByNameInGlobal(String foodName, int page, int size);

  List<Food> searchFoodByNameInStore(String foodName, long storeId, int page, int size);

  List<Food> searchFoodByNameInCanteen(String foodName, long canteenId, int page, int size);

}