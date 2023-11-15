package host.luke.FoodIntellectuals.biz.service.impl;

import host.luke.FoodIntellectuals.biz.repository.FoodTagRepository;
import host.luke.FoodIntellectuals.biz.service.FoodTagService;
import host.luke.FoodIntellectuals.common.entity.Food;
import host.luke.FoodIntellectuals.common.entity.FoodTag;
import host.luke.FoodIntellectuals.common.entity.Tag;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class FoodTagServiceImpl implements FoodTagService {

  @Override
  public List<Tag> findTagsByFoodId(long foodId) {
    return null;
  }

  @Override
  public FoodTag save(FoodTag foodTag) {
    return null;
  }

  @Override
  public FoodTag saveByTagTypeAndName(Long foodId, String tagType, String tagName) {
    return null;
  }

  @Override
  public List<Food> findFoodsByTagId(Long tagId, int page, int size) {
    return null;
  }
}
