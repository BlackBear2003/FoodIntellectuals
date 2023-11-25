package host.luke.FoodIntellectuals.redis;

import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import host.luke.FoodIntellectuals.redis.api.RedisQueryApi;
import host.luke.FoodIntellectuals.redis.api.RedisRecordApi;
import host.luke.FoodIntellectuals.redis.api.impl.FoodIntellectualsRedisApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class FoodIntellectualsRedisAutoConfiguration {

  @Bean
  public RedisTemplate<String, Object> redisTemplate(
      RedisConnectionFactory redisConnectionFactory) {
    RedisTemplate<String, Object> template = new RedisTemplate<>();
    template.setConnectionFactory(redisConnectionFactory);

    StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
    FastJsonRedisSerializer fastJsonRedisSerializer = new FastJsonRedisSerializer(Object.class);

    // key采用String的序列化方式
    template.setKeySerializer(stringRedisSerializer);
    // hash的key也采用String的序列化方式
    template.setHashKeySerializer(stringRedisSerializer);
    // value序列化方式采用jackson
    template.setValueSerializer(fastJsonRedisSerializer);
    // hash的value序列化方式采用jackson
    template.setHashValueSerializer(fastJsonRedisSerializer);
    template.afterPropertiesSet();
    return template;
  }

  @Bean
  public RedisQueryApi redisQueryApi(RedisTemplate<String, Object> redisTemplate) {
    return new FoodIntellectualsRedisApi(redisTemplate);
  }

  @Bean
  public RedisRecordApi redisRecordApi(RedisTemplate<String, Object> redisTemplate) {
    return new FoodIntellectualsRedisApi(redisTemplate);
  }

}
