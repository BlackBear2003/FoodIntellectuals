package host.luke.FoodIntellectuals.biz.controller;

import host.luke.FoodIntellectuals.biz.service.SearchService;
import host.luke.FoodIntellectuals.common.dto.ResponseDTO;
import host.luke.FoodIntellectuals.common.entity.Food;
import host.luke.FoodIntellectuals.common.entity.Store;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
@Api(tags = "搜索相关接口", description = "提供搜索相关操作的接口")
public class SearchController {

  private final SearchService searchService;

  public SearchController(SearchService searchService) {
    this.searchService = searchService;
  }

  @GetMapping("/store/name/global")
  @ApiOperation(value = "全局搜索店铺", notes = "根据店铺名称全局搜索店铺")
  public ResponseDTO<List<Store>> searchStoreByNameInGlobal(@RequestParam String storeName,
      @RequestParam int page,
      @RequestParam int size) {
    return new ResponseDTO<>(200, null,
        searchService.searchStoreByNameInGlobal(storeName, page, size));
  }

  @GetMapping("/store/name/canteen")
  @ApiOperation(value = "在食堂内搜索店铺", notes = "在指定食堂内根据店铺名称搜索店铺")
  public ResponseDTO<List<Store>> searchStoreByNameInCanteen(@RequestParam String storeName,
      @RequestParam long canteenId,
      @RequestParam int page,
      @RequestParam int size) {
    return new ResponseDTO<>(200, null,
        searchService.searchStoreByNameInCanteen(storeName, canteenId, page, size));
  }

  @GetMapping("/food/name/global")
  @ApiOperation(value = "全局搜索食品", notes = "根据食品名称全局搜索食品")
  public ResponseDTO<List<Food>> searchFoodByNameInGlobal(@RequestParam String foodName,
      @RequestParam int page,
      @RequestParam int size) {
    return new ResponseDTO<>(200, null,
        searchService.searchFoodByNameInGlobal(foodName, page, size));
  }

  @GetMapping("/food/name/store")
  @ApiOperation(value = "在店铺内搜索食品", notes = "在指定店铺内根据食品名称搜索食品")
  public ResponseDTO<List<Food>> searchFoodByNameInStore(@RequestParam String foodName,
      @RequestParam long storeId,
      @RequestParam int page,
      @RequestParam int size) {
    return new ResponseDTO<>(200, null,
        searchService.searchFoodByNameInStore(foodName, storeId, page, size));
  }

  @GetMapping("/food/name/canteen")
  @ApiOperation(value = "在食堂内搜索食品", notes = "在指定食堂内根据食品名称搜索食品")
  public ResponseDTO<List<Food>> searchFoodByNameInCanteen(@RequestParam String foodName,
      @RequestParam long canteenId,
      @RequestParam int page,
      @RequestParam int size) {
    return new ResponseDTO<>(200, null,
        searchService.searchFoodByNameInCanteen(foodName, canteenId, page, size));
  }
}
