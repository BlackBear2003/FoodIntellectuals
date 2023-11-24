package host.luke.FoodIntellectuals.biz.service.impl;

import host.luke.FoodIntellectuals.biz.repository.TagRepository;
import host.luke.FoodIntellectuals.biz.service.TagService;
import host.luke.FoodIntellectuals.biz.entity.Tag;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl implements TagService {
  private final TagRepository tagRepository;

  public TagServiceImpl(TagRepository tagRepository) {
    this.tagRepository = tagRepository;
  }

  @Override
  public List<Tag> searchTagByTagName(String tagName) {
    return tagRepository.searchTagsByTagNameContainingIgnoreCase(tagName);
  }

  @Override
  public Tag findTagById(Long tagId) {
    return tagRepository.findById(tagId).orElse(null);
  }

  @Override
  public Tag save(Tag tag) {
    return tagRepository.save(tag);
  }

  @Override
  public List<Tag> findByType(Integer tagType) {
    return tagRepository.findTagsByTagType(tagType);
  }
}
