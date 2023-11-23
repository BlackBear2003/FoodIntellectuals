package host.luke.FoodIntellectuals.biz.service;

import host.luke.FoodIntellectuals.biz.pojo.FoodRankItem;
import host.luke.FoodIntellectuals.common.entity.Food;

import java.util.List;

public interface AsyncTaskService {
  void addHotValue(Food food,Integer Value);
  void addHotValue(List<Food> foodList,Integer Value);
}
