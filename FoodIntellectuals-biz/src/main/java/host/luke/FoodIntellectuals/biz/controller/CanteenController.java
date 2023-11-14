package host.luke.FoodIntellectuals.biz.controller;

import host.luke.FoodIntellectuals.biz.service.CanteenService;
import host.luke.FoodIntellectuals.common.dto.ResponseDto;
import host.luke.FoodIntellectuals.common.entity.Canteen;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/canteen")
public class CanteenController {

  private final CanteenService canteenService;

  public CanteenController(CanteenService canteenService) {
    this.canteenService = canteenService;
  }

  @GetMapping("/")
  public ResponseDto<List<Canteen>> findAll(@RequestParam int page, @RequestParam int size) {
    List<Canteen> canteenList = canteenService.findAll(page, size);
    return new ResponseDto<>(200, null, canteenList);
  }
}
