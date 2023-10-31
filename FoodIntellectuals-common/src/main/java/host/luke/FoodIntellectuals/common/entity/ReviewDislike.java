package host.luke.FoodIntellectuals.common.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ReviewDislike")
public class ReviewDislike {
    @Id
    private Long id;
    private Long reviewId;
    private Long userId;

    public ReviewDislike() {
    }

    public ReviewDislike(Long id, Long reviewId, Long userId) {
        this.id = id;
        this.reviewId = reviewId;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
