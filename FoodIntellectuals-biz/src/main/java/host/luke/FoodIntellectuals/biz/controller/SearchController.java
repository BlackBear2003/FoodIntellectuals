package host.luke.FoodIntellectuals.biz.controller;

import host.luke.FoodIntellectuals.biz.service.SearchService;
import host.luke.FoodIntellectuals.common.dto.ResponseDto;
import host.luke.FoodIntellectuals.common.entity.Food;
import host.luke.FoodIntellectuals.common.entity.FoodTag;
import host.luke.FoodIntellectuals.common.entity.Store;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search")
public class SearchController {

  private final SearchService searchService;

  public SearchController(SearchService searchService) {
    this.searchService = searchService;
  }

  @GetMapping("/searchStoreByNameInGlobal")
  public ResponseDto<List<Store>> searchStoreByNameInGlobal(String storeName, int page, int size) {
    return new ResponseDto<>(200, null,
        searchService.searchStoreByNameInGlobal(storeName, page, size));
  }

  @GetMapping("/searchStoreByNameInCanteen")
  public ResponseDto<List<Store>> searchStoreByNameInCanteen(String storeName, long canteenId,
      int page, int size) {
    return new ResponseDto<>(200, null,
        searchService.searchStoreByNameInCanteen(storeName, canteenId, page, size));
  }

  @GetMapping("/searchFoodByNameInGlobal")
  public ResponseDto<List<Food>> searchFoodByNameInGlobal(String foodName, int page, int size) {
    return new ResponseDto<>(200, null,
        searchService.searchFoodByNameInGlobal(foodName, page, size));
  }

  @GetMapping("/searchFoodByNameInStore")
  public ResponseDto<List<Food>> searchFoodByNameInStore(String foodName, long storeId, int page,
      int size) {
    return new ResponseDto<>(200, null,
        searchService.searchFoodByNameInStore(foodName, storeId, page, size));
  }

  @GetMapping("/searchFoodByNameInCanteen")
  public ResponseDto<List<Food>> searchFoodByNameInCanteen(String foodName, long canteenId,
      int page, int size) {
    return new ResponseDto<>(200, null,
        searchService.searchFoodByNameInCanteen(foodName, canteenId, page, size));
  }

  @GetMapping("/searchFoodTagByTagName")
  public ResponseDto<List<FoodTag>> searchFoodTagByTagName(String tagName, int page, int size) {
    return new ResponseDto<>(200, null, searchService.searchFoodTagByTagName(tagName, page, size));
  }

}
