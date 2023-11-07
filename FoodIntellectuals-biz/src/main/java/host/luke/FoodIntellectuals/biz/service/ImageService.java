package host.luke.FoodIntellectuals.biz.service;

import host.luke.FoodIntellectuals.common.entity.Image;
import java.util.List;

public interface ImageService {

  List<Image> findByBelongTypeAndId();

}
