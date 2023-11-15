package host.luke.FoodIntellectuals.common.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Tag")
public class Tag {

  @Id
  private Long id;
  private String tagName;
  private Integer tagType;

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public String getTagName() {
    return tagName;
  }

  public void setTagName(String tagName) {
    this.tagName = tagName;
  }

  public Integer getTagType() {
    return tagType;
  }

  public void setTagType(Integer tagType) {
    this.tagType = tagType;
  }
}
