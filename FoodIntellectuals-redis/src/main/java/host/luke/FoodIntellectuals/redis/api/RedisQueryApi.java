package host.luke.FoodIntellectuals.redis.api;

import host.luke.FoodIntellectuals.common.dto.FoodRankItem;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface RedisQueryApi {

  /* String*/
  Object get(String key);

  /* Hash*/
  Map<String, Object> hGetAll(String key);

  Object hGet(String key, String field);

  /* ZSet*/
  double getZSetMemberScore(String key, Object member);

  <T> List<T> getTopNFromZSet(String key, long n, Class<T> clazz);

  List<FoodRankItem> getTopFoodHotRank();
}
