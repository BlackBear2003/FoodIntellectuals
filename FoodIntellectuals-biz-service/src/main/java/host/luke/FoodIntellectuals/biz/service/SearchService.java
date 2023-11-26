package host.luke.FoodIntellectuals.biz.service;

import host.luke.FoodIntellectuals.biz.entity.Food;
import host.luke.FoodIntellectuals.biz.entity.Store;
import host.luke.FoodIntellectuals.common.dto.FoodDto;
import java.util.List;

public interface SearchService {

  List<Store> searchStoreByNameInGlobal(String storeName, int page, int size);

  List<Store> searchStoreByNameInCanteen(String storeName, long canteenId, int page, int size);

  List<FoodDto> searchFoodByNameInGlobal(String foodName, int page, int size);

  List<FoodDto> searchFoodByNameInStore(String foodName, long storeId, int page, int size);

  List<FoodDto> searchFoodByNameInCanteen(String foodName, long canteenId, int page, int size);

}