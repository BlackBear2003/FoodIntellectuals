package host.luke.FoodIntellectuals.biz.controller;

import host.luke.FoodIntellectuals.biz.service.ImageService;
import host.luke.FoodIntellectuals.common.dto.ResponseDto;
import host.luke.FoodIntellectuals.common.entity.Image;
import host.luke.FoodIntellectuals.common.vo.ImageVO;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/image")
public class ImageController {

  private final ImageService imageService;

  public ImageController(ImageService imageService) {
    this.imageService = imageService;
  }

  @GetMapping("/")
  public ResponseDto<Image> findById(@RequestParam Long imageId) {
    Image image = imageService.findById(imageId);
    return new ResponseDto<>(200, null, image);
  }

  @GetMapping("/belong")
  public ResponseDto<List<Image>> getImagesByBelongTypeAndId(
      @RequestParam String belongType,
      @RequestParam Long belongId) {
    List<Image> images = imageService.findByBelongTypeAndId(belongType, belongId);
    return new ResponseDto<>(200, null, images);
  }

  @PostMapping
  public ResponseDto<Image> saveImage(@RequestBody ImageVO imageVO) {
    Image savedImage = imageService.save(imageVO);
    return new ResponseDto<>(200, null, savedImage);
  }

  @DeleteMapping("/belong")
  public ResponseDto<Void> deleteImagesByBelongTypeAndId(
      @RequestParam String belongType,
      @RequestParam Long belongId) {
    imageService.deleteByBelongTypeAndId(belongType, belongId);
    return new ResponseDto<>(200, null, null);
  }

  @DeleteMapping("/")
  public ResponseDto<Void> delete(@RequestParam Long imageId) {
    imageService.deleteByImageId(imageId);
    return new ResponseDto<>(200, null, null);
  }
}
