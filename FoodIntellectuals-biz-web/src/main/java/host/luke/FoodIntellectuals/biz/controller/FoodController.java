package host.luke.FoodIntellectuals.biz.controller;

import host.luke.FoodIntellectuals.biz.entity.UserFoodCollect;
import host.luke.FoodIntellectuals.biz.repository.CollectRepository;
import host.luke.FoodIntellectuals.biz.service.AsyncTaskService;
import host.luke.FoodIntellectuals.biz.service.FoodService;
import host.luke.FoodIntellectuals.biz.service.FoodTagService;
import host.luke.FoodIntellectuals.common.constant.HotValueConstant;
import host.luke.FoodIntellectuals.common.dto.FoodDto;
import host.luke.FoodIntellectuals.common.dto.ResponseDto;
import host.luke.FoodIntellectuals.biz.entity.Food;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/food")
@Api(tags = "食品相关接口", description = "提供食品相关操作的接口")
public class FoodController {

  private final FoodService foodService;
  private final FoodTagService foodTagService;
  private final AsyncTaskService asyncTaskService;

  final
  CollectRepository collectRepository;

  public FoodController(FoodService foodService, FoodTagService foodTagService, AsyncTaskService asyncTaskService, CollectRepository collectRepository) {
    this.foodService = foodService;
    this.foodTagService = foodTagService;
    this.asyncTaskService = asyncTaskService;
    this.collectRepository = collectRepository;
  }

  @GetMapping("/")
  @ApiOperation(value = "获取所有食品", notes = "分页获取所有食品信息")
  public ResponseDto<List<FoodDto>> findAll(@RequestParam int page, @RequestParam int size) {
    List<FoodDto> foodDtoList = foodService.findAll(page, size);
    return new ResponseDto<>(200, null, foodDtoList);
  }

  @GetMapping("/storeId")
  @ApiOperation(value = "根据店铺ID获取食品列表", notes = "分页获取指定店铺的食品列表")
  public ResponseDto<List<FoodDto>> findByStoreId(@RequestParam long storeId, @RequestParam int page,
                                                  @RequestParam int size) {
    List<FoodDto> foodList = foodService.findByStoreId(storeId, page, size);
    asyncTaskService.addHotValue(foodList, HotValueConstant.checkValue);
    return new ResponseDto<>(200, null, foodList);
  }

  @GetMapping("/foodId")
  @ApiOperation(value = "根据食品ID获取食品详情", notes = "根据食品ID获取指定食品的详细信息")
  public ResponseDto<FoodDto> findByFoodId(@RequestParam long foodId) {
    FoodDto food = foodService.findByFoodId(foodId);
    asyncTaskService.addHotValue(food, HotValueConstant.clickValue);
    return new ResponseDto<>(200, null, food);
  }

  @GetMapping("/tagId")
  @ApiOperation(value = "根据标签ID获取食品列表", notes = "分页获取指定标签下的食品列表")
  public ResponseDto<List<FoodDto>> findByTagType(Long tagId, int page, int size) {
    List<FoodDto> foodDtoList = foodTagService.findFoodsByTagId(tagId, page, size);
    asyncTaskService.addHotValue(foodDtoList, HotValueConstant.checkValue);
    return new ResponseDto<>(200, null, foodDtoList);
  }

  @GetMapping("/collect")
  @ApiOperation(value = "收藏菜品", notes = "点击爱心收藏菜品，再次点击取消收藏")
  public ResponseDto<Void> collectFood(@RequestParam Long userId, @RequestParam Long foodId) {
    List<UserFoodCollect> existingRecords = collectRepository.findByUserIdAndTypeAndFoodId(userId, 0, foodId);
    if (existingRecords.isEmpty()) {
      UserFoodCollect userFoodCollect = new UserFoodCollect();
      userFoodCollect.setType(0);
      userFoodCollect.setFoodId(foodId);
      userFoodCollect.setUserId(userId);
      collectRepository.save(userFoodCollect);
    } else {
      collectRepository.deleteAll(existingRecords);
    }
    return ResponseDto.success("收藏成功");
  }


  @GetMapping("/collect/list")
  @ApiOperation(value = "获取收藏list", notes = "获取收藏list")
  public ResponseDto<List<FoodDto>> collectFood(@RequestParam Long userId) {
    List<Long> collect = collectRepository.findByUserId(userId).stream().map(UserFoodCollect::getFoodId).collect(Collectors.toList());

    return ResponseDto.success("收藏成功");
  }
}
