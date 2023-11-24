package host.luke.FoodIntellectuals.biz.controller;

import host.luke.FoodIntellectuals.biz.service.ReviewTimelineService;
import host.luke.FoodIntellectuals.common.dto.ResponseDto;
import host.luke.FoodIntellectuals.common.dto.ReviewTimelineDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/review/timeline")
@Api(tags = "评论时间线相关接口", description = "提供评论时间线相关操作的接口")
public class ReviewTimelineController {

  private final ReviewTimelineService reviewTimelineService;

  public ReviewTimelineController(ReviewTimelineService reviewTimelineService) {
    this.reviewTimelineService = reviewTimelineService;
  }

  @GetMapping("/userId")
  @ApiOperation(value = "根据用户ID获取最近5天的评论时间线", notes = "根据用户ID获取最近5天的评论时间线信息")
  public ResponseDto<List<ReviewTimelineDto>> findReviewTimelineOfLast5DaysByUserId(@RequestParam Long userId) {
    List<ReviewTimelineDto> timeLine = reviewTimelineService.findUserLastFiveDayReviewTimeLine(
        userId);

    return new ResponseDto<>(200, null, timeLine);
  }
}
