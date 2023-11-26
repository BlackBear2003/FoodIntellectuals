package host.luke.FoodIntellectuals.biz.service;

import host.luke.FoodIntellectuals.biz.entity.Food;
import host.luke.FoodIntellectuals.biz.entity.FoodTag;
import host.luke.FoodIntellectuals.biz.entity.Tag;
import host.luke.FoodIntellectuals.common.dto.FoodDto;
import java.util.List;

public interface FoodTagService {

  List<Tag> findTagsByFoodId(long foodId);

  FoodTag save(FoodTag foodTag);

  FoodTag saveByTagTypeAndName(Long foodId, Integer tagType, String tagName);

  List<FoodDto> findFoodsByTagId(Long tagId, int page, int size);

  List<Long> findFoodIdsHavingSpecificTagIds(List<Long> tagIds);
}