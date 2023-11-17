package host.luke.FoodIntellectuals.biz.controller;

import host.luke.FoodIntellectuals.biz.service.ImageService;
import host.luke.FoodIntellectuals.common.dto.ResponseDto;
import host.luke.FoodIntellectuals.common.entity.Image;
import host.luke.FoodIntellectuals.common.vo.ImageVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/image")
@Api(tags = "图片相关接口", description = "提供图片相关操作的接口")
public class ImageController {

  private final ImageService imageService;

  public ImageController(ImageService imageService) {
    this.imageService = imageService;
  }

  @GetMapping("/")
  @ApiOperation(value = "根据图片ID获取图片信息", notes = "根据图片ID获取指定图片的详细信息")
  public ResponseDto<Image> findById(@RequestParam Long imageId) {
    Image image = imageService.findById(imageId);
    return new ResponseDto<>(200, null, image);
  }

  @GetMapping("/belong")
  @ApiOperation(value = "根据类型和ID获取图片列表", notes = "根据类型和ID获取指定类型和ID下的图片列表")
  public ResponseDto<List<Image>> getImagesByBelongTypeAndId(
      @RequestParam String belongType,
      @RequestParam Long belongId) {
    List<Image> images = imageService.findByBelongTypeAndId(belongType, belongId);
    return new ResponseDto<>(200, null, images);
  }

  @PostMapping
  @ApiOperation(value = "保存图片", notes = "保存图片信息")
  public ResponseDto<Image> saveImage(@RequestBody ImageVO imageVO) {
    Image savedImage = imageService.save(imageVO);
    return new ResponseDto<>(200, null, savedImage);
  }

  @DeleteMapping("/belong")
  @ApiOperation(value = "根据类型和ID删除图片列表", notes = "根据类型和ID删除指定类型和ID下的图片列表")
  public ResponseDto<Void> deleteImagesByBelongTypeAndId(
      @RequestParam String belongType,
      @RequestParam Long belongId) {
    imageService.deleteByBelongTypeAndId(belongType, belongId);
    return new ResponseDto<>(200, null, null);
  }

  @DeleteMapping("/")
  @ApiOperation(value = "根据图片ID删除图片", notes = "根据图片ID删除指定图片")
  public ResponseDto<Void> delete(@RequestParam Long imageId) {
    imageService.deleteByImageId(imageId);
    return new ResponseDto<>(200, null, null);
  }
}
