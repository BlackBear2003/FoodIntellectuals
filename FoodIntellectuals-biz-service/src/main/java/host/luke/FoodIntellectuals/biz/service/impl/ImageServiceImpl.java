package host.luke.FoodIntellectuals.biz.service.impl;

import host.luke.FoodIntellectuals.biz.repository.ImageRepository;
import host.luke.FoodIntellectuals.biz.service.ImageService;
import host.luke.FoodIntellectuals.biz.entity.Image;
import host.luke.FoodIntellectuals.common.vo.ImageVO;
import host.luke.FoodIntellectuals.oss.service.OssService;
import java.util.ArrayList;
import java.util.List;
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
  public String findById(Long imageId) {
    return imageRepository.findById(imageId).orElse(new Image()).getUrl();
  }

  @Override
  public List<String> findByBelongTypeAndId(String type, Long id) {
    List<Image> imageList = imageRepository.findImagesByBelongTypeAndBelongId(
        type, id);
    List<String> urlList = new ArrayList<>();
    for (Image i:
    imageList) {
      String url = i.getUrl();
      urlList.add(url);
    }
    return urlList;
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
