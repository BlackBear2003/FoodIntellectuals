package host.luke.FoodIntellectuals.biz.service;

import host.luke.FoodIntellectuals.common.entity.Food;
import host.luke.FoodIntellectuals.common.entity.FoodTag;
import host.luke.FoodIntellectuals.common.entity.Tag;
import java.util.List;

public interface FoodTagService {

  List<Tag> findTagsByFoodId(long foodId);

  FoodTag save(FoodTag foodTag);

  FoodTag saveByTagTypeAndName(Long foodId, Integer tagType, String tagName);

  List<Food> findFoodsByTagId(Long tagId, int page, int size);

  List<Long> findFoodIdsHavingSpecificTagIds(List<Long> tagIds);
}