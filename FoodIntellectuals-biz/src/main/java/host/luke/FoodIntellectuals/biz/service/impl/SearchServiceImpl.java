package host.luke.FoodIntellectuals.biz.service.impl;

import host.luke.FoodIntellectuals.biz.repository.FoodRepository;
import host.luke.FoodIntellectuals.biz.repository.FoodTagRepository;
import host.luke.FoodIntellectuals.biz.repository.StoreRepository;
import host.luke.FoodIntellectuals.biz.service.SearchService;
import host.luke.FoodIntellectuals.common.entity.Food;
import host.luke.FoodIntellectuals.common.entity.FoodTag;
import host.luke.FoodIntellectuals.common.entity.Store;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SearchServiceImpl implements SearchService {

  private final StoreRepository storeRepository;
  private final FoodRepository foodRepository;
  private final FoodTagRepository foodTagRepository;

  public SearchServiceImpl(StoreRepository storeRepository, FoodRepository foodRepository,
      FoodTagRepository foodTagRepository) {
    this.storeRepository = storeRepository;
    this.foodRepository = foodRepository;
    this.foodTagRepository = foodTagRepository;
  }

  @Override
  public List<Store> searchStoreByNameInGlobal(String storeName, int page, int size) {
    Pageable pageable = PageRequest.of(page, size);
    return storeRepository.searchStoresByStoreNameContainingIgnoreCase(storeName, pageable);
  }

  @Override
  public List<Store> searchStoreByNameInCanteen(String storeName, long canteenId, int page,
      int size) {
    Pageable pageable = PageRequest.of(page, size);
    return storeRepository.searchStoresByStoreNameContainingIgnoreCaseAndCanteenId(storeName,
        canteenId, pageable);
  }

  @Override
  public List<Food> searchFoodByNameInGlobal(String foodName, int page, int size) {
    Pageable pageable = PageRequest.of(page, size);
    return foodRepository.searchFoodsByFoodNameContainingIgnoreCase(foodName, pageable);
  }

  @Override
  public List<Food> searchFoodByNameInStore(String foodName, long storeId, int page, int size) {
    Pageable pageable = PageRequest.of(page, size);
    return foodRepository.searchFoodsByFoodNameContainingIgnoreCaseAndStoreId(foodName, storeId,
        pageable);
  }

  @Override
  public List<Food> searchFoodByNameInCanteen(String foodName, long canteenId, int page, int size) {
    List<Long> storeIds = storeRepository.findIdsByCanteenId(canteenId);
    Pageable pageable = PageRequest.of(page, size);
    return foodRepository.searchFoodsByFoodNameContainingIgnoreCaseAndStoreIdIn(foodName, storeIds,
        pageable);
  }
}
