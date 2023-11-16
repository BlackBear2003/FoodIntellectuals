package host.luke.FoodIntellectuals.biz.controller;

import host.luke.FoodIntellectuals.biz.service.FoodService;
import host.luke.FoodIntellectuals.biz.service.FoodTagService;
import host.luke.FoodIntellectuals.common.dto.ResponseDto;
import host.luke.FoodIntellectuals.common.entity.Food;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/food")
public class FoodController {

  private final FoodService foodService;
  private final FoodTagService foodTagService;

  public FoodController(FoodService foodService, FoodTagService foodTagService) {
    this.foodService = foodService;
    this.foodTagService = foodTagService;
  }

  @GetMapping("/")
  public ResponseDto<List<Food>> findAll(@RequestParam int page, @RequestParam int size) {
    List<Food> canteenList = foodService.findAll(page, size);
    return new ResponseDto<>(200, null, canteenList);
  }

  @GetMapping("/storeId")
  public ResponseDto<List<Food>> findByStoreId(@RequestParam long storeId, @RequestParam int page,
      @RequestParam int size) {
    List<Food> foodList = foodService.findByStoreId(storeId, page, size);
    return new ResponseDto<>(200, null, foodList);
  }

  @GetMapping("/foodId")
  public ResponseDto<Food> findByFoodId(@RequestParam long foodId) {
    Food food = foodService.findByFoodId(foodId);
    return new ResponseDto<>(200, null, food);
  }

  @GetMapping("/tagId")
  public ResponseDto<List<Food>> findByTagType(Long tagId, int page, int size) {
    List<Food> foodTags = foodTagService.findFoodsByTagId(tagId, page, size);
    return new ResponseDto<>(200, null, foodTags);
  }
}
