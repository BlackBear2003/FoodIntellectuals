package host.luke.FoodIntellectuals.common.dto;

import host.luke.FoodIntellectuals.common.entity.Review;
import java.util.Date;
import java.util.List;

public class ReviewTimelineDto {

  private Date date;
  private List<Review> timeline;

  public ReviewTimelineDto() {
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public List<Review> getTimeline() {
    return timeline;
  }

  public void setTimeline(List<Review> timeline) {
    this.timeline = timeline;
  }
}
