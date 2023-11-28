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

  @GetMapping("/foodId")
  public ResponseDto<Integer> getLikeNumByFoodId(@RequestParam long foodId) {
    int num = foodLikeService.getLikeNumByFoodId(foodId);
    return new ResponseDto<>(200, null, num);
  }

  @GetMapping("/")
  public ResponseDto<Boolean> isUserLikedFood(@RequestParam long foodId, @RequestParam long userId) {
    boolean liked = foodLikeService.isLiked(foodId, userId);
    return new ResponseDto<>(200, null, liked);
  }

  @PostMapping("/click")
  public ResponseDto<String> click(@RequestParam long foodId, @RequestParam long userId) {
    foodLikeService.clickLike(foodId, userId);
    return new ResponseDto<>(200, null, "clicked");
  }

}
