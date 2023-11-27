package host.luke.FoodIntellectuals.biz.controller;

import host.luke.FoodIntellectuals.biz.entity.FoodScore;
import host.luke.FoodIntellectuals.biz.service.FoodScoreService;
import host.luke.FoodIntellectuals.common.dto.ResponseDto;
import host.luke.FoodIntellectuals.redis.api.RedisQueryApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/food/score")
public class FoodScoreController {

  private final FoodScoreService foodScoreService;

  public FoodScoreController(FoodScoreService foodScoreService) {
    this.foodScoreService = foodScoreService;
  }

  @GetMapping("/foodId")
  public ResponseDto<Double> calculateScoreByFoodId(@RequestParam long foodId) {
    double score = foodScoreService.calculateFoodScore(foodId);
    return new ResponseDto<>(200, null, score);
  }

  @PostMapping("/")
  public ResponseDto<FoodScore> scoreFood(@RequestBody FoodScore foodScore) {
    return new ResponseDto<>(200, null, foodScoreService.save(foodScore));
  }

}
