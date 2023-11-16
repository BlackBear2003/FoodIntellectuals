package host.luke.FoodIntellectuals.biz.controller;

import host.luke.FoodIntellectuals.biz.service.ScoreService;
import host.luke.FoodIntellectuals.common.dto.ResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/review-score")
public class ReviewScoreController {

  private final ScoreService scoreService;

  public ReviewScoreController(ScoreService scoreService) {
    this.scoreService = scoreService;
  }

  @GetMapping("/store/attitude")
  public ResponseDto<Double> calculateStoreAttitudeScore(long storeId) {
    return new ResponseDto<>(200, null, scoreService.calculateStoreAttitudeScore(storeId));
  }

  @GetMapping("/store/store")
  public ResponseDto<Double> calculateStoreScore(long storeId) {
    return new ResponseDto<>(200, null, scoreService.calculateStoreScore(storeId));
  }

  @GetMapping("/food")
  public ResponseDto<Double> calculateFoodScore(long foodId) {
    return new ResponseDto<>(200, null, scoreService.calculateFoodScore(foodId));
  }

  @GetMapping("/food/wait-time")
  public ResponseDto<Double> calculateFoodWaitTimeScore(long foodId) {
    return new ResponseDto<>(200, null, scoreService.calculateFoodWaitTimeScore(foodId));
  }

  @GetMapping("/food/flavor")
  public ResponseDto<Double> calculateFoodFlavorScore(long foodId) {
    return new ResponseDto<>(200, null, scoreService.calculateFoodFlavorScore(foodId));
  }
}
