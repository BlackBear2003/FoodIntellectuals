package host.luke.FoodIntellectuals.common.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FoodTag")
public class FoodTag {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Long foodId;
  private String tagName;
  private Integer tagType;

  public FoodTag() {
  }

  public FoodTag(Long id, Long foodId, String tagName, Integer tagType) {
    this.id = id;
    this.foodId = foodId;
    this.tagName = tagName;
    this.tagType = tagType;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getFoodId() {
    return foodId;
  }

  public void setFoodId(Long foodId) {
    this.foodId = foodId;
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
