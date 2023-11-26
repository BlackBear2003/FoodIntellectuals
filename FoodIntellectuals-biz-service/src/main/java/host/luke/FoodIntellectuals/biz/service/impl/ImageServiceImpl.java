package host.luke.FoodIntellectuals.biz.service.impl;

import host.luke.FoodIntellectuals.biz.repository.ImageRepository;
import host.luke.FoodIntellectuals.biz.service.ImageService;
import host.luke.FoodIntellectuals.biz.entity.Image;
import host.luke.FoodIntellectuals.common.vo.ImageVO;
import host.luke.FoodIntellectuals.oss.service.OssService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService {

  private final ImageRepository imageRepository;
  private final OssService ossService;

  public ImageServiceImpl(ImageRepository imageRepository, OssService ossService) {
    this.imageRepository = imageRepository;
    this.ossService = ossService;
  }

  @Override
  public Image findById(Long imageId) {
    return imageRepository.findById(imageId).orElse(new Image());
  }

  @Override
  public List<Image> findByBelongTypeAndId(String type, Long id) {
    List<Image> imageList = imageRepository.findImagesByBelongTypeAndBelongId(
        type, id);
    return imageList;
  }

  @Override
  public List<String> findUrlListByBelongTypeAndId(String type, Long id) {
    return findByBelongTypeAndId(type, id)
        .stream().map(Image::getUrl).collect(Collectors.toList());
  }

  @Override
  public Image save(ImageVO imageVO) {
    /* do qiniu*/
    String url = ossService.uploadImg(imageVO.getBase64());
    Image image = new Image();
    image.setUrl(url);
    image.setBelongId(imageVO.getBelongId());
    image.setBelongType(imageVO.getBelongType());
    return imageRepository.save(image);
  }

  @Override
  public void deleteByBelongTypeAndId(String type, Long id) {
    imageRepository.deleteAllByBelongTypeAndBelongId(type, id);
  }

  @Override
  public void deleteByImageId(Long imageId) {
    imageRepository.deleteById(imageId);
  }
}
