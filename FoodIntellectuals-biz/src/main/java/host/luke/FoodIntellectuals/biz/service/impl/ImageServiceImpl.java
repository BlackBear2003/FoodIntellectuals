package host.luke.FoodIntellectuals.biz.service.impl;

import host.luke.FoodIntellectuals.biz.repository.ImageRepository;
import host.luke.FoodIntellectuals.biz.service.ImageService;
import host.luke.FoodIntellectuals.biz.service.QiniuService;
import host.luke.FoodIntellectuals.common.entity.Image;
import host.luke.FoodIntellectuals.common.vo.ImageVO;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService {

  private final ImageRepository imageRepository;
  private final QiniuService qiniuService;

  public ImageServiceImpl(ImageRepository imageRepository, QiniuService qiniuService) {
    this.imageRepository = imageRepository;
    this.qiniuService = qiniuService;
  }

  @Override
  public List<Image> findByBelongTypeAndId(String type, Long id) {
    return imageRepository.findImagesByBelongTypeAndBelongId(type, id);
  }

  @Override
  public Image save(ImageVO imageVO) {
    /* do qiniu*/
    String url = qiniuService.uploadImg(imageVO.getBase64());
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
