package host.luke.FoodIntellectuals.common.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Review")
public class Review {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
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

  public Review() {
  }

  public Review(Long id, Long storeId, Long foodId, Long userId, String content, Integer storeScore,
      Integer attitudeScore, Integer foodScore, Integer waitTimeScore, Integer flavorScore) {
    this.id = id;
    this.storeId = storeId;
    this.foodId = foodId;
    this.userId = userId;
    this.content = content;
    this.storeScore = storeScore;
    this.attitudeScore = attitudeScore;
    this.foodScore = foodScore;
    this.waitTimeScore = waitTimeScore;
    this.flavorScore = flavorScore;
    this.reviewTime = new Date();
  }

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
}
