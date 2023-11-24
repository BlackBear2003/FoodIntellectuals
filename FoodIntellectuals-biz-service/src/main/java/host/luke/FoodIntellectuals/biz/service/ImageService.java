package host.luke.FoodIntellectuals.biz.service;

import host.luke.FoodIntellectuals.biz.entity.Image;
import host.luke.FoodIntellectuals.common.vo.ImageVO;
import java.util.List;

public interface ImageService {

  Image findById(Long imageId);

  List<Image> findByBelongTypeAndId(String type, Long id);

  Image save(ImageVO imageVO);

  /**
   * Delete images by belong type and id, might delete many.
   * @param type
   * @param id
   */
  void deleteByBelongTypeAndId(String type, Long id);

  void deleteByImageId(Long imageId);

}
