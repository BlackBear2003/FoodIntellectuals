package host.luke.FoodIntellectuals.biz.controller;

import host.luke.FoodIntellectuals.biz.entity.FoodComment;
import host.luke.FoodIntellectuals.biz.service.FoodCommentService;
import host.luke.FoodIntellectuals.common.dto.FoodCommentDto;
import host.luke.FoodIntellectuals.common.dto.ResponseDto;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/food/comment")
public class FoodCommentController {

  private final FoodCommentService foodCommentService;

  public FoodCommentController(FoodCommentService foodCommentService) {
    this.foodCommentService = foodCommentService;
  }

  @GetMapping("/")
  public ResponseDto<FoodCommentDto> findById(@RequestParam long id) {
    return new ResponseDto<>(200, null, foodCommentService.findById(id));
  }

  @PostMapping("/")
  public ResponseDto<FoodCommentDto> doComment(@RequestBody FoodComment foodComment) {
    FoodCommentDto save = foodCommentService.save(foodComment);
    return new ResponseDto<>(200, null, save);
  }

  @GetMapping("/foodId")
  public ResponseDto<List<FoodCommentDto>> findByFoodId(@RequestParam long foodId, @RequestParam int page, @RequestParam int size) {
    List<FoodCommentDto> dtoList = foodCommentService.findByFoodId(foodId, page, size);
    return new ResponseDto<>(200, null, dtoList);
  }

}
