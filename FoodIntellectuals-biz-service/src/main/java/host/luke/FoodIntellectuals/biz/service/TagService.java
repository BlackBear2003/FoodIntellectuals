package host.luke.FoodIntellectuals.biz.service;

import host.luke.FoodIntellectuals.biz.entity.Tag;
import java.util.List;

public interface TagService {

  List<Tag> searchTagByTagName(String tagName);

  Tag findTagById(Long tagId);

  Tag save(Tag tag);

  List<Tag> findByType(Integer tagType);

}
