package host.luke.FoodIntellectuals.biz.controller;

import host.luke.FoodIntellectuals.biz.service.FoodTagService;
import host.luke.FoodIntellectuals.biz.service.TagService;
import host.luke.FoodIntellectuals.common.dto.ResponseDto;
import host.luke.FoodIntellectuals.common.entity.FoodTag;
import host.luke.FoodIntellectuals.common.entity.Tag;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tag")
public class TagController {

  private final FoodTagService foodTagService;
  private final TagService tagService;

  public TagController(FoodTagService foodTagService, TagService tagService) {
    this.foodTagService = foodTagService;
    this.tagService = tagService;
  }

  @PostMapping("/")
  public ResponseDto<Tag> create(Tag tag) {
    Tag saved = tagService.save(tag);
    return new ResponseDto<>(200, null, saved);
  }

  @GetMapping("/tagId")
  public ResponseDto<Tag> findById(Long tagId) {
    Tag tag = tagService.findTagById(tagId);
    return new ResponseDto<>(200, null, tag);
  }

  @GetMapping("/tagType")
  public ResponseDto<List<Tag>> findById(Integer tagType) {
    List<Tag> tags = tagService.findByType(tagType);
    return new ResponseDto<>(200, null, tags);
  }

  @GetMapping("/tagName")
  public ResponseDto<List<Tag>> searchTagByTagName(String tagName) {
    List<Tag> tags = tagService.searchTagByTagName(tagName);
    return new ResponseDto<>(200, null, tags);
  }

  @GetMapping("/foodId")
  public ResponseDto<List<Tag>> findByFoodId(long foodId) {
    List<Tag> tags = foodTagService.findTagsByFoodId(foodId);
    return new ResponseDto<>(200, null, tags);
  }

  @PostMapping("/food")
  public ResponseDto<FoodTag> save(Long foodId, Integer tagType, String tagName) {
    FoodTag saved = foodTagService.saveByTagTypeAndName(foodId, tagType, tagName);
    return new ResponseDto<>(200, null, saved);
  }

}
