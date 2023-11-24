package host.luke.FoodIntellectuals.biz.service.impl;

import host.luke.FoodIntellectuals.biz.repository.ReviewRepository;
import host.luke.FoodIntellectuals.biz.service.ReviewTimelineService;
import host.luke.FoodIntellectuals.common.dto.ReviewTimelineDto;
import host.luke.FoodIntellectuals.biz.entity.Review;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ReviewTimelineServiceImpl implements ReviewTimelineService {

  private final ReviewRepository reviewRepository;

  public ReviewTimelineServiceImpl(ReviewRepository reviewRepository) {
    this.reviewRepository = reviewRepository;
  }

  @Override
  public List<ReviewTimelineDto> findUserLastFiveDayReviewTimeLine(Long userId) {

    Date end = new Date();
    Date start = getDayMidnight(end);
    List<ReviewTimelineDto> res = new ArrayList<>();

    for (int i = 0; i < 5; i++) {
      List<Review> reviewList = reviewRepository.findReviewsByUserIdAndReviewTimeIsGreaterThanEqualAndReviewTimeLessThanEqual(
          userId, start, end);
      ReviewTimelineDto reviewTimeline = new ReviewTimelineDto();
      reviewTimeline.setTimeline(reviewList);
      reviewTimeline.setDate(start);
      res.add(reviewTimeline);
      end = start;
      start = getLastDay(start);
    }

    return res;
  }

  private Date getDayMidnight(Date currentDate) {

    // 创建一个Calendar对象，并设置为当前日期
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(currentDate);

    // 设置时间为0点0分0秒
    calendar.set(Calendar.HOUR_OF_DAY, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    calendar.set(Calendar.MILLISECOND, 0);

    // 获取修改后的日期对象
    return calendar.getTime();
  }

  private Date getLastDay(Date currentDate) {

    // 创建一个Calendar对象，并设置为当前日期
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(currentDate);

    calendar.add(Calendar.DAY_OF_YEAR, -1);

    // 获取修改后的日期对象
    return calendar.getTime();
  }

}
