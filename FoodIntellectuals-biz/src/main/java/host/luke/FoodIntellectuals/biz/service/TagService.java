package host.luke.FoodIntellectuals.biz.service;

import host.luke.FoodIntellectuals.common.entity.Tag;
import java.util.List;

public interface TagService {

  List<Tag> searchTagByTagName(String tagName);

  List<Tag> findTagById(Long tagId);

  Tag save(Tag tag);

  List<Tag> findByType(String tagType);

}
