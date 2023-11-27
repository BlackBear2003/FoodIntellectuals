package host.luke.FoodIntellectuals.biz.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FoodScore")
public class FoodScore {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private long foodId;
  private long userId;
  private Double foodScore;

  public FoodScore() {
  }

  public FoodScore(Long id, Long foodId, Long userId, Double foodScore) {
    this.id = id;
    this.foodId = foodId;
    this.userId = userId;
    this.foodScore = foodScore;
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

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Double getFoodScore() {
    return foodScore;
  }

  public void setFoodScore(Double foodScore) {
    this.foodScore = foodScore;
  }
}
