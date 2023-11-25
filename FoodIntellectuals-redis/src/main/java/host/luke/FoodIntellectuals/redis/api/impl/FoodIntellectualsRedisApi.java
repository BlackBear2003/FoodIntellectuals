package host.luke.FoodIntellectuals.redis.api.impl;

import host.luke.FoodIntellectuals.redis.api.RedisQueryApi;
import host.luke.FoodIntellectuals.redis.api.RedisRecordApi;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;

public class FoodIntellectualsRedisApi implements RedisQueryApi, RedisRecordApi {

  private final RedisTemplate<String, Object> redisTemplate;

  public FoodIntellectualsRedisApi(RedisTemplate<String, Object> redisTemplate) {
    this.redisTemplate = redisTemplate;
  }

  @Override
  public Object get(String key) {
    return redisTemplate.opsForValue().get(key);
  }

  @Override
  public Map<String, Object> hGetAll(String key) {
    HashOperations<String, String, Object> ops = redisTemplate.opsForHash();
    return ops.entries(key);
  }

  @Override
  public Object hGet(String key, String field) {
    HashOperations<String, String, Object> ops = redisTemplate.opsForHash();
    return ops.get(key, field);
  }

  @Override
  public double getZSetMemberScore(String key, Object member) {
    return redisTemplate.opsForZSet().score(key, member);
  }

  @Override
  public List<Object> getTopNFromZSet(String key, long n) {
    ZSetOperations<String, Object> ops = redisTemplate.opsForZSet();
    return new ArrayList<>(ops.reverseRange(key, 0, n-1));
  }

  @Override
  public void setS(String key, Object val) {
    setS(key, val, -1, TimeUnit.MILLISECONDS);
  }

  @Override
  public void setS(String key, Object val, long expiration, TimeUnit timeUnit) {
    redisTemplate.opsForValue().set(key, val, expiration, timeUnit);
  }

  @Override
  public void delS(String key) {
    redisTemplate.delete(key);
  }

  @Override
  public void incS(String key, long increment) {
    redisTemplate.opsForValue().increment(key, increment);
  }

  @Override
  public void batchSetS(Map<String, Object> map) {
    redisTemplate.opsForValue().multiSet(map);
  }

  @Override
  public void batchDelS(Set<String> keySet) {
    redisTemplate.delete(keySet);
  }

  @Override
  public void setH(String key, Object field, Object val) {
    redisTemplate.opsForHash().put(key, field, val);
  }

  @Override
  public void delH(String key, Object... fields) {
    redisTemplate.opsForHash().delete(key, fields);
  }

  @Override
  public void addZs(String key, Object member, double score) {
    redisTemplate.opsForZSet().add(key, member, score);
  }

  @Override
  public void delZs(String key, Object... members) {
    redisTemplate.opsForZSet().remove(key, members);
  }
}
