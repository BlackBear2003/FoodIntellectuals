package host.luke.FoodIntellectuals.biz.repository;

import host.luke.FoodIntellectuals.common.entity.Tag;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
  Tag findByTagTypeAndTagName(Integer tagType, String tagName);
  List<Tag> findTagsByTagType(Integer tagType);
  List<Tag> searchTagsByTagNameContainingIgnoreCase(String tagName);
}
