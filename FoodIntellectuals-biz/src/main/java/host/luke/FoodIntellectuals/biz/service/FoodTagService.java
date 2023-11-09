package host.luke.FoodIntellectuals.biz.service;

import host.luke.FoodIntellectuals.common.entity.FoodTag;
import java.util.List;

public interface FoodTagService {

  List<FoodTag> findByFoodId(long foodId);

  List<FoodTag> save(FoodTag foodTag);

  List<FoodTag> findByTagType(Integer tagType);

  /**
   * blur search?
   * @param tagName
   * @return
   */
  List<FoodTag> findByTagName(String tagName);

}
