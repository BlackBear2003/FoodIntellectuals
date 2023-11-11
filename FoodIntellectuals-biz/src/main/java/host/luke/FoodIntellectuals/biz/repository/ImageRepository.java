package host.luke.FoodIntellectuals.biz.repository;

import host.luke.FoodIntellectuals.common.entity.Image;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {

  List<Image> findImagesByBelongTypeAndBelongId(String belongType, Long belongId);

  void deleteAllByBelongTypeAndBelongId(String belongType, Long belongId);
}
