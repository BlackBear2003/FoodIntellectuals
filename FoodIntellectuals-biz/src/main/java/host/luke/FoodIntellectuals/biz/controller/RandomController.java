package host.luke.FoodIntellectuals.biz.controller;

import host.luke.FoodIntellectuals.biz.service.FoodService;
import host.luke.FoodIntellectuals.biz.service.FoodTagService;
import host.luke.FoodIntellectuals.common.dto.ResponseDTO;
import host.luke.FoodIntellectuals.common.entity.Food;
import java.util.Collections;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/random")
public class RandomController {

  private final FoodTagService foodTagService;
  private final FoodService foodService;

  public RandomController(FoodTagService foodTagService, FoodService foodService) {
    this.foodTagService = foodTagService;
    this.foodService = foodService;
  }

  @PostMapping("/food/filter-by-tagId")
  public ResponseDTO<Food> findRandomFoodFilterByTagId(@RequestBody List<Long> tagIds) {
    List<Long> foodIds = foodTagService.findFoodIdsHavingSpecificTagIds(tagIds);
    Collections.shuffle(foodIds);
    Food food = foodService.findByFoodId(foodIds.get(0));
    return new ResponseDTO<>(200, null, food);
  }

}
