package host.luke.FoodIntellectuals.biz.controller;

import host.luke.FoodIntellectuals.biz.service.FoodTagService;
import host.luke.FoodIntellectuals.common.dto.ResponseDto;
import host.luke.FoodIntellectuals.common.entity.FoodTag;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/foodTag")
public class FoodTagController {

  private final FoodTagService foodTagService;

  public FoodTagController(FoodTagService foodTagService) {
    this.foodTagService = foodTagService;
  }

  @GetMapping("/foodId")
  public ResponseDto<List<FoodTag>> findByFoodId(long foodId) {
    List<FoodTag> foodTags = foodTagService.findByFoodId(foodId);
    return new ResponseDto<>(200, null, foodTags);
  }

  @GetMapping("/save")
  public ResponseDto<FoodTag> save(FoodTag foodTag) {
    FoodTag newFoodTag = foodTagService.save(foodTag);
    return new ResponseDto<>(200, null, newFoodTag);
  }

  @GetMapping("/tagType")
  public ResponseDto<List<FoodTag>> findByTagType(Integer tagType) {
    List<FoodTag> foodTags = foodTagService.findByTagType(tagType);
    return new ResponseDto<>(200, null, foodTags);
  }
}
