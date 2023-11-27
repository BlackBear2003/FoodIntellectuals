package host.luke.FoodIntellectuals.biz.service.impl;

import host.luke.FoodIntellectuals.biz.service.FoodLikeService;
import host.luke.FoodIntellectuals.redis.api.RedisQueryApi;
import host.luke.FoodIntellectuals.redis.api.RedisRecordApi;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodLikeServiceImpl implements FoodLikeService {

  @Autowired
  private RedisRecordApi redisRecordApi;
  @Autowired
  private RedisQueryApi redisQueryApi;

  @Override
  public void clickLike(long foodId, long userId) {
    String key = "FoodLike-" + foodId;
    Boolean flag = (Boolean) redisQueryApi.hGet(key, String.valueOf(userId));
    if (flag == null) {
      flag = false;
    }
    redisRecordApi.setH(key, String.valueOf(userId), !flag);
  }

  @Override
  public long getLikeNumByFoodId(long foodId) {
    String key = "FoodLike-" + foodId;
    Map<String, Object> map = redisQueryApi.hGetAll(key);
    AtomicLong num = new AtomicLong();
    map.keySet().stream().forEach(k -> {
      if (((Boolean) map.get(k))) {
        num.addAndGet(1);
      }
    });
    return num.get();
  }


}
