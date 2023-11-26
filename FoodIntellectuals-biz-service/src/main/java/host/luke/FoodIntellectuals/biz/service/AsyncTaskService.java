package host.luke.FoodIntellectuals.biz.service;

import host.luke.FoodIntellectuals.biz.entity.Food;

import host.luke.FoodIntellectuals.common.dto.FoodDto;
import java.util.List;

public interface AsyncTaskService {
  void addHotValue(FoodDto food,Integer Value);
  void addHotValue(List<FoodDto> foodList,Integer Value);
}
