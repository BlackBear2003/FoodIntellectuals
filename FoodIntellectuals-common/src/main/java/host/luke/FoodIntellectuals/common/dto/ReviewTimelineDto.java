package host.luke.FoodIntellectuals.common.dto;

import java.util.Date;
import java.util.List;

public class ReviewTimelineDto {

  private Date date;
  private List<ReviewDto> timeline;

  public ReviewTimelineDto() {
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public List<ReviewDto> getTimeline() {
    return timeline;
  }

  public void setTimeline(List<ReviewDto> timeline) {
    this.timeline = timeline;
  }
}
