package host.luke.FoodIntellectuals.biz.service.impl;

import host.luke.FoodIntellectuals.biz.service.FoodLikeService;
import host.luke.FoodIntellectuals.common.dto.FoodDto;
import host.luke.FoodIntellectuals.redis.api.RedisQueryApi;
import host.luke.FoodIntellectuals.redis.api.RedisRecordApi;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

@Service
public class FoodLikeServiceImpl implements FoodLikeService {

  @Autowired
  private RedisRecordApi redisRecordApi;
  @Autowired
  private RedisQueryApi redisQueryApi;
  @Autowired
  private RedisTemplate redisTemplate;


  final String likeNumKey = "FoodLikeNum";

  @Override
  public void clickLike(long foodId, long userId) {
    String key = "FoodLikeStatus-" + foodId;

    boolean flag = isLiked(foodId, userId);
    redisRecordApi.setH(key, String.valueOf(userId), !flag);
    this.incrementFoodLikeNum(foodId, !flag? 1: -1);
  }

  @Override
  public boolean isLiked(long foodId, long userId) {
    String key = "FoodLikeStatus-" + foodId;
    Boolean flag = (Boolean) redisQueryApi.hGet(key, String.valueOf(userId));
    if (flag == null) {
      flag = false;
    }
    return flag;
  }

  void incrementFoodLikeNum(long foodId, long num) {
    HashOperations<String, String, Object> hashOperations = redisTemplate.opsForHash();
    ZSetOperations<String, String> zSetOperations = redisTemplate.opsForZSet();
    // 判断 hashKey 中的 foodId 是否存在
    if (hashOperations.hasKey(likeNumKey, String.valueOf(foodId))) {
      // foodId 存在，对其值进行累加操作
      hashOperations.increment(likeNumKey, String.valueOf(foodId), num);
    } else {
      // foodId 不存在，进行初始化操作
      hashOperations.put(likeNumKey, String.valueOf(foodId), 1);
    }
  }

  @Override
  public int getLikeNumByFoodId(long foodId) {

    Map<String, Object> map = redisQueryApi.hGetAll(likeNumKey);

    Object num = map.get(String.valueOf(foodId));

    return (int) num;
  }

  @Override
  public List<FoodDto> getTop10RankByLikeNum() {
    Map<String, Object> map = redisQueryApi.hGetAll(likeNumKey);

    return null;
  }


}
