package host.luke.FoodIntellectuals.biz.controller;

import host.luke.FoodIntellectuals.biz.service.FoodService;
import host.luke.FoodIntellectuals.biz.service.FoodTagService;
import host.luke.FoodIntellectuals.common.dto.ResponseDto;
import host.luke.FoodIntellectuals.common.entity.Food;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/food")
@Api(tags = "食品相关接口", description = "提供食品相关操作的接口")
public class FoodController {

  private final FoodService foodService;
  private final FoodTagService foodTagService;

  public FoodController(FoodService foodService, FoodTagService foodTagService) {
    this.foodService = foodService;
    this.foodTagService = foodTagService;
  }

  @GetMapping("/")
  @ApiOperation(value = "获取所有食品", notes = "分页获取所有食品信息")
  public ResponseDto<List<Food>> findAll(@RequestParam int page, @RequestParam int size) {
    List<Food> canteenList = foodService.findAll(page, size);
    return new ResponseDto<>(200, null, canteenList);
  }

  @GetMapping("/storeId")
  @ApiOperation(value = "根据店铺ID获取食品列表", notes = "分页获取指定店铺的食品列表")
  public ResponseDto<List<Food>> findByStoreId(@RequestParam long storeId, @RequestParam int page,
      @RequestParam int size) {
    List<Food> foodList = foodService.findByStoreId(storeId, page, size);
    return new ResponseDto<>(200, null, foodList);
  }

  @GetMapping("/foodId")
  @ApiOperation(value = "根据食品ID获取食品详情", notes = "根据食品ID获取指定食品的详细信息")
  public ResponseDto<Food> findByFoodId(@RequestParam long foodId) {
    Food food = foodService.findByFoodId(foodId);
    return new ResponseDto<>(200, null, food);
  }

  @GetMapping("/tagId")
  @ApiOperation(value = "根据标签ID获取食品列表", notes = "分页获取指定标签下的食品列表")
  public ResponseDto<List<Food>> findByTagType(Long tagId, int page, int size) {
    List<Food> foodTags = foodTagService.findFoodsByTagId(tagId, page, size);
    return new ResponseDto<>(200, null, foodTags);
  }
}
