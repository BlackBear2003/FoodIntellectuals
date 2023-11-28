package host.luke.FoodIntellectuals.redis.api;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public interface RedisRecordApi {

  /* String structure api*/
  void setS(String key, Object val);

  void setS(String key, Object val, long expiration, TimeUnit timeUnit);

  void delS(String key);

  void incS(String key, long increment);

  void batchSetS(Map<String, Object> map);

  void batchDelS(Set<String> keySet);

  /* hash structure api*/
  void setH(String key, Object field, Object val);

  void delH(String key, Object... fields);

  /* ZSet structure api*/
  void addZs(String key, Object member, Integer score);

  void delZs(String key, Object... members);


}
