package host.luke.FoodIntellectuals.biz.service.impl;

import cn.hutool.core.bean.BeanUtil;
import host.luke.FoodIntellectuals.biz.entity.Image;
import host.luke.FoodIntellectuals.biz.repository.FoodRepository;
import host.luke.FoodIntellectuals.biz.repository.FoodTagRepository;
import host.luke.FoodIntellectuals.biz.repository.TagRepository;
import host.luke.FoodIntellectuals.biz.service.FoodTagService;
import host.luke.FoodIntellectuals.biz.entity.Food;
import host.luke.FoodIntellectuals.biz.entity.FoodTag;
import host.luke.FoodIntellectuals.biz.entity.Tag;
import host.luke.FoodIntellectuals.biz.service.ImageService;
import host.luke.FoodIntellectuals.biz.util.DtoUtil;
import host.luke.FoodIntellectuals.common.constant.ImageType;
import host.luke.FoodIntellectuals.common.dto.FoodDto;
import java.util.ArrayList;
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
  private final ImageService imageService;

  public FoodTagServiceImpl(FoodTagRepository foodTagRepository, TagRepository tagRepository,
      FoodRepository foodRepository, ImageService imageService) {
    this.foodTagRepository = foodTagRepository;
    this.tagRepository = tagRepository;
    this.foodRepository = foodRepository;
    this.imageService = imageService;
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
  public List<FoodDto> findFoodsByTagId(Long tagId, int page, int size) {
    Pageable pageable = PageRequest.of(page, size);
    List<FoodTag> foodTagList = foodTagRepository.findByTagId(tagId);
    List<Long> foodIdList = foodTagList.stream()
        .map(FoodTag::getFoodId)
        .collect(Collectors.toList());
    List<Food> foodList = foodRepository.findAllByIdIn(foodIdList, pageable);
    return foodList.stream().map(food -> DtoUtil.foodToFoodDto(food,
            imageService.findUrlListByBelongTypeAndId("Food", food.getId())))
        .collect(Collectors.toList());
  }

  @Override
  public List<Long> findFoodIdsHavingSpecificTagIds(List<Long> tagIds) {
    return foodTagRepository.findDistinctFoodIdByTagIds(tagIds);
  }
}
