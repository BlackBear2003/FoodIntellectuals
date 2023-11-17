package host.luke.FoodIntellectuals.biz.service;

import host.luke.FoodIntellectuals.common.dto.ReviewTimelineDTO;
import java.util.List;

public interface ReviewTimelineService {

  List<ReviewTimelineDTO> findUserLastFiveDayReviewTimeLine(Long userId);

}
