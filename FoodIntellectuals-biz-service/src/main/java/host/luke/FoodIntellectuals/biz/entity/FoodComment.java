package host.luke.FoodIntellectuals.biz.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FoodComment")
public class FoodComment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private long foodId;
  private long userId;
  private String content;
  private Date commentTime;

  public FoodComment() {
  }

  public FoodComment(Long id, Long foodId, Long userId, String content, Date commentTime) {
    this.id = id;
    this.foodId = foodId;
    this.userId = userId;
    this.content = content;
    this.commentTime = commentTime;
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

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Date getCommentTime() {
    return commentTime;
  }

  public void setCommentTime(Date commentTime) {
    this.commentTime = commentTime;
  }
}
