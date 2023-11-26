package host.luke.FoodIntellectuals.biz.service.impl;

import host.luke.FoodIntellectuals.biz.entity.Image;
import host.luke.FoodIntellectuals.biz.repository.FoodRepository;
import host.luke.FoodIntellectuals.biz.repository.FoodTagRepository;
import host.luke.FoodIntellectuals.biz.repository.StoreRepository;
import host.luke.FoodIntellectuals.biz.service.ImageService;
import host.luke.FoodIntellectuals.biz.service.SearchService;
import host.luke.FoodIntellectuals.biz.entity.Food;
import host.luke.FoodIntellectuals.biz.entity.Store;
import host.luke.FoodIntellectuals.biz.util.DtoUtil;
import host.luke.FoodIntellectuals.common.dto.FoodDto;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SearchServiceImpl implements SearchService {

  private final StoreRepository storeRepository;
  private final FoodRepository foodRepository;
  private final FoodTagRepository foodTagRepository;
  private final ImageService imageService;

  public SearchServiceImpl(StoreRepository storeRepository, FoodRepository foodRepository,
      FoodTagRepository foodTagRepository, ImageService imageService) {
    this.storeRepository = storeRepository;
    this.foodRepository = foodRepository;
    this.foodTagRepository = foodTagRepository;
    this.imageService = imageService;
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
  public List<FoodDto> searchFoodByNameInGlobal(String foodName, int page, int size) {
    Pageable pageable = PageRequest.of(page, size);
    List<Food> foodList = foodRepository.searchFoodsByFoodNameContainingIgnoreCase(foodName, pageable);
    return foodList.stream().map(food -> DtoUtil.foodToFoodDto(food,
            imageService.findUrlListByBelongTypeAndId("Food", food.getId())))
        .collect(Collectors.toList());
  }

  @Override
  public List<FoodDto> searchFoodByNameInStore(String foodName, long storeId, int page, int size) {
    Pageable pageable = PageRequest.of(page, size);
    List<Food> foodList = foodRepository.searchFoodsByFoodNameContainingIgnoreCaseAndStoreId(foodName,
        storeId, pageable);
    return foodList.stream().map(food -> DtoUtil.foodToFoodDto(food,
            imageService.findUrlListByBelongTypeAndId("Food", food.getId())))
        .collect(Collectors.toList());
  }

  @Override
  public List<FoodDto> searchFoodByNameInCanteen(String foodName, long canteenId, int page, int size) {
    List<Long> storeIds = storeRepository.findIdsByCanteenId(canteenId);
    Pageable pageable = PageRequest.of(page, size);
    List<Food> foodList = foodRepository.searchFoodsByFoodNameContainingIgnoreCaseAndStoreIdIn(
        foodName, storeIds, pageable);
    return foodList.stream().map(food -> DtoUtil.foodToFoodDto(food,
            imageService.findUrlListByBelongTypeAndId("Food", food.getId())))
        .collect(Collectors.toList());
  }
}
