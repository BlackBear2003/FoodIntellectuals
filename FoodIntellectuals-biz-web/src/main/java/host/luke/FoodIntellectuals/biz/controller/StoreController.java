package host.luke.FoodIntellectuals.biz.controller;

import host.luke.FoodIntellectuals.biz.service.StoreService;
import host.luke.FoodIntellectuals.common.dto.ResponseDto;
import host.luke.FoodIntellectuals.biz.entity.Store;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.Collections;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/store")
@Api(tags = "店铺相关接口", description = "提供店铺相关操作的接口")
public class StoreController {

  private final StoreService storeService;

  public StoreController(StoreService storeService) {
    this.storeService = storeService;
  }

  @GetMapping("/")
  @ApiOperation(value = "获取所有店铺", notes = "分页获取所有店铺信息")
  public ResponseDto<List<Store>> findAll(@RequestParam int page, @RequestParam int size) {
    return new ResponseDto<>(200, null, storeService.findAll(page, size));
  }

  @GetMapping("/canteenId")
  @ApiOperation(value = "根据食堂ID获取店铺列表", notes = "分页获取指定食堂下的店铺列表")
  public ResponseDto<List<Store>> findByCanteenId(
      @RequestParam long canteenId,
      @RequestParam int page,
      @RequestParam int size
  ) {

    List<Store> storeList = storeService.findByCanteenId(canteenId, page, size);
    Collections.shuffle(storeList);
    return new ResponseDto<>(200, null, storeList);
  }

  @GetMapping("/storeId")
  @ApiOperation(value = "根据店铺ID获取店铺详情", notes = "根据店铺ID获取指定店铺的详细信息")
  public ResponseDto<Store> findByStoreId(@RequestParam long storeId) {
    return new ResponseDto<>(200, null, storeService.findByStoreId(storeId));
  }

  @GetMapping("/like")
  @ApiOperation(value = "根据店铺ID统计点赞数量", notes = "根据店铺ID统计点赞的数量")
  public ResponseDto<Long> countLikeByStoreId(@RequestParam long storeId) {
    return new ResponseDto<>(200, null, storeService.countLikeByStoreId(storeId));
  }

  @GetMapping("/dislike")
  @ApiOperation(value = "根据店铺ID统计踩数量", notes = "根据店铺ID统计踩的数量")
  public ResponseDto<Long> countDislikeByStoreId(@RequestParam long storeId) {
    return new ResponseDto<>(200, null, storeService.countDislikeByStoreId(storeId));
  }
}
