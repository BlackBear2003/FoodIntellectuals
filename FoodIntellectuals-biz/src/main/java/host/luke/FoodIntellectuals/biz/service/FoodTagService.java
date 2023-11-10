package host.luke.FoodIntellectuals.biz.service;

import host.luke.FoodIntellectuals.common.entity.FoodTag;
import java.util.List;

public interface FoodTagService {

  List<FoodTag> findByFoodId(long foodId);

  FoodTag save(FoodTag foodTag);

  List<FoodTag> findByTagType(Integer tagType);
}