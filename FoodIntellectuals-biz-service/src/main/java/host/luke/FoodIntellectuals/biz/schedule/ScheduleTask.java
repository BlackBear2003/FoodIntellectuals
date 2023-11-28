package host.luke.FoodIntellectuals.biz.schedule;

import host.luke.FoodIntellectuals.biz.service.FoodLikeService;
import host.luke.FoodIntellectuals.biz.service.FoodService;
import host.luke.FoodIntellectuals.common.dto.FoodDto;
import host.luke.FoodIntellectuals.redis.api.RedisQueryApi;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@Configuration
public class ScheduleTask {

  @Autowired
  private FoodService foodService;
  @Autowired
  private FoodLikeService foodLikeService;
  @Autowired
  private RedisQueryApi redisQueryApi;

  String likeNumKey = "FoodLikeNum";

  @Scheduled(cron = "0/30 * * * * ?")
  void synchronizedRedisLike() {

    Map<String, Object> map = redisQueryApi.hGetAll(likeNumKey);

    map.keySet().forEach(key -> {
      long foodId = Long.parseLong(key);
      foodService.updateLikeNumByFoodId(foodId, ((int) map.get(key)));
    });

  }


}
