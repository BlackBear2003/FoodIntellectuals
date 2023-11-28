package host.luke.FoodIntellectuals.biz.schedule;

import host.luke.FoodIntellectuals.biz.service.FoodLikeService;
import host.luke.FoodIntellectuals.biz.service.FoodService;
import host.luke.FoodIntellectuals.redis.api.RedisQueryApi;

import java.util.Map;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@Configuration
public class ScheduleTask {

  private final FoodService foodService;
  private final FoodLikeService foodLikeService;
  private final RedisQueryApi redisQueryApi;

  String likeNumKey = "FoodLikeNum";

  public ScheduleTask(FoodService foodService, FoodLikeService foodLikeService, RedisQueryApi redisQueryApi) {
    this.foodService = foodService;
    this.foodLikeService = foodLikeService;
    this.redisQueryApi = redisQueryApi;
  }

  @Scheduled(cron = "0/30 * * * * ?")
  void synchronizedRedisLike() {

    Map<String, Object> map = redisQueryApi.hGetAll(likeNumKey);

    map.keySet().forEach(key -> {
      long foodId = Long.parseLong(key);
      foodService.updateLikeNumByFoodId(foodId, ((int) map.get(key)));
    });

  }


}
