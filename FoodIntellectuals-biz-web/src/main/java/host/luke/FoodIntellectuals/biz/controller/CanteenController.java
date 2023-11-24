package host.luke.FoodIntellectuals.biz.controller;

import host.luke.FoodIntellectuals.biz.service.CanteenService;
import host.luke.FoodIntellectuals.common.dto.ResponseDto;
import host.luke.FoodIntellectuals.biz.entity.Canteen;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/canteen")
@Api(tags = "食堂相关接口", description = "提供食堂相关操作的接口")
public class CanteenController {

  private final CanteenService canteenService;

  public CanteenController(CanteenService canteenService) {
    this.canteenService = canteenService;
  }

  @GetMapping("/")
  @ApiOperation(value = "获取所有食堂", notes = "分页获取所有食堂信息")
  public ResponseDto<List<Canteen>> findAll(@RequestParam int page, @RequestParam int size) {
    List<Canteen> canteenList = canteenService.findAll(page, size);
    return new ResponseDto<>(200, null, canteenList);
  }
}
