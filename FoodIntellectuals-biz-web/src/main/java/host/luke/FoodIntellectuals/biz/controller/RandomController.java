package host.luke.FoodIntellectuals.biz.controller;

import host.luke.FoodIntellectuals.biz.service.FoodService;
import host.luke.FoodIntellectuals.biz.service.FoodTagService;
import host.luke.FoodIntellectuals.common.dto.FoodDto;
import host.luke.FoodIntellectuals.common.dto.ResponseDto;
import host.luke.FoodIntellectuals.biz.entity.Food;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.Collections;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/random")
@Api("随机菜品接口")
public class RandomController {

  private final FoodTagService foodTagService;
  private final FoodService foodService;

  public RandomController(FoodTagService foodTagService, FoodService foodService) {
    this.foodTagService = foodTagService;
    this.foodService = foodService;
  }

  @PostMapping("/food/filter-by-tagId")
  @ApiOperation("通过传入的Tag ID List，随机获取菜品，如果全局搜索则传空的List，不要传id=0，没有效果")
  public ResponseDto<FoodDto> findRandomFoodFilterByTagId(@RequestBody List<Long> tagIds) {

    FoodDto random;
    if (!tagIds.isEmpty()) {
      List<Long> foodIds = foodTagService.findFoodIdsHavingSpecificTagIds(tagIds);
      Collections.shuffle(foodIds);
      random = foodService.findByFoodId(foodIds.get(0));
    } else {
      List<FoodDto> all = foodService.findAll(0, 100);
      int n = (int) (Math.random() * all.size());
      random = all.get(n);
    }

    return new ResponseDto<>(200, null, random);
  }

}
