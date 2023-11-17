package host.luke.FoodIntellectuals.biz.controller;

import host.luke.FoodIntellectuals.biz.service.FoodTagService;
import host.luke.FoodIntellectuals.biz.service.TagService;
import host.luke.FoodIntellectuals.common.dto.ResponseDTO;
import host.luke.FoodIntellectuals.common.entity.FoodTag;
import host.luke.FoodIntellectuals.common.entity.Tag;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tag")
@Api(tags = "标签相关接口", description = "提供标签相关操作的接口")
public class TagController {

  private final FoodTagService foodTagService;
  private final TagService tagService;

  public TagController(FoodTagService foodTagService, TagService tagService) {
    this.foodTagService = foodTagService;
    this.tagService = tagService;
  }

  @PostMapping("/")
  @ApiOperation(value = "创建标签", notes = "创建新的标签")
  public ResponseDTO<Tag> create(@RequestBody Tag tag) {
    Tag saved = tagService.save(tag);
    return new ResponseDTO<>(200, null, saved);
  }

  @GetMapping("/tagId")
  @ApiOperation(value = "根据标签ID获取标签信息", notes = "根据标签ID获取指定标签的详细信息")
  public ResponseDTO<Tag> findById(@RequestParam Long tagId) {
    Tag tag = tagService.findTagById(tagId);
    return new ResponseDTO<>(200, null, tag);
  }

  @GetMapping("/tagType")
  @ApiOperation(value = "根据标签类型获取标签列表", notes = "根据标签类型获取指定类型的标签列表")
  public ResponseDTO<List<Tag>> findByType(@RequestParam Integer tagType) {
    List<Tag> tags = tagService.findByType(tagType);
    return new ResponseDTO<>(200, null, tags);
  }

  @GetMapping("/tagName")
  @ApiOperation(value = "根据标签名称搜索标签", notes = "根据标签名称搜索标签列表")
  public ResponseDTO<List<Tag>> searchTagByTagName(@RequestParam String tagName) {
    List<Tag> tags = tagService.searchTagByTagName(tagName);
    return new ResponseDTO<>(200, null, tags);
  }

  @GetMapping("/foodId")
  @ApiOperation(value = "根据食品ID获取标签列表", notes = "根据食品ID获取指定食品关联的标签列表")
  public ResponseDTO<List<Tag>> findByFoodId(@RequestParam long foodId) {
    List<Tag> tags = foodTagService.findTagsByFoodId(foodId);
    return new ResponseDTO<>(200, null, tags);
  }

  @PostMapping("/food")
  @ApiOperation(value = "为食品添加标签", notes = "为指定食品添加标签")
  public ResponseDTO<FoodTag> save(@RequestParam Long foodId,
      @RequestParam Integer tagType,
      @RequestParam String tagName) {
    FoodTag saved = foodTagService.saveByTagTypeAndName(foodId, tagType, tagName);
    return new ResponseDTO<>(200, null, saved);
  }
}
