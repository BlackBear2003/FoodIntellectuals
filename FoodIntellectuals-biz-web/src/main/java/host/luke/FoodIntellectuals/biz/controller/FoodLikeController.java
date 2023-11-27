package host.luke.FoodIntellectuals.biz.controller;

import host.luke.FoodIntellectuals.biz.service.FoodLikeService;
import host.luke.FoodIntellectuals.common.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/food/like")
public class FoodLikeController {

  @Autowired
  private FoodLikeService foodLikeService;

  @GetMapping("/")
  public ResponseDto<Long> getLikeNumByFoodId(@RequestParam long foodId) {
    long num = foodLikeService.getLikeNumByFoodId(foodId);
    return new ResponseDto<>(200, null, num);
  }


  @PostMapping("/click")
  public ResponseDto<String> click(@RequestParam long foodId, @RequestParam long userId) {
    foodLikeService.clickLike(foodId, userId);
    return new ResponseDto<>(200, null, "clicked");
  }

}
