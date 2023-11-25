package host.luke.FoodIntellectuals.common.dto;

import java.util.Date;
import java.util.List;

public class ReviewDto {
  private Long id;
  private Long storeId;
  private Long foodId;
  private Long userId;
  private String content;
  private Integer storeScore;
  private Integer attitudeScore;
  private Integer foodScore;
  private Integer waitTimeScore;
  private Integer flavorScore;
  private Date reviewTime;
  private List<String> imgUrlList;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getStoreId() {
    return storeId;
  }

  public void setStoreId(Long storeId) {
    this.storeId = storeId;
  }

  public Long getFoodId() {
    return foodId;
  }

  public void setFoodId(Long foodId) {
    this.foodId = foodId;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Integer getStoreScore() {
    return storeScore;
  }

  public void setStoreScore(Integer storeScore) {
    this.storeScore = storeScore;
  }

  public Integer getAttitudeScore() {
    return attitudeScore;
  }

  public void setAttitudeScore(Integer attitudeScore) {
    this.attitudeScore = attitudeScore;
  }

  public Integer getFoodScore() {
    return foodScore;
  }

  public void setFoodScore(Integer foodScore) {
    this.foodScore = foodScore;
  }

  public Integer getWaitTimeScore() {
    return waitTimeScore;
  }

  public void setWaitTimeScore(Integer waitTimeScore) {
    this.waitTimeScore = waitTimeScore;
  }

  public Integer getFlavorScore() {
    return flavorScore;
  }

  public void setFlavorScore(Integer flavorScore) {
    this.flavorScore = flavorScore;
  }

  public Date getReviewTime() {
    return reviewTime;
  }

  public void setReviewTime(Date reviewTime) {
    this.reviewTime = reviewTime;
  }

  public List<String> getImgUrlList() {
    return imgUrlList;
  }

  public void setImgUrlList(List<String> imgUrlList) {
    this.imgUrlList = imgUrlList;
  }
}
