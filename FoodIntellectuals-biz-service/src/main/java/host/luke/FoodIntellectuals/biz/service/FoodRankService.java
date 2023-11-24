package host.luke.FoodIntellectuals.biz.service;

import host.luke.FoodIntellectuals.biz.entity.Food;
import java.util.List;

public interface FoodRankService {

  List<Food> findTop10FoodRankByHotDot();

  List<Food> findTop10FoodRankByLike();

}
