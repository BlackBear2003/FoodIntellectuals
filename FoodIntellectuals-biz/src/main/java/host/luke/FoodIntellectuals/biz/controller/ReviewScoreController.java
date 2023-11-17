package host.luke.FoodIntellectuals.biz.controller;

import host.luke.FoodIntellectuals.biz.service.ScoreService;
import host.luke.FoodIntellectuals.common.dto.ResponseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/review/score")
@Api(tags = "评分相关接口", description = "提供评分相关操作的接口")
public class ReviewScoreController {

  private final ScoreService scoreService;

  public ReviewScoreController(ScoreService scoreService) {
    this.scoreService = scoreService;
  }

  @GetMapping("/store/attitude")
  @ApiOperation(value = "计算店铺态度评分", notes = "根据店铺ID计算店铺态度评分")
  public ResponseDto<Double> calculateStoreAttitudeScore(@RequestParam long storeId) {
    return new ResponseDto<>(200, null, scoreService.calculateStoreAttitudeScore(storeId));
  }

  @GetMapping("/store/store")
  @ApiOperation(value = "计算店铺总体评分", notes = "根据店铺ID计算店铺总体评分")
  public ResponseDto<Double> calculateStoreScore(@RequestParam long storeId) {
    return new ResponseDto<>(200, null, scoreService.calculateStoreScore(storeId));
  }

  @GetMapping("/food")
  @ApiOperation(value = "计算食品总体评分", notes = "根据食品ID计算食品总体评分")
  public ResponseDto<Double> calculateFoodScore(@RequestParam long foodId) {
    return new ResponseDto<>(200, null, scoreService.calculateFoodScore(foodId));
  }

  @GetMapping("/food/wait-time")
  @ApiOperation(value = "计算食品等待时间评分", notes = "根据食品ID计算食品等待时间评分")
  public ResponseDto<Double> calculateFoodWaitTimeScore(@RequestParam long foodId) {
    return new ResponseDto<>(200, null, scoreService.calculateFoodWaitTimeScore(foodId));
  }

  @GetMapping("/food/flavor")
  @ApiOperation(value = "计算食品口味评分", notes = "根据食品ID计算食品口味评分")
  public ResponseDto<Double> calculateFoodFlavorScore(@RequestParam long foodId) {
    return new ResponseDto<>(200, null, scoreService.calculateFoodFlavorScore(foodId));
  }
}
