package host.luke.FoodIntellectuals.biz.service.impl;

import host.luke.FoodIntellectuals.biz.repository.FoodRepository;
import host.luke.FoodIntellectuals.biz.repository.FoodTagRepository;
import host.luke.FoodIntellectuals.biz.repository.TagRepository;
import host.luke.FoodIntellectuals.biz.service.FoodTagService;
import host.luke.FoodIntellectuals.common.entity.Food;
import host.luke.FoodIntellectuals.common.entity.FoodTag;
import host.luke.FoodIntellectuals.common.entity.Tag;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FoodTagServiceImpl implements FoodTagService {

  private final FoodTagRepository foodTagRepository;
  private final TagRepository tagRepository;
  private final FoodRepository foodRepository;

  public FoodTagServiceImpl(FoodTagRepository foodTagRepository, TagRepository tagRepository,
      FoodRepository foodRepository) {
    this.foodTagRepository = foodTagRepository;
    this.tagRepository = tagRepository;
    this.foodRepository = foodRepository;
  }

  @Override
  public List<Tag> findTagsByFoodId(long foodId) {
    List<FoodTag> foodTagList = foodTagRepository.findByFoodId(foodId);
    return foodTagList.stream()
        .map(foodTag -> tagRepository.findById(foodTag.getTagId()).orElse(null))
        .filter(Objects::nonNull)
        .collect(Collectors.toList());
  }

  @Override
  public FoodTag save(FoodTag foodTag) {
    return foodTagRepository.save(foodTag);
  }

  @Override
  public FoodTag saveByTagTypeAndName(Long foodId, Integer tagType, String tagName) {
    Tag tag = tagRepository.findByTagTypeAndTagName(tagType, tagName);
    if (tag != null) {
      FoodTag foodTag = new FoodTag();
      foodTag.setFoodId(foodId);
      foodTag.setTagId(tag.getId());
      return foodTagRepository.save(foodTag);
    }
    return null;
  }

  @Override
  public List<Food> findFoodsByTagId(Long tagId, int page, int size) {
    Pageable pageable = PageRequest.of(page, size);
    List<FoodTag> foodTagList = foodTagRepository.findByTagId(tagId);
    List<Long> foodIdList = foodTagList.stream()
        .map(FoodTag::getFoodId)
        .collect(Collectors.toList());
    return foodRepository.findAllByIdIn(foodIdList, pageable).getContent();
  }
}
