package host.luke.FoodIntellectuals.biz.service;

import host.luke.FoodIntellectuals.common.dto.ReviewTimelineDto;
import java.util.List;

public interface ReviewTimelineService {

  List<ReviewTimelineDto> findUserLastFiveDayReviewTimeLine(Long userId);

}
