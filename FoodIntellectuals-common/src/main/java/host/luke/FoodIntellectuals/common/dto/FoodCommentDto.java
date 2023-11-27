package host.luke.FoodIntellectuals.common.dto;

import java.util.Date;

public class FoodCommentDto {

  private Long id;
  private Long foodId;
  private String content;
  private Date reviewTime;

  private Long userId;
  private String unionId;
  private String username;
  private String avatarUrl;

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

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Date getReviewTime() {
    return reviewTime;
  }

  public void setReviewTime(Date reviewTime) {
    this.reviewTime = reviewTime;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getUnionId() {
    return unionId;
  }

  public void setUnionId(String unionId) {
    this.unionId = unionId;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getAvatarUrl() {
    return avatarUrl;
  }

  public void setAvatarUrl(String avatarUrl) {
    this.avatarUrl = avatarUrl;
  }
}
