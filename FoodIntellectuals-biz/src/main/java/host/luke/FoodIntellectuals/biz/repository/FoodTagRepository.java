package host.luke.FoodIntellectuals.biz.repository;

import host.luke.FoodIntellectuals.common.entity.FoodTag;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodTagRepository extends JpaRepository<FoodTag, Long> {

  List<FoodTag> findByFoodId(long foodId);

//  List<FoodTag> findByTagType(Integer tagType);
//
//  List<FoodTag> searchFoodTagsByTagNameContainingIgnoreCase(String tagName, Pageable pageable);
}
